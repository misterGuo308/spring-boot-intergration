package com.example.speingbootfilemanage.common.annoation;

import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.util.Assert;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.pattern.PathPattern;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author guoyou
 * @date 2020/1/17 10:49
 * 效验验证器只有在真正使用的时候才会被示例化,不需要自己加实例化注解
 */
public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

    /**
     * 获取配置文件中的值
     */
    @Resource
    private MultipartProperties multipartProperties;

    private long maxSize = 0;

    private long minSize = 0;

    private ValidFile validFile;

    private List<String> list = new ArrayList();


    @Override
    public void initialize(ValidFile constraintAnnotation) {
        this.validFile = constraintAnnotation;
        //支持文件集合
        Collections.addAll(list, validFile.endWith());
        Collections.addAll(list, validFile.value());
        if (validFile.maxSize().equals(ValidFile.DEFAULT_MAXSIZE)) {
            this.maxSize = parseSize(String.valueOf(multipartProperties.getMaxFileSize().toBytes()));
        } else {
            this.maxSize = parseSize(validFile.maxSize());
        }
        this.minSize = parseSize(validFile.minSize());

    }

    private long parseSize(String size) {
        Assert.hasLength(size, "文件长度不能未空");
        if (size.endsWith("KB")) {
            return Long.valueOf(size.substring(0, size.length() - 2)) * 1024;
        }
        if (size.endsWith("MB")) {
            return Long.valueOf(size.substring(0, size.length() - 2)) * 1024 * 1024;
        }
        return Long.valueOf(size);
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {

        String filename = file.getName();
        if (file.isEmpty()) {
            if (validFile.allowEmpty()) {
                return true;
            }
            validMessage("上传文件不能未空,参数名称为" + filename, context);
            return false;
        }
        //验证文件后缀名称
        String originalFilename = file.getOriginalFilename();
        if (validFile.ignoreCase()) {
            //将文件后缀名转成小写
            originalFilename = originalFilename.toLowerCase();
        }
        if (list.size() > 0 && list.stream().noneMatch(originalFilename::endsWith)) {
            validMessage("上传文件类型不符合要求,参数名为" + filename, context);
            return false;
        }

        //验证文件字节数
        long fileSize = file.getSize();
        if (fileSize < this.minSize) {
            validMessage("上传文件不能小于" + this.minSize + "个字节,参数名:" + filename, context);
            return false;
        }
        if (fileSize > this.maxSize) {
            validMessage("上传文件不能大于" + this.maxSize + "个字节,参数名:" + filename, context);
            return false;
        }
        return true;
    }

    private void validMessage(String message, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(validFile.message()+":"+message)
                .addConstraintViolation();
    }
}

package com.example.speingbootfilemanage.common.exception;

import cn.hutool.core.collection.CollUtil;
import com.example.speingbootfilemanage.common.enums.ResultEnum;
import com.example.speingbootfilemanage.common.utlis.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;

/**
 * @author guoyou
 * @date 2020/1/15 22:32
 */
@RestControllerAdvice
@Slf4j
public class GlobleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseResult error(MethodArgumentNotValidException e) {
        String message = getMessage(e.getBindingResult().getAllErrors());
        log.error("参数错误", e);
        return ResponseResult.fail(ResultEnum.PARAMENT_FAIL.getCode(), message);
    }

    private String getMessage(List<ObjectError> allErrors) {
        StringBuilder builder = new StringBuilder();
        if (CollUtil.isNotEmpty(allErrors)) {
            allErrors.forEach(p -> {
                builder.append(p.getDefaultMessage());
            });
        }
        return builder.length() > 0 ? builder.substring(0, builder.length() - 1) : ResultEnum.PARAMENT_FAIL.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult error(ConstraintViolationException e) {
        log.error("参数验证异常", e);
        return ResponseResult.fail(e.getMessage(), ResultEnum.FAIL_UPLOAD.getCode());
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult error(IOException e) {
        log.error("文件异常", e);
        return ResponseResult.fail(ResultEnum.FAIL_UPLOAD.getMessage(), ResultEnum.FAIL_UPLOAD.getCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult error(Exception e) {
        log.error("系统异常", e);
        return ResponseResult.fail();
    }
}

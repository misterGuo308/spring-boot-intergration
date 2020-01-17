package com.example.speingbootfilemanage.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.example.speingbootfilemanage.common.annoation.ValidFile;
import com.example.speingbootfilemanage.common.config.FileManageConfig;
import com.example.speingbootfilemanage.common.utlis.ResponseResult;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * @author guoyou
 * @date 2020/1/15 21:49
 */
@RestController
@RequestMapping("file")
@Validated
public class FileConteoller {

    @Resource
    private FileManageConfig fileManageConfig;

    @PostMapping("upload")
    public ResponseResult<String> upload(@RequestParam("file") @ValidFile(value = {".xlsx",".xls"},maxSize = "20KB",minSize = "5KB") MultipartFile file) throws IOException {
        File touch = FileUtil.touch(fileManageConfig.getUpload().getUrl(), file.getOriginalFilename());
        file.transferTo(touch);
        return ResponseResult.success(fileManageConfig.getUpload().getUrl() + file.getOriginalFilename());
    }
    @GetMapping("download")
    public void download(@RequestParam("path") @NotBlank(message = "文件参数不能为空") String path, HttpServletResponse response) throws IOException {
        BufferedInputStream in = FileUtil.getInputStream(path);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(FileUtil.getName(path), "UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        //将输入流拷贝到输出流中
        IoUtil.copy(in, out);
        //关闭输入输出流
        IoUtil.close(in);
        IoUtil.close(out);
    }

}

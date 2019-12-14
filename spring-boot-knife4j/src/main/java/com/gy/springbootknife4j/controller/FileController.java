package com.gy.springbootknife4j.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author guoyou
 * @date 2019/12/14 1:16
 */
@RestController
@Api(tags = "文件接口")
@RequestMapping("file")
public class FileController {

    @PostMapping("/uploadMateria1")
    @ApiOperation(value = "上传文件单个文件", notes = "测试文件上传")
    @ApiImplicitParam(name = "file", value = "文件", paramType = "form", dataType = "__File")
    public void  getFile(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
    }

    @PostMapping("/uploadMateria2")
    @ApiOperation(value = "上传文件多个个文件", notes = "测试文件上传")
    @ApiImplicitParam(name = "file", value = "文件", paramType = "form", dataType = "__File" ,allowMultiple = true)
    public void  getFile(@RequestParam("file") MultipartFile[] file) {

    }
}

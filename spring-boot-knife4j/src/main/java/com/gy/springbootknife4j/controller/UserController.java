package com.gy.springbootknife4j.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import com.gy.springbootknife4j.model.Resp;
import com.gy.springbootknife4j.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @author guoyou
 * @date 2019/12/13 14:58
 */
@RestController
@Api( tags = "用户类型接口")
@RequestMapping("/user")
public class UserController {

    @PostMapping("/save")
    @ApiOperation(value = "新增返回布尔类型", notes = "添加用户信息接口返回boolean类型")
    public Boolean save1(@RequestBody User user) {
        user = new User();
        user.setName("张");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return true;
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除返回包装类", notes = "根据名称进行删除返回通用类型")
    @ApiImplicitParam(name = "name", required = true, value = "名称", paramType = "query", dataType = "String" )
    public Resp<Boolean> delete( @RequestParam("name") String name) {
        return Resp.success(true);
    }

    @PutMapping("update")
    @ApiOperation(value = "修改返回通用包装类", notes = "添加用户信息接口返回通用类型")
    public Resp<Boolean> update(@RequestBody User user) {
        user = new User();
        user.setName("张");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return Resp.success(true);
    }

    @GetMapping("/getUser1")
    @ApiOperation(value = "搜索1", notes = "测试无查询条件返回实体")
    public User getUser1() {
        User user = new User();
        user.setName("张");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return user;
    }

    @GetMapping("/getUser3")
    @ApiOperation(value = "搜索多条件返回用户类型", notes = "测试多条件返回用户类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", required = true, value = "名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "age", required = true, value = "年龄", paramType = "query", dataType = "int")
    })
    public User getUser3(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return user;
    }

    @GetMapping("/getUser4")
    @ApiOperation(value = "搜索输入数组类型返回通用类型", notes = "测试数组")
    @ApiImplicitParam(name = "ages", required = true, value = "名称", paramType = "query", dataType = "int", allowMultiple = true)
    public User getUser3(@RequestParam("ages") Integer[] age) {
        User user = new User();
        user.setName("name");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return user;
    }

    @GetMapping("/getUser5")
    @ApiOperation(value = "搜索输入非必传参数", notes = "测试非必传")
    @ApiImplicitParam(name = "age", value = "名称", paramType = "query", dataType = "int")
    public Resp<User> getUser5(@RequestParam("age") Integer age) {
        User user = new User();
        user.setName("name");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return Resp.success(user);
    }

    @GetMapping("/getUser6")
    @ApiOperation(value = "搜索测试heand中传值", notes = "测试heand")
    @ApiImplicitParam(value = "headerparam",name = "headerparam",dataType = "string")
    public  Resp<User> getUser6(@RequestHeader("headerparam") String headerparam) {
        User user = new User();
        user.setName("name");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return Resp.success(user);
    }

    @GetMapping("/getUser7/{path}")
    @ApiOperation(value = "搜索设置路径中传值", notes = "测试heand")
    @ApiImplicitParam(value = "参数",name = "path",dataType = "string" ,paramType = "path")
    public  Resp<User> getUser7(@PathVariable("path") String path) {
        User user = new User();
        user.setName("name");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return Resp.success(user);
    }


}

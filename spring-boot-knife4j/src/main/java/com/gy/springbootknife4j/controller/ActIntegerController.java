package com.gy.springbootknife4j.controller;

import com.gy.springbootknife4j.model.ActInteger;
import com.gy.springbootknife4j.model.Resp;
import com.gy.springbootknife4j.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author guoyou
 * @date 2019/12/14 0:51
 */
@RestController
@Api(tags = "不同类型参数设置")
@RequestMapping("actInteger")
public class ActIntegerController {

    @PostMapping("/save")
    @ApiOperation(value = "测试不同类型参数保存", notes = "返回值通用包装类")
    public Resp<Boolean> save(@RequestBody ActInteger actInteger) {

        return Resp.success(true);
    }

    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "搜索测试不同类型参数", notes = "添加自定义响应")
    @ApiImplicitParam(value = "参数", name = "longName", dataType = "Long", paramType = "query")
    @GetMapping("getActInteger1")
    public Resp<ActInteger> getActInteger1(@RequestParam("longName") Long longName) {
        ActInteger actInteger = new ActInteger();
        return Resp.success(actInteger);
    }


    @ApiOperation(value = "搜索测试不同类型参数", notes = "添加自定义响应")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Long类型", name = "number", dataType = "long"),
            @ApiImplicitParam(value = "BigDecimal类型属性", name = "price", dataType = "bigdecimal"),
            @ApiImplicitParam(value = "float类型属性", name = "float1", dataType = "float"),
            @ApiImplicitParam(value = "double类型属性", name = "doub1", dataType = "double"),
            @ApiImplicitParam(value = "int类型", name = "sort", dataType = "int"),
    })
    @GetMapping("getActInteger2")
    public Resp<ActInteger> getActInteger2(Long number, BigDecimal price, float float1, double doub1, int sort) {
        ActInteger actInteger = new ActInteger();
        return Resp.success(actInteger);
    }
}

package com.gy.springbootknife4j.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author guoyou
 * @date 2019/12/13 14:51
 */
@Data
@ApiModel(description = "用户类描述")
public class User {
    @ApiModelProperty(value = "名称" ,required = true ,example = "张")
    private String name ;
    @ApiModelProperty(value = "年龄",required = true,example = "18")
    private Integer age;
    @ApiModelProperty(value = "创建时间" ,required = true ,example = "2019-12-12 1:06:22")
    private LocalDateTime createTime;
}

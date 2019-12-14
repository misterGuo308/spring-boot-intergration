package com.gy.springbootknife4j.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author guoyou
 * @date 2019/12/13 14:49
 */
@Data
@ApiModel
public class ActInteger {

    @ApiModelProperty(value = "Long类型")
    private Long number;
    @ApiModelProperty(value = "BigDecimal类型属性")
    private BigDecimal price;
    @ApiModelProperty(value = "float类型属性")
    private float float1;
    @ApiModelProperty(value = "double类型属性")
    private double doub1;
    @ApiModelProperty(value = "int类型")
    private int sort;
}

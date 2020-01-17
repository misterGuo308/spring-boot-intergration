package com.example.speingbootfilemanage.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author guoyou
 * @date 2020/1/15 22:17
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    /**
     * 返回结果枚举
     */
    SUCCESS_UPLOAD("200", "文件上传成功"),
    SYSTEM_FAIL("500", "系统错误"),
    PARAMENT_FAIL("400", "参数错误"),
    FAIL_UPLOAD("601", "文件操作失败");
    private String code;

    private String message;

}

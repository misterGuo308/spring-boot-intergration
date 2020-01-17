package com.example.speingbootfilemanage.common.utlis;

import com.example.speingbootfilemanage.common.enums.ResultEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guoyou
 * @date 2020/1/15 22:05
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseResult<T> {

    private boolean isSuccess;

    private String message;

    private String code;

    private T data;


    public static <T> ResponseResult<T> success() {
        return new <T>ResponseResult<T>(true, ResultEnum.SUCCESS_UPLOAD.getMessage(), ResultEnum.SUCCESS_UPLOAD.getCode(), null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new <T>ResponseResult<T>(true, ResultEnum.SUCCESS_UPLOAD.getMessage(), ResultEnum.SUCCESS_UPLOAD.getCode(), data);
    }

    public static <T> ResponseResult<T> fail() {
        return new <T>ResponseResult<T>(false, ResultEnum.SYSTEM_FAIL.getMessage(), ResultEnum.SYSTEM_FAIL.getCode(), null);
    }

    public static <T> ResponseResult<T> fail(String code, String message) {
        return new <T>ResponseResult<T>(false, message, code, null);
    }
}

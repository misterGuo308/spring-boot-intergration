package com.gy.springbootknife4j.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * <pre>
 *  Desc: Restful统一Json响应对象封装
 * </pre>
 *
 * @author liuzg
 * @date 2019/10/16 9:53
 **/
@ApiModel(description = "通用接口返回类")
public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static String SUCCESS_CODE = "200";

    /**
     * 返回状态码
     */
    @ApiModelProperty(required = true, notes = "返回状态码", example = "200")
    private String status;

    /**
     * 返回消息
     */
    @ApiModelProperty(required = true, notes = "返回消息", example = "请求成功")
    private String message;

    /**
     * 返回内容
     */
    @ApiModelProperty(required = true, notes = "返回数据")
    private T result;

    /**
     * 其他内容
     */
    @JsonIgnore
    private Map<String, Object> ext;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }


    public Resp() {
        this.status = SUCCESS_CODE;
        this.message = "SUCCESS";
    }

    public Resp(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Resp(String status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public Resp(String status, String message, T result, Map<String, Object> ext) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.ext = ext;
    }

    //快速返回成功
    public static <T> Resp success() {
        return new Resp<T>(SUCCESS_CODE, "请求成功", null);
    }

    public static <T> Resp success(T result) {
        return new Resp<T>(SUCCESS_CODE, "请求成功", result);
    }

    public static <T> Resp success(String message, T result) {
        return new Resp<T>(SUCCESS_CODE, message, result);
    }

    public static <T> Resp success(String message, T result, Map<String, Object> extra) {
        return new Resp<T>(SUCCESS_CODE, message, result, extra);
    }
}
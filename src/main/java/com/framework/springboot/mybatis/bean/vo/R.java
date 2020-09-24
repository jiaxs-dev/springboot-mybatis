package com.framework.springboot.mybatis.bean.vo;

/**
 * @author 贾先笋
 * @date 2019/8/3 15:21
 * @description controller统一返回结果类
 */
public class R {
    private int code;//状态 如200、500等
    private String message;//消息 如异常欣喜等
    private Object result;//请求结果

    public R(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static R suceess() {
        return new R(200, "success", true);
    }

    public static R suceess(Object result) {
        return new R(200, "success", result);
    }

    public static R fail() {
        return new R(500, "fail", false);
    }

    public static R error() {
        return new R(500, "An unknown error occurred.", null);
    }

    public static R error(int code, String message) {
        return new R(code, message);
    }

    public static R error(String message) {
        return new R(500, message, null);
    }

    public static R notFound() {
        return new R(404, "未找到相应的信息", null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

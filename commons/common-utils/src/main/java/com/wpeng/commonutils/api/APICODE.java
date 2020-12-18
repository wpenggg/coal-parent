package com.wpeng.commonutils.api;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/17 19:38
 * <p>
 * 统一数据格式
 */
@Data
public class APICODE {

    private Integer code;

    private String message;

    private Boolean success;

    private Map<String, Object> dataMap = new HashMap<>();

    private APICODE() {

    }

    public static APICODE OK() {
        APICODE apicode = new APICODE();
        apicode.setCode(ResultCode.SUCCESS);
        apicode.setMessage("服务调用成功！^_^");
        apicode.setSuccess(true);
        return apicode;
    }

    public static APICODE SORRY() {
        APICODE apicode = new APICODE();
        apicode.setCode(ResultCode.ERROR);
        apicode.setMessage("服务调用失败！┭┮﹏┭┮");
        apicode.setSuccess(false);
        return apicode;
    }


    /**
     * 链式编程   ...
     * @param code
     * @return
     */
    public APICODE code(Integer code) {
        this.setCode(code);
        return this;
    }

    public APICODE message(String message) {
        this.setMessage(message);
        return this;
    }

    public APICODE success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public APICODE dataMap(String key, Object value) {
        this.dataMap.put(key, value);
        return this;
    }

    public APICODE dataMap(Map<String, Object> dataMap) {
        this.setDataMap(dataMap);
        return this;
    }

}

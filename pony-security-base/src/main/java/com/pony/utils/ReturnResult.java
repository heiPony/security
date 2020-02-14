package com.pony.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.management.snmp.util.MibLogger;

@Data //自动生成getter/setter
public class ReturnResult {
    private static Logger logger = LoggerFactory.getLogger(ReturnResult.class);
    // 响应业务状态
    private Integer code;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;

    public ReturnResult() {
    }
    public ReturnResult(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }
    public ReturnResult(String message, Object data) {
        this.code = 200;
        this.message = message;
        this.data = data;
    }

    public ReturnResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ReturnResult ok() {
        return new ReturnResult(null);
    }
    public static ReturnResult ok(String message) {
        return new ReturnResult(message, null);
    }
    public static ReturnResult ok(Object data) {
        return new ReturnResult(data);
    }
    public static ReturnResult ok(String message, Object data) {
        return new ReturnResult(message, data);
    }

    public static ReturnResult build(Integer code, String message) {
        return new ReturnResult(code, message, null);
    }

    public static ReturnResult build(Integer code, String message, Object data) {
        return new ReturnResult(code, message, data);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }


    /**
     * JSON字符串转成 ReturnResult 对象
     * @param json
     * @return
     */
    public static ReturnResult format(String json) {
        try {
            return JSON.parseObject(json, ReturnResult.class);
        } catch (Exception e) {
            logger.info("JSON字符串转成 ReturnResult 对象异常："+e.getMessage(),e);
        }
        return null;
    }

}

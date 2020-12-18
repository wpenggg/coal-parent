package com.wpeng.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/18 10:44
 * <p>
 * 自定义异常返回数据格式类
 */
@Data
@AllArgsConstructor //构造函数
@NoArgsConstructor  //无参构造函数
public class WpengException extends RuntimeException {

    /**
     * 状态码
     */
    private Integer code;


    /**
     * 消息
     */
    private String msg;



}

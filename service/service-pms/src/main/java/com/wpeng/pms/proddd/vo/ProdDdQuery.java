package com.wpeng.pms.proddd.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/18 11:45
 *
 * 查询条件封装类
 */
@Data
public class ProdDdQuery {

    private String orderName; //指令名称

    private int orderType; //指令类型

    private Date gmtCreateStart; //添加开始时间

    private Date gmtCreateEnd; //添加结束时间

}

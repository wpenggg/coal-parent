package com.wpeng.pms.proddd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/14 11:04
 *
 * 【管理-生产调度-实体类】
 */
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pms_prod_dd")
public class ProdDd {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator_uuid")
    @GenericGenerator(name = "generator_uuid", strategy = "uuid")
    @ApiModelProperty(value = "主键,采用hibernate的uuid生成32位字符串")
    private String id;


    @ApiModelProperty(value = "指令名称")
    @Column(name = "order_name")
    private String orderName;

    @ApiModelProperty(value = "指令类型")
    @Column(name = "order_type")
    private int orderType;

    @ApiModelProperty(value = "指令描述")
    @Column(name = "order_des")
    private String orderDes;

    @ApiModelProperty(value = "指令优先级")
    @Column(name = "order_yxj")
    private int orderYxj;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "添加时间")
    @Column(name = "gmt_create", nullable = false, updatable = false) // nullable默认为 true 表示数字可以为空; updatable 修改时没有新增时间
    private Date gmtCreate;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @LastModifiedDate
    @ApiModelProperty(value = "修改时间")
    @Column(name = "gmt_modified", nullable = false, insertable = false)
    private Date gmtModified;


}

package com.example.demo.entity;

import com.example.demo.base.BaseEntity;
import com.example.demo.enumeration.EventStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author chenxiang
 */
@Entity
@Table(name = "PF_TEST_T")
@Getter
@Setter
public class TestEntity extends BaseEntity {

    @Column(name = "name", columnDefinition = "varchar(255) NOT NULL DEFAULT '' COMMENT '名字'")
    private String name;

    @Column(name = "age", columnDefinition = "int(10)  COMMENT '年龄'")
    private Integer age;

    @Column(name = "birthday", columnDefinition = "date DEFAULT NULL COMMENT '生日'")
    private LocalDate birthday;

    @Column(name = "home_address", columnDefinition = "varchar(255) NOT NULL DEFAULT '' COMMENT '家庭住址'")
    private String homeAddress;

    @Column(name = "event_status", columnDefinition = "varchar(64) DEFAULT 'EVENT_UNPUBLISHED' COMMENT '事件状态(-2事件未发布 -1关闭事件 0办理中 1事件结束)'")
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @Column(name = "is_marry", columnDefinition = "varchar(255) NOT NULL DEFAULT '是' COMMENT '是否结婚'")
    private String isMarry;
}

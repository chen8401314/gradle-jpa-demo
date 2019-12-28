package com.example.demo.entity;

import com.example.demo.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
}

package com.example.demo.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author chenxiang
 */

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", columnDefinition = "varchar(32) NOT NULL COMMENT '主键ID'")
    private String id;

   @Column(name = "create_time",columnDefinition = "datetime(6) DEFAULT NULL COMMENT '创建时间'")
    private ZonedDateTime createTime;

    @PrePersist
    public void prePersist() {
        createTime = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}

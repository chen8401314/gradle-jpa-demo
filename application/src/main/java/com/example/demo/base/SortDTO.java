package com.example.demo.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title: 排序DTO
 * @Description:
 * @Author: chenx
 * @Date: 2019/3/13
 */
@Getter
@Setter
public class SortDTO {
    /**
     * 排序方式
     */
    private String orderType;

    /**
     * 排序字段
     */
    private String orderField;

    public SortDTO(String orderType, String orderField) {
        this.orderType = orderType;
        this.orderField = orderField;
    }

    /**
     * 默认为DESC排序
     *
     * @param orderField
     */
    public SortDTO(String orderField) {
        this.orderField = orderField;
        this.orderType = "desc";
    }
}

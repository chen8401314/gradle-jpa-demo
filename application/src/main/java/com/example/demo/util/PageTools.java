package com.example.demo.util;

import com.example.demo.base.SortDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageTools {
    /**
     * 获取基础分页对象
     *
     * @param page     获取第几页
     * @param size     每页条数
     * @param sortDTOs 排序对象数组
     * @return
     */
    public static Pageable basicPage(Integer page, Integer size, SortDTO... sortDTOs) {
        if(page == null || page < 1){
            page = 1;
        }
        if(size == null || size <= 0){
            size = 15;
        }
        return PageRequest.of(page - 1, size);
    }

    /**
     * 获取基础分页对象
     *
     * @param page 获取第几页
     * @param size 每页条数
     * @return
     */
    public static Pageable basicPage(Integer page, Integer size) {
        if(page == null || page < 1){
            page = 1;
        }
        if(size == null || size <= 0){
            size = 15;
        }
        return PageRequest.of(page - 1, size);
    }

    /**
     * 获取基础分页对象，每页条数默认15条
     * - 默认以id降序排序
     *
     * @param page 获取第几页
     * @return
     */
    public static Pageable basicPage(Integer page) {
        return basicPage(page, 0, new SortDTO("desc", "createTime"));
    }

    /**
     * 获取基础分页对象，每页条数默认15条
     *
     * @param page     获取第几页
     * @param sortDTOs 排序对象数组
     * @return
     */
    public static Pageable basicPage(Integer page, SortDTO... sortDTOs) {
        return basicPage(page, 0, sortDTOs);
    }

    /**
     * 获取基础分页对象，排序方式默认降序
     *
     * @param page       获取第几页
     * @param size       每页条数
     * @param orderField 排序字段
     * @return
     */
    public static Pageable basicPage(Integer page, Integer size, String orderField) {
        return basicPage(page, size, new SortDTO("desc", orderField));
    }

    /**
     * 获取基础分页对象
     * - 每页条数默认15条
     * - 排序方式默认降序
     *
     * @param page       获取第几页
     * @param orderField 排序字段
     * @return
     */
    public static Pageable basicPage(Integer page, String orderField) {
        return basicPage(page, 0, new SortDTO("desc", orderField));
    }

    private PageTools() { throw new IllegalStateException("Utility class"); }
}

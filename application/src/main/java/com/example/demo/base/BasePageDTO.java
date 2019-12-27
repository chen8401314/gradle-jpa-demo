package com.example.demo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author chenxiang
 */
@Data
@NoArgsConstructor
public class BasePageDTO<T> {

    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    @ApiModelProperty(value = "总条数")
    private Long totalElements;

    @ApiModelProperty(value = "当前页")
    private Integer page;

    @ApiModelProperty(value = "页大小")
    private Integer size;

    @ApiModelProperty(value = "页大小")
    private List<T> content;

    public BasePageDTO(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.page = page.getNumber() + 1;
        this.size = page.getSize();
        this.content = page.getContent();
    }
}

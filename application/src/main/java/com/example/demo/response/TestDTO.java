package com.example.demo.response;

import com.example.demo.base.BaseDTO;
import com.example.demo.enumeration.EventStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * @author chenxiang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="test对象",description="对象test")
public class TestDTO extends BaseDTO {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "状态")
    private EventStatus eventStatus;

    @ApiModelProperty(value = "是否结婚")
    private String isMarry;
}

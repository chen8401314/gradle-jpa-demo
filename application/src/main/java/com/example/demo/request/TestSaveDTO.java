package com.example.demo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author chenxiang
 */
@Data
@ApiModel(value="test1对象",description="对象test1")
public class TestSaveDTO {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;
}

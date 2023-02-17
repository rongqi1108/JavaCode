package com.rong.pojo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: RQ
 * @Date: 2023-02-17 19:17:19
 */
public class PersonAddDTO {
    @NotBlank(message = "姓名不能为空")
    @Length(min = 5, max = 16, message = "账号长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

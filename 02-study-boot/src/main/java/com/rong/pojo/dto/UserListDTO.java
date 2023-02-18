package com.rong.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ryan
 * @time 2023/2/18 11:38 上午
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserListDTO {
    private Long id;
    private String name;
    private String password;
    private List<String> pictureList;

}

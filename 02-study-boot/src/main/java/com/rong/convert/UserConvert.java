package com.rong.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.rong.pojo.dto.UserDTO;
import com.rong.pojo.dto.UserDTOSame;
import com.rong.pojo.dto.UserListDTO;
import com.rong.pojo.po.Person;
import com.rong.pojo.po.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Ryan
 * @time 2023/2/18 11:36 上午
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserDTOSame convertToUserDTOSame(User user);//完全一样的 全部拷贝

    UserDTO convert1(User user);//名称不一样的不拷贝，类型不一样的会帮你转换，自己注意范围

    @Mapping(source = "password", target = "pwd")
    UserDTO convert2(User user);

    /*2个dto 拼成一个*/
    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "person.name", target = "name")
    UserDTO convert4(User user, Person person);

    /*通过自定义方法 转换*/
    @Mapping(source = "pictureUrls", target = "pictureList", qualifiedByName = "translateUserListDTOToUser")
    UserListDTO convert5(User user);

    @Named("translateUserListDTOToUser")
    default List<String> translateUserListDTOToUser(String str){
        return StrUtil.split(str, ",");
    }

}

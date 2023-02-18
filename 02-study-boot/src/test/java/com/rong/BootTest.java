package com.rong;

import com.rong.convert.UserConvert;
import com.rong.pojo.dto.UserDTO;
import com.rong.pojo.dto.UserDTOSame;
import com.rong.pojo.dto.UserListDTO;
import com.rong.pojo.po.Person;
import com.rong.pojo.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author Ryan
 * @time 2023/2/14 10:38 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@AutoConfigureMockMvc
public class BootTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void getPerson1() throws Exception{
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/get/person/1"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
        resultActions.andDo(MockMvcResultHandlers.print());// 打印结果
    }

    @Test
    public void getPerson2() throws Exception{
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/get/person/2")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
        resultActions.andDo(MockMvcResultHandlers.print());// 打印结果
    }

    @Test
    public void mapStruct() {
        System.out.println("成功运行……");
        User user = new User(1L, "rq", "pwd", "/abc/d,/dgd/23");
        Person person = new Person(2L, "戎旗");
        UserDTO rq = UserConvert.INSTANCE.convert1(user);
        UserDTO rq2 = UserConvert.INSTANCE.convert2(user);
        UserDTO rq3 = UserConvert.INSTANCE.convert4(user, person);
        UserListDTO rq4 = UserConvert.INSTANCE.convert5(user);
        UserDTOSame same = UserConvert.INSTANCE.convertToUserDTOSame(user);
        System.out.println(rq);
        System.out.println(rq2);
        System.out.println(rq3);
        System.out.println(rq4);
        System.out.println(same);
    }
}

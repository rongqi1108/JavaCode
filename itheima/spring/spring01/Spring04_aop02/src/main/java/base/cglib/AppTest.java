package base.cglib;

import com.rong.UserService;
import com.rong.impl.UserServiceImpl;

public class AppTest {
    public static void main(String[] args) {
        UserService userService = UserServiceCglibProxy.createUserServiceCglibProxy(UserServiceImpl.class);
        System.out.println(userService);
        userService.save();

    }
}

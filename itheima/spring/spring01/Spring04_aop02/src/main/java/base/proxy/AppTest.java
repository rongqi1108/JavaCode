package base.proxy;

import com.rong.UserService;
import com.rong.impl.UserServiceImpl;

public class AppTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        //代理对象
        UserService proxy = UserServiceJdkProxy.createUserServiceJdkProxy(userService);
        proxy.save();
    }
}

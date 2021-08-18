package base.decorator;

import com.rong.impl.UserServiceImpl;

//静态代理的装饰模式
public class AppTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceImplDecorator userServiceImplDecorator = new UserServiceImplDecorator(userService);
        UserServiceImplDecorator userServiceImplDecorator2 = new UserServiceImplDecorator(userServiceImplDecorator);
        userServiceImplDecorator2.save();
    }
}

package base.decorator;

import com.rong.UserService;

public class UserServiceImplDecorator implements UserService {
    private UserService userService;

    public UserServiceImplDecorator(UserService userService) {
        this.userService = userService;
    }

    //静态代理的装饰模式
    public void save() {
        userService.save();

        //增强功能
        System.out.println("刮大白");
    }
}

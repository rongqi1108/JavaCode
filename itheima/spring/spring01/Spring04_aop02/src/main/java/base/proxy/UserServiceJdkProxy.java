package base.proxy;

import com.rong.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceJdkProxy {
    public static UserService createUserServiceJdkProxy(UserService userService){
        UserService o =(UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = method.invoke(userService, args);
                        System.out.println("刮大白");
                        return invoke;
                    }
                }
        );
        return o;
    }

}

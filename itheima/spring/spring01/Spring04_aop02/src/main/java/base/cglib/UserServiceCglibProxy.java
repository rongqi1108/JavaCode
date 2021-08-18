package base.cglib;

import com.rong.UserService;
import com.rong.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceCglibProxy {
    public static UserService createUserServiceCglibProxy(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                Object inv = methodProxy.invokeSuper(o, args);
                if(method.getName().equals("save")){
                    System.out.println("刮大白");
                }

                return inv;
            }
        });
        UserService userService = (UserService) enhancer.create();
        return userService;
    }
}

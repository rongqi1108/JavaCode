import com.rong.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    @Test
    public void test01(){
        //加载配置文件
        ApplicationContext cpxac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取资源
//        UserService userServiece = (UserService) cpxac.getBean("userService");
        UserService userServiece = (UserService) cpxac.getBean("service1");
        userServiece.save();
    }
}

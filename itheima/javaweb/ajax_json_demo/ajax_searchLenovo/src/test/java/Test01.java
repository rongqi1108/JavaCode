import com.rong.bean.User;
import com.rong.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    @Test
    public void selectLikeDemo() throws Exception{
        InputStream is = null;
        SqlSession sqlSession = null;

        is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession =factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectLike("张");
//        List<User> users = mapper.selectAll();

        for(User user:users){
            System.out.println(user.toString());
        }
        is.close();
        sqlSession.close();

    }
}

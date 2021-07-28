import com.rong.bean.User;
import com.rong.mapper.UserMapper;
import com.rong.utils.GetSqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestDemo {
    @Test
    public void selectAll(){
        InputStream is = null;
        SqlSession sqlSession = null;
        SqlSessionFactory factory = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.getUsers();
            System.out.println();
            for(User user : users){
                System.out.println(user.toString());
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSession.close();
        }

    }

    @Test
    public void insert(){
        SqlSession sqlSession = GetSqlSession.get();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("11111113", "zhangsan003", "zhuliu", "6666", "朱六", "男", new Date("2007/11/09"), new Date("2006/10/01"));
        String s = user.toString();
        mapper.insertUser(user);
        sqlSession.close();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = GetSqlSession.get();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser("11111113");
        sqlSession.close();
    }

    @Test
    public void update(){
        SqlSession sqlSession = GetSqlSession.get();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("11111112", "lisi002", "lisi", "5678", "李四", "男", new Date("2007/11/01"), new Date("2006/10/01"));
        mapper.updateUser(user);
        sqlSession.close();
    }

}

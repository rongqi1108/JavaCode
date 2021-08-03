import com.rong.bean.News;
import com.rong.mapper.NewsMapper;
import com.rong.service.NewsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo01 {
    @Test
    public void test(){
        List<News> newses = null;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession(true);
            NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
            newses = mapper.selectAll();
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
        for(News news :newses){
            System.out.println(news.toString());
        }
    }
}

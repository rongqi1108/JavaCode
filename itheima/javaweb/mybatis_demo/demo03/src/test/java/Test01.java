import com.rong.bean.*;
import com.rong.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class Test01 {
    @Test
    public void oneToOne() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        CardMapper mapper = sqlSession.getMapper(CardMapper.class);
        List<Card> cards = mapper.selectAllCard();
        for(Card c : cards){
            System.out.println(c.toString());
        }
        is.close();
        sqlSession.close();
    }

    @Test
    public void oneToMany() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);
        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);

        List<Classes> classes = mapper.selectAll();
        for(Classes cls : classes){
            System.out.println(cls.getId() +","+ cls.getName());
            List<Student2> students = cls.getStudents();
            for(Student2 stu:students){
                System.out.print("    ");
                System.out.println(stu.getId()+","+stu.getName()+","+stu.getAge());
            }
        }
        is.close();
        sqlSession.close();
    }

    @Test
    public void manyToMany() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);
        Student2Mapper mapper = sqlSession.getMapper(Student2Mapper.class);
        List<Student2> student2s = mapper.selectAll();
       for(Student2 s : student2s){
           System.out.println(s.toString());
           List<Course> courses = s.getCourses();
           for(Course c:courses){
               System.out.println(c.toString());
           }
       }
        is.close();
        sqlSession.close();
    }






}

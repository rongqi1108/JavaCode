import com.github.pagehelper.PageHelper;
import com.rong.bean.Student;
import com.rong.mapper.StudentMapper;
import com.rong.utils.GetSqlsession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TestDemo {
    @Test
    public void selectAll() {
        InputStream is = null;
        SqlSessionFactory factory = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();//true开启自动提交
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            List<Student> students = mapper.selectAll();
            for (Student stu : students) {
                System.out.println(stu.getSid() + "," + stu.getName() + "," + stu.getAge() + "," + stu.getBirthday());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void insert() {
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = new Student(9, "徐克", 23, new Date("1999/06/17"));
        mapper.insertStudent(stu);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() {
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudent(5);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update(){
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student s1 = new Student(5, "臧德川", 21, new Date("2000/02/02"));
        mapper.updateStudent(s1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectOne(){
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu1 = mapper.getOne(6, "德川");
        System.out.printf(stu1.toString());
        sqlSession.close();
    }

    @Test
    public void selectOne2(){
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",5);
        map.put("na","臧德川");
        Student stu = mapper.getOne2(map);
        System.out.printf(stu.toString());
        sqlSession.close();
    }

    @Test
    public void selectCondition(){
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setAge(25);
        student.setSid(3);
        student.setName("王五");
        List<Student> students = mapper.selectCondition(student);
        for (Student s : students) {
            System.out.println(s.toString());
        }
        sqlSession.close();
    }

    @Test
    public void selectByIds(){
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        mapper.selectByIds(list);
        sqlSession.close();
    }

    @Test
    public void pageHelper(){
        SqlSession sqlSession = GetSqlsession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//第几页 显示几个
        PageHelper.startPage(3,3);
        List<Student> students = mapper.selectAll();
        for (Student s : students) {
            System.out.println(s.toString());
        }
        sqlSession.close();
    }

}

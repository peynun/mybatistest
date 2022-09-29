package edu.gdkm.test;

import java.io.IOException;
import java.io.Reader;

import edu.gdkm.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class StudentTest {
    @Test
    public void userFindByIdTest(){
        String resources="mybatis-config.xml";
        try {
            Reader reader=Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
            SqlSession session=sqlMapper.openSession();
            Student student=session.selectOne("edu.gdkm.pojo.Student.findById",2);
            System.out.println(student);
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

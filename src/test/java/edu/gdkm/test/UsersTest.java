package edu.gdkm.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import edu.gdkm.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class UsersTest {
    @Test
    public void userFindByIdTest(){
        String resources="mybatis-config.xml";
        try {
            Reader reader=Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
            SqlSession session=sqlMapper.openSession();
            Users users=session.selectOne("edu.gdkm.pojo.Users.findById",1);
            System.out.println(users);

            List usersList=session.selectList("edu.gdkm.pojo.Users.findAll");
            System.out.println(usersList);


            session.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void userAddUserTest(){
        String resources="mybatis-config.xml";
        try {
            Reader reader=Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
            SqlSession session=sqlMapper.openSession(true);
            Users users=new Users();
            users.setUname("赵六");
            users.setUage(20);
            System.out.println(users);
            session.insert("edu.gdkm.pojo.Users.addUser",users);

            System.out.println(users);
            session.commit();
            session.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.oaec.mybatis.entity;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*Object o = sqlSession.selectOne("hello.world", 1);
        System.out.println("o = " + o);*/
        List<Object> list = sqlSession.selectList("hello.queryAll");
        for (Object o : list) {
            System.out.println("o = " + o);
        }
        sqlSession.close();
        inputStream.close();
    }
}

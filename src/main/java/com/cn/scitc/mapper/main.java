package com.cn.scitc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class main {
    public static void main(String[] args) {
//        InputStream input = Movie.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
//
//        SqlSession sqlsession = factory.openSession();
//        Movie movie = sqlsession.selectOne("com.cn.scitc.mapper.MovieMapper.findall");
//        System.out.println(movie);
        String a = "abcabb";
        a = a.replace("a", "");
        System.out.println(a);
    }
}

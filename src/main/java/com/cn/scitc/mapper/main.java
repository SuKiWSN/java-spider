package com.cn.scitc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.lang.management.MonitorInfo;

public class main {
    public static void main(String[] args) {
        InputStream input = Movie.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        SqlSession sqlsession = factory.openSession();
        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("why");
        movie.setComment("真好啊！");
        movie.setImg("https://www.baicu.com");
        movie.setTime("2021-02-16 22:33:01");
        sqlsession.insert("aaa.insert", movie);
        sqlsession.commit();
//
//        Movie movie = sqlsession.selectOne("aaa.findAll");
//        System.out.println(movie.getId());
//        System.out.println(movie.getName());
//        System.out.println(movie.getComment());
//        System.out.println(movie.getImg());
//        System.out.println(movie.getTime());

    }
}

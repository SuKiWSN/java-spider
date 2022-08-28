package com.cn.scitc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.MonitorInfo;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./wanghanyu.txt");
        List lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println();
        lines.add("wanghanyu");
        Files.write(path, lines, StandardCharsets.UTF_8);

//        FileWriter writer = new FileWriter(file);
//        writer.append("Welcome to the Java World!");
//        writer.close();
//
//        Movie movie = sqlsession.selectOne("aaa.findAll");
//        System.out.println(movie.getId());
//        System.out.println(movie.getName());
//        System.out.println(movie.getComment());
//        System.out.println(movie.getImg());
//        System.out.println(movie.getTime());

    }
}

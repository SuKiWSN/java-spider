package com.cn.scitc.mapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class spider {
    public static void main(String[] args) throws IOException {
        URL realUrl = new URL("https://movie.douban.com/subject/34841067/comments?percent_type=&start=40&limit=20&status=P&sort=new_score&comments_only=1");
        HttpURLConnection httpurlconnection = (HttpURLConnection) realUrl.openConnection();
        httpurlconnection.setRequestProperty("Cookie", "_pk_id.100001.4cf6=8cee3e739cf44074.1661591294.1.1661591307.1661591294.; _pk_ses.100001.4cf6=*; __yadk_uid=VRndrBZYgOZrwMlSjHWmXj0J7qjPen1R; _vwo_uuid_v2=D3D18440A5B0C7DBCFD87129664BA1E88|59bb830a22656e4fb64d194e58bd5808; _pk_ref.100001.4cf6=%5B%22%22%2C%22%22%2C1661591294%2C%22https%3A%2F%2Fwww.douban.com%2F%22%5D; ap_v=0,6.0; ll=\"118185\"; bid=HD8BZLbdHe0");
        httpurlconnection.setRequestProperty("Accept", "application/json, text/plain, */*");
        httpurlconnection.setRequestProperty("Accept-Encoding", "deflate");
        httpurlconnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.6 Safari/605.1.15");
        httpurlconnection.connect();
        if(httpurlconnection.getResponseCode() == 200){
            InputStream is = httpurlconnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[10485760];
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }
            baos.close();
            is.close();

            String s = baos.toString();
            spider spider = new spider();
            s = spider.convertUnicodeToString(s);

            Pattern namePattern = Pattern.compile("avatar\\\\\">\\\\n.*?\"(.*?)\\\\");
            Matcher nameMatcher = namePattern.matcher(s);
            Pattern imgPattern = Pattern.compile("img src=\\\\\"(.*?)\\\\");
            Matcher imgMatcher = imgPattern.matcher(s);
            Pattern timePattern = Pattern.compile("comment-time \\\\\" title=\\\\\"(.*?)\\\\");
            Matcher timeMatcher = timePattern.matcher(s);
            Pattern commentPattern = Pattern.compile("comment-content\\\\\">.*?>(.*?)<");
            Matcher commentMatcher = commentPattern.matcher(s);
            String name, img, time, comment;
            int i = 1;
            File file = new File("comments.csv");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            while (nameMatcher.find() && imgMatcher.find() && timeMatcher.find() && commentMatcher.find()) {
                name = nameMatcher.group(1);
                img = imgMatcher.group(1);
                time = timeMatcher.group(1);
                comment = commentMatcher.group(1);
                comment = comment.replace("\\n", "");
                System.out.println(i + " " + name + " " + img + " " + time + " " + comment);
                i++;

                writer.write(name+","+time+","+comment+","+img+"\n");
            }
            writer.close();
        }
    }
    public String convertUnicodeToString(String s){
        Pattern pattern = Pattern.compile("(\\\\u(\\w{4}))");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            String unicodeChar = matcher.group(1);
            String unicodeNum = matcher.group(2);
            char singleChar = (char)Integer.parseInt(unicodeNum, 16);
            s = s.replace(unicodeChar, singleChar+"");
        }
        return s;
    }
}

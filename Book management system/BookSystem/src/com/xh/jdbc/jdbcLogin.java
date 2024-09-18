package com.xh.jdbc;

import com.xh.frame.BookManagement;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbcLogin {

    public void adminLogin() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/book?characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "284110";
        Connection conn = DriverManager.getConnection(url, username, password);
        Scanner sc = new Scanner(System.in);
        //接受用户名输入   用户名和密码
        System.out.println("请输入用户名:");
        String name = sc.next();
        System.out.println("请输入密码:");
        String pwd = sc.next();

        //定义sql
        String sql = "select * from admin where username = ? and password = ?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();
        BookManagement en = new BookManagement();
        //判断登录是否成功
        if(rs.next()){
            en.enter();
        }
        else{
            System.out.println("无管理员数据,请添加后再试");
        }

        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

}

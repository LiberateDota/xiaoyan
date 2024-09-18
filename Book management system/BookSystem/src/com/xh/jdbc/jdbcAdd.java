package com.xh.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class jdbcAdd {
    private Scanner sc = new Scanner(System.in);
    public  void adminAddAll() throws Exception {
        //接受页面提交的参数
        System.out.println("请输入用户名:");
        String username=sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();


        //1.获取Connection
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/xh9-12实训/Book management system/BookSystem/src/de.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义SQl
        String sql = "insert into admin(username,password) values (?,?);";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        //5.执行sql
        int count = pstmt.executeUpdate();

        //6.处理结果

        System.out.println("添加成功~");
        //7.释放资源

        pstmt.close();
        conn.close();


    }


}

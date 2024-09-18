package com.xh.jdbcBook;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class BookAdd {
    private Scanner sc = new Scanner(System.in);
    public void bookAddAll() throws Exception {
        System.out.println("输入书籍名称:");
        String bname = sc.next();
        System.out.println("输入作者名称:");
        String aname = sc.next();
        System.out.println("输入书籍价格:");
        Double price = Double.valueOf(sc.next());

        //1.获取Connetion
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/xh9-12实训/Book management system/BookSystem/src/de.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql  = "insert into bookifm(bname,aname,price) value(?,?,?);";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,bname);
        pstmt.setString(2,aname);
        pstmt.setDouble(3,price);

        //5.执行sql
        pstmt.executeUpdate();

        //6.处理结果
        System.out.println("恭喜添加书籍成功!");

        //7.释放资源

        pstmt.close();
        conn.close();

    }
}

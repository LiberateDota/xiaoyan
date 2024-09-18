package com.xh.jdbcBook;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class BookUpdate {
    private Scanner sc = new Scanner(System.in);
    public void bookUpdate() throws Exception {
        System.out.println("请输入ID:");
        int id = Integer.parseInt(sc.next());
        System.out.println("输入称书籍名:");
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
        String sql  = "update bookifm\n" +
                "           set bname = ?,\n"+
                "           aname = ?,\n"+
                "           price = ?,\n"+
                "where id = ?";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1, String.valueOf(id));
        pstmt.setString(2,bname);
        pstmt.setString(3,aname);
        pstmt.setDouble(4,price);

        //5.执行sql
        int count = pstmt.executeUpdate();

        //6.处理结果
        System.out.println("书籍编写成功!");

        //7.释放资源

        pstmt.close();
        conn.close();

    }
}

package com.xh.jdbcBook;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class BookDelete {
    private Scanner sc = new Scanner(System.in);
    public void bookDelete() throws Exception {
        System.out.println("选择的删除功能，请输入序号即可：");
        int id = Integer.valueOf(sc.next());
        //1.获取Connetion
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/xh9-12实训/Book management system/BookSystem/src/de.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义sql
        String sql  = "delete from bookifm where id = ?";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setInt(1,id);

        //5.执行sql
        int count = pstmt.executeUpdate();

        //6.处理结果
        System.out.println("删除书籍成功!");

        //7.释放资源

        pstmt.close();
        conn.close();

    }
}

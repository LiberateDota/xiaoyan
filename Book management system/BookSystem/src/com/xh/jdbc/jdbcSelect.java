package com.xh.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.xh.pojo.Administrator;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class jdbcSelect {

    public  void adminSelectAll() throws Exception {
        //1.获取Connection
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/xh9-12实训/Book management system/BookSystem/src/de.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();

        //2.定义SQl
        String sql = "select * from admin;";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数

        //5.执行sql
        ResultSet rs = pstmt.executeQuery();
        List<Administrator> as = new ArrayList<>();
        //6.处理结果  封装对象  装载List集合
        while(rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String name = rs.getString("username");
            String password = rs.getString("password");
            //封装对象
            Administrator a = new Administrator();
            a.setId(id);
            a.setName(name);
            a.setPassword(password);

            //装载集合
            as.add(a);
        }
        System.out.println(as);
        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();


    }
}

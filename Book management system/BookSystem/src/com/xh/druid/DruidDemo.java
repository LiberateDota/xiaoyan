package com.xh.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class DruidDemo {

    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/xh9-12实训/Book management system/BookSystem/src/de.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //System.out.println(System.getProperty("user.dir"));
    }
}
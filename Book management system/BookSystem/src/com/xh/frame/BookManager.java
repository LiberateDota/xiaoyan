package com.xh.frame;

import com.xh.jdbc.jdbcAdd;
import com.xh.jdbc.jdbcLogin;
import com.xh.jdbc.jdbcSelect;
import com.xh.pojo.Administrator;
import com.xh.pojo.BookInformation;

import java.util.ArrayList;
import java.util.Scanner;



public class BookManager {


jdbcAdd add = new jdbcAdd();
jdbcLogin login  = new jdbcLogin();
jdbcSelect select = new jdbcSelect();
    public void start() throws Exception {

        while (true){
            System.out.println("-------------小蜜蜂书籍管理---------------");
            System.out.print("1.登录");
            System.out.print("2.查询管理员");
            System.out.print("3.添加管理员");
            System.out.println("4.退出系统");
            System.out.println("请输入要操作的功能序列[1-4]:");
            Scanner sc = new Scanner(System.in);
            switch (sc.next()){
                case "1":
                    login.adminLogin();
                    break;
                case "2":
                    select.adminSelectAll();
                    break;
                case "3":
                    add.adminAddAll();
                    break;
                case "4":
                    System.out.println("退出系统成功");
                    return;
                default:
                    System.out.println("输入指令错误，请重新输入~");


            }
        }
    }






}

package com.xh.frame;

import com.xh.jdbcBook.BookAdd;
import com.xh.jdbcBook.BookDelete;
import com.xh.jdbcBook.BookSelect;
import com.xh.jdbcBook.BookUpdate;

import java.util.Scanner;

public class BookManagement {
    BookAdd bookAdd = new BookAdd();
    BookUpdate bookUpdate = new BookUpdate();
    BookDelete bookDelete = new BookDelete();
    BookSelect bookSelect = new BookSelect();


    public void enter() throws Exception {
        while(true){
            System.out.println("-------------小蜜蜂书籍管理---------------");
            System.out.print("1.添加书籍");
            System.out.print("2.编辑书籍");
            System.out.print("3.删除书籍");
            System.out.print("4.查询书籍");
            System.out.print("5.退出系统");
            System.out.println("6.退出登录");
            System.out.println("请输入要操作的功能序列[1-6]:");

            Scanner sc  = new Scanner(System.in);
            switch (sc.next()){
                case "1":
                    bookAdd.bookAddAll();
                    break;
                case "2":
                    bookUpdate.bookUpdate();
                    break;
                case "3":
                    bookDelete.bookDelete();
                    break;
                case "4":
                    bookSelect.bookSelect();
                    break;
                case "5":
                    System.out.println("退出系统成功");
                    System.exit(0);

                    break;
                case "6":
                    System.out.println("退出登录成功");
                    return;
                default:
                    System.out.println("输入指令错误，请重新输入");
            }
        }
    }
}

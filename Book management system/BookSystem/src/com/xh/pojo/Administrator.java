package com.xh.pojo;

/*
* 用户
* */
public class Administrator {
    //用户类
    private int aid;
    private String name;
    private String password;

    public int getId() {
        return aid;
    }

    public void setId(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "id=" + aid + ", name='" + name + '\'' + ", password='" + password + '\'' ;
    }
}

package com.xh.pojo;

public class BookInformation {
        private int id;
        private String bname;
        private  String aname;
        private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", bname='" + bname + '\'' +
                ", aname='" + aname + '\'' +
                ", price=" + price
                ;
    }
}

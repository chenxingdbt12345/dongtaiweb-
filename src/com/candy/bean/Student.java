package com.candy.bean;

public class Student {
    //    学号
    private int stu_no;
    //    姓名
    private String stu_name;


    public int getStu_no() {
        return stu_no;
    }

    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_no=" + stu_no +
                ", stu_name='" + stu_name + '\'' +
                '}';
    }
}
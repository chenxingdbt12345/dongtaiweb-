package com.candy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test01 {

    public static void main(String[] args) {
        test02();
        test01();
    }

    /**
     * 执行增删改的方法设计
     */
    public static void test02() {
        try {
//        0、将mysql驱动jar包引入到当前项目下（mysql5、和mysql8所引入的资源包不同）
//        1、加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
//        2、获取数据库链接（Connection）
//            getConnection需要有三个参数，数据库的连接串、用户名、密码、
//            jdbc:mysql:java连接mysql
//            localhost：指代本地地址，可以更换成127.0.0.1 或者需要链接的数据库的ip地址
//            test_demo：需要链接的数据库的库名
            //1.0就是数据库的名字
            String url="jdbc:mysql://localhost:3306/1.0?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username="root";
            String userpwd="123456";
            Connection conn= DriverManager.getConnection(url,username,userpwd);
//        3、获取SQL执行器（Statement）
            Statement ment= conn.createStatement();
//        4、获取执行结果（增删改的返回值为影响行数、查询的结果放在Resultset上，如果执行查询语句，我们需要对查询结果进行解析）
//         String strSQL="INSERT INTO employees(name,gender,dept_id,join_time,salary,address) VALUES\n" +
//                 "('王五','M',2,'2023-3-27 08:00:00',7000,'山东青岛')";
            String strSQL="UPDATE depts SET dept_name='编辑部' where dept_id=2";
            int num= ment.executeUpdate(strSQL);
            System.out.println(num);
//        5、关闭相关资源
            ment.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 数据库查询操作
     */
    public static void test01() {
        try {
//        0、将mysql驱动jar包引入到当前项目下（mysql5、和mysql8所引入的资源包不同）
//        1、加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
//        2、获取数据库链接（Connection）
//            getConnection需要有三个参数，数据库的连接串、用户名、密码、
//            jdbc:mysql:java连接mysql
//            localhost：指代本地地址，可以更换成127.0.0.1 或者需要链接的数据库的ip地址
//            test_demo：需要链接的数据库的库名
            String url="jdbc:mysql://localhost:3306/1.0?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username="root";
            String userpwd="123456";
            Connection conn= DriverManager.getConnection(url,username,userpwd);
//        3、获取SQL执行器（Statement）
            Statement ment= conn.createStatement();
//        4、获取执行结果（增删改的返回值为影响行数、查询的结果放在Resultset上，如果执行查询语句，我们需要对查询结果进行解析）
            ResultSet re= ment.executeQuery("SELECT * FROM depts");
            while(re.next()){
                System.out.print(re.getObject(1)+"\t");
                System.out.print(re.getObject(2)+"\t");
            }
//        5、关闭相关资源
            re.close();
            ment.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }





    }



}

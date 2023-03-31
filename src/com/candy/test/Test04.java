package com.candy.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test04 {

    /**
     * 获取数据库链接
     */
    public static Connection getConn() {
        Connection conn=null;
        try {
//        0、将mysql驱动jar包引入到当前项目下（mysql5、和mysql8所引入的资源包不同）
//        1、加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
//        2、获取数据库链接（Connection）
//            getConnection需要有三个参数，数据库的连接串、用户名、密码、
//            jdbc:mysql:java连接mysql
//            localhost：指代本地地址，可以更换成127.0.0.1 或者需要链接的数据库的ip地址
//            test_demo：需要链接的数据库的库名
            String url="jdbc:mysql://localhost:3306/ld_mysql0317?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username="root";
            String userpwd="123456";
            conn= DriverManager.getConnection(url,username,userpwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 查询方法
     * @return
     */
    public static ResultSet query(String strSQL){
        ResultSet re=null;
        try {
            Connection conn=getConn();
            Statement ment= conn.createStatement();
//        4、获取执行结果（增删改的返回值为影响行数、查询的结果放在Resultset上，如果执行查询语句，我们需要对查询结果进行解析）
            re= ment.executeQuery(strSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }

    /**
     * 查询方法，将结果集使用list+map的方式进行转储
     * @return
     */
    public static List<Map<String,Object>> query4List(String strSQL,Object...ob){


//        准备好容器，将数据保存在容器中
        List<Map<String,Object>> lp=new ArrayList<>();
//继承自AutoCloseable接口，可以放在try后面的括号中，在资源用完后，自动关闭，不需要手动调用close方法
//        4、获取执行结果（增删改的返回值为影响行数、查询的结果放在Resultset上，如果执行查询语句，我们需要对查询结果进行解析）
        try (
                Connection conn=getConn();
                PreparedStatement  ment= conn.prepareStatement(strSQL);

        ){
            for(int i=0;i<ob.length;i++){
                ment.setObject(i+1,ob[i]);
            }
            ResultSet re=ment.executeQuery();
//            获取数据表的元数据对象（表结构的相关信息）
            ResultSetMetaData rm= re.getMetaData();
//           获取数据的列数
            int count=rm.getColumnCount();
//           准备一个map、用于存放每一行信息
            Map<String,Object> eachRow=null;
//            读取每一行的数据
            while (re.next()){
//                由于每一行使用一个map进行存储，在每一行信息读取时，实例化一个map
                eachRow=new LinkedHashMap<>();
                for(int i=1;i<=count;i++){
//                    rm.getColumnLabel(i)：通过列的序号获取列的名字
//                    re.getObject(rm.getColumnLabel(i))：通过列名获取该列的值
                    eachRow.put(rm.getColumnLabel(i),re.getObject(rm.getColumnLabel(i)));
                }
//                将每一行的信息放在容器中
                lp.add(eachRow);
            }
            re.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return lp ;
    }

    /**
     * 使用PreparedStatement对于增删改方法的封装
     * @param strSQL 要执行的   SQL
     * @param ob 表示任意个参数
     * @return 执行结果（影响行数）
     */
    public static int update(String strSQL,Object...ob){
        int num=0;
        try( Connection conn=getConn();
             PreparedStatement ment= conn.prepareStatement(strSQL);) {
//            对传递进来的参数进行遍历赋值
            for(int i=0;i<ob.length;i++){
                ment.setObject(i+1,ob[i]);
            }
//调用方法执行即可
            num= ment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }




}

package com.candy.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test03 {
    public static void main(String[] args) {
//        调用增删改方法
        Test02.update("UPDATE employees SET name='赵六' where employee_id=6");
//
//调用查询方法
        List<Map<String,Object>> lp=Test02.query4List("SELECT * FROM depts;");
        for (Map<String,Object> map:lp
        ) {
//            取出所有key值放在set中
            Set se=map.keySet();
//            对set集合进行遍历
            for (Object ob:se
            ) {
                System.out.print("列名："+ob+"\t"+"值："+map.get(ob)+"\t");
            }
            System.out.println();
        }

    }




}

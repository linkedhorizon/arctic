package org.lyg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class JdbcConnection {
    public static void main(String[] args) throws Exception {
        /*JDBC编程的步骤*/
        String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "123";
        /*1、加载驱动程序*/
        Class.forName("com.mysql.jdbc.Driver");
        /*2、获取数据库连接*/
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        /*3、通过数据库的链接操作数据库，实现增删改查（这里使用Statement类）*/
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user");
        /*4、处理数据库的返回结果(使用ResultSet)*/
        while(rs.next()){
            System.out.println(rs.getString("name")+rs.getString("password"));
        }
        /*5、关闭资源*/
        rs.close();
        st.close();
        conn.close();
    }
}

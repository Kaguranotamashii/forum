package cn.bistu.bbs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/forum";
    private static String user = "root";
    private static String passwd = "111711";

    static{
        try{
            Class.forName(driver);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, user, passwd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement st, Connection conn){
        try{
            if(rs!=null) rs.close();
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}

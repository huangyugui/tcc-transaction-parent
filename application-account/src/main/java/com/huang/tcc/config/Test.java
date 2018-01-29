package com.huang.tcc.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Description:
 * Created on 2018/1/29 23:51
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
public class Test {

    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/tcc?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("无法加载驱动");
        }

        try {
            Connection con = DriverManager.getConnection(url, "root", "rootroot");
            if (!con.isClosed())
                System.out.println("success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

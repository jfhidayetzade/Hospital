/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author User
 */
public class DBhelper {
    public static Connection getconnection () throws Exception {
		
		      Properties p=new Properties();
		p.load(new FileReader("config.properties"));
		Class.forName(p.getProperty("db.driver"));
		Connection c=DriverManager.getConnection(p.getProperty("db.url"),p.getProperty("db.username"),p.getProperty("db.password"));
		
		return c;
	}
    
}

package MyServlet;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataSource;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class MyDataSourceFactory {
     public static MysqlDataSource getMySqlDataSource()
    {
        Properties Properties = new Properties();
        FileInputStream fileInputStream = null;
        MysqlDataSource mysqldata=null;
        try{
            
        fileInputStream= new FileInputStream("C:\\Users\\Radya\\Documents\\NetBeansProjects\\ServletHTMLWeb\\db.properties");
        Properties.load(fileInputStream);
        mysqldata= new MysqlDataSource();
        mysqldata.setURL(Properties.getProperty("MYSQL_DB_URL"));
        mysqldata.setUser(Properties.getProperty("MYSQL_DB_USERNAME"));
        mysqldata.setPassword(Properties.getProperty("MYSQL_DB_PASSWORD"));
        
    }   catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return  mysqldata;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Radya
 */
public class MyDataBase {

    DataSource dataSource = null;
    Connection connection = null;
    Statement statment = null;
    ResultSet resultSet = null;
    
    String query;
    public MyDataBase() {
        try {
            dataSource = MyDataSourceFactory.getMySqlDataSource();
            connection = dataSource.getConnection();
            statment = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "select * from users";
            resultSet = statment.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean Check(String userName,String password)
    {
        boolean isfound = false;
        try {
            while (resultSet.next()) {
               String resUserName = resultSet.getString("userName");
               String resPassword = resultSet.getString("password");
               if (userName.equals(resUserName) && password.equals(resPassword))
               {
                   isfound = true;
                   break;
               }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return isfound;
    }
    
}

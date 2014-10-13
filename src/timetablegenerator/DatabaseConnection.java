/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Dumindu
 */
/*
 * a singleton class which initializes the connectivity to the database.
 * 
 */
public class DatabaseConnection {
    private String dbURL="jdbc:mysql://localhost:3306/timetablegenarater";
    private String password="";
    private String user="root";
    private Connection conn=null;
    
    private static DatabaseConnection instance=null;

    public DatabaseConnection(String url,String pswd,String usr) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        this.dbURL = "jdbc:mysql://localhost:3306/"+url;
        this.password = pswd;
        this.user = usr;
        createConnection();
    }

    public DatabaseConnection() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        createConnection();
    }
    
         
    
    private void createConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException//establishes connection to the database
    {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection(dbURL,user,password);
       
    }
    
    public Connection getConnection()
    {
        return conn;
       
    }
    public void shutdown()//shuts down database connection
    {
        try
        {
            if(conn!=null)
            {
                
                DriverManager.getConnection(dbURL,"root","");
                conn.close();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

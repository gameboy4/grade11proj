
package DB;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConect
{
    private Connection conn;
    Statement stmt;
    
    
    
    public DBConect() throws ClassNotFoundException, SQLException
    {
       
            String dbURL = "jdbc:ucanaccess://PAT2020CalebSmithnew1.mdb";
           
             conn = DriverManager.getConnection(dbURL,"","");
             stmt = conn.createStatement();
            
          
        }
    
        public ResultSet query(String sql) throws SQLException
    {
       
       
       ResultSet result = stmt.executeQuery(sql);
       return result;
        
    }
    
        public  int update(String sql) throws SQLException
    {
        Statement stmt = conn.createStatement();
        int done = stmt.executeUpdate(sql);
        return done;
        
    }
        
        public void getPassword() throws SQLException
        {
        
        
        
        
        }
        
        
}

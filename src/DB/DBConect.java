
package DB;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

    public class DBConect{
        private Connection conn;
        Statement stmt;
      
    //Connects DB
    public DBConect()
    {
        try 
        {
            String dbURL = "jdbc:ucanaccess://PAT2020CalebSmithnew1.accdb";
            
            conn = DriverManager.getConnection(dbURL,"","");
            stmt = conn.createStatement();
        } catch (SQLException ex) 
        {
            Logger.getLogger(DBConect.class.getName()).log(
                    Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, 
                    "There was a database connection error:\n" 
                            + ex.getMessage());
        }   
    }
    
    //Runs a select query - accepts string and returns a ResultSet
    public ResultSet query(String sql) throws SQLException
    { 
       ResultSet result = stmt.executeQuery(sql);
       return result;
    }
    //Runs an update query - accepts a String and returns an int
    public  int update(String sql) throws SQLException
    {
        Statement stmt = conn.createStatement();
        int done = stmt.executeUpdate(sql);
        return done;
    }
    
    public PreparedStatement insert() throws SQLException
    {
        
        String query = "INSERT INTO Users(PatientID, AmountPerPackg, NumberOfPacks, DateOfPurchase, ScheduleRating) VALUES (?,?,?,?,?);";
        
        PreparedStatement pst = conn.prepareStatement(query);
        return pst;
    }
    
    public PreparedStatement delete(int id) throws SQLException
    {
        PreparedStatement pst = conn.prepareStatement("DELETE * FROM Users WHERE UsersID = " + id + ";");
        return pst;
    }
    
    //Returns the update id - accepts a String and returns an int
    public int updateReturnID(String sql) throws Exception
    {
        Statement stmt = conn.createStatement();
        int id = -1;
        stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet result = stmt.getGeneratedKeys();
        if (result.next()) 
        {
             id = result.getInt(sql);
        }
        return id;
    }
}
package Manager;

import DB.DBConect;
import DB.UsersClass;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Manageuserclass {
    
    DBConect objDBCon;

    private ArrayList<UsersClass> UserList = new ArrayList();   //using list to link client class
    private javax.swing.JTable table_users;

    public Manageuserclass(javax.swing.JTable table_users) throws SQLException //constructor
    {
        objDBCon = new DBConect();
        this.table_users = table_users;

        getUserList();
    }

    public void getUserList() {
        ResultSet rs;
        try {
            rs = objDBCon.query("SELECT * FROM Users;");
            UserList.clear();
            while (rs.next()) {
                UsersClass objUC = new UsersClass(rs.getInt("UserID"), rs.getString("NAMES"), rs.getString("SURNAME"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Permissions"));

                UserList.add(objUC);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manageuserclass.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel model = (DefaultTableModel) table_users.getModel();

        model.setRowCount(0);

        for (int i = 0; i < UserList.size(); i++) {
            UsersClass objC = UserList.get(i);

            Object[] rowData
                    = {
                        objC.getUserid(), objC.getName(), objC.getSurname(), objC.getUsername(), objC.getPassword(), objC.getPermission()
                    };
            model.addRow(rowData);
        }

        table_users.setModel(model);

        if (table_users.getRowCount() > 0) {
            table_users.setRowSelectionInterval(0, 0);
        }
    }
}

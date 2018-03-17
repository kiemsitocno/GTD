/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DESKTOP-EQP0G7D
 */
public class Stuffs {
    public static boolean insertStuff(entity.Stuff stuff) {
        // PHƯƠNG THỨC INSERT CỦA ĐỐI TƯỢNG STUFF
        String sql = "insert into Stuffs values(?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, stuff.getStuffID());
            pst.setString(2, stuff.getStuffName());
            pst.setString(3, stuff.getStuffTime());
            pst.setString(4, stuff.getStuffDeadtime());
            JOptionPane.showMessageDialog(null, "Insert Stuff success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    public static void deleteStuff(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG Stuff
        String sql = "delete from Stuffs where ID ='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<entity.Stuff> getAll() {
        try {
            Connection conn = DataInteraction.getConnect();
            PreparedStatement pst = conn.prepareStatement("select * from Stuffs");
            ResultSet rs = pst.executeQuery();

            ArrayList<entity.Stuff> stuffs = new ArrayList<entity.Stuff>();
            while (rs.next()) {
                entity.Stuff stuff = new entity.Stuff();
                stuff.setStuffID(rs.getString("ID"));
                stuff.setStuffName(rs.getString("Task"));
                stuff.setStuffTime(rs.getString("Time"));
                stuff.setStuffDeadtime(rs.getString("Deadline"));
                stuffs.add(stuff);
            }
            return stuffs;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return new ArrayList<entity.Stuff>();
        }
    }
}

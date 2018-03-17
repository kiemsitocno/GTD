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
public class Inboxs {
    public static boolean insertInbox(entity.Inbox inbox) {
        // PHƯƠNG THỨC INSERT CỦA ĐỐI TƯỢNG Inbox
        try {
            String sql = "insert into Inboxs values(?,?,?,?,?,?)";

            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, inbox.getInboxID());
            pst.setString(2, inbox.getInboxName());
            pst.setString(3, inbox.getCategoryID());
            pst.setString(4, inbox.getInboxTime());
            pst.setString(5, inbox.getInboxDeadtime());
            pst.setString(6, inbox.getSize());
            JOptionPane.showMessageDialog(null, "Insert to inbox success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insert to inbox Fail" + ex.getMessage());
            return false;
        }
    }

    public static boolean editInbox(entity.Inbox inbox) {
        // PHƯƠNG THỨC EDIT CỦA ĐỐI TƯỢNG Inbox
        String sql = "update Inboxs set Task=?, CategoryID=?, Time=?, Deadline=?, Size=? where ID=?";
        try {
            PreparedStatement pst = interact.DataInteraction.getConnect().prepareCall(sql);
            pst.setString(1, inbox.getInboxName());
            pst.setString(2, inbox.getCategoryID());
            pst.setString(3, inbox.getInboxTime());
            pst.setString(4, inbox.getInboxDeadtime());
            pst.setString(5, inbox.getSize());
            pst.setString(6, inbox.getInboxID());
            JOptionPane.showMessageDialog(null, "Update Inbox successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void deleteInbox(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG CATEGORY
        String sql = "delete from Inboxs where ID ='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Detele Inbox successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<entity.Inbox> getAll() {
        try {
            Connection conn = DataInteraction.getConnect();
            PreparedStatement pst = conn.prepareStatement("select * from Inboxs");
            ResultSet rs = pst.executeQuery();

            ArrayList<entity.Inbox> inbox = new ArrayList<entity.Inbox>();
            while (rs.next()) {
                entity.Inbox inboxs = new entity.Inbox();
                inboxs.setInboxID(rs.getString("ID"));
                inboxs.setInboxName(rs.getString("Task"));
                inboxs.setCategoryID(rs.getString("CategoryID"));
                inboxs.setInboxTime(rs.getString("Time"));
                inboxs.setInboxDeadtime(rs.getString("Deadline"));
                inboxs.setSize(rs.getString("Size"));
                inbox.add(inboxs);
            }
            return inbox;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return new ArrayList<entity.Inbox>();
        }
    }
}

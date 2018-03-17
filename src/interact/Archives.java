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
public class Archives {
    public static boolean insertArchive(entity.Archive archive) {
        // PHƯƠNG THỨC INSERT CỦA ĐỐI TƯỢNG Archive
        try {
            String sql = "insert into Archive values(?,?,?)";

            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, archive.getArchiveID());
            pst.setString(2, archive.getArchiveName());
            pst.setString(3, archive.getArchiveStatus());
            JOptionPane.showMessageDialog(null, "Insert to Archive success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insert to Archive Fail" + ex.getMessage());
            return false;
        }
    }

    public static boolean editArchive(entity.Archive archive) {
        // PHƯƠNG THỨC EDIT CỦA ĐỐI TƯỢNG Archive
        String sql = "update Archive set Name=?, Status=? where ID=?";
        try {
            PreparedStatement pst = interact.DataInteraction.getConnect().prepareCall(sql);
            pst.setString(1, archive.getArchiveName());
            pst.setString(2, archive.getArchiveStatus());
            pst.setString(3, archive.getArchiveID());
            JOptionPane.showMessageDialog(null, "Update Archive successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void deleteArchive(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG Archive
        String sql = "delete from Archive where ID ='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Detele Archive successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<entity.Archive> getAllSomeday() {
        try {
            Connection conn = DataInteraction.getConnect();
            PreparedStatement pst = conn.prepareStatement("select * from Archive where Status='someday'");
            ResultSet rs = pst.executeQuery();

            ArrayList<entity.Archive> archive = new ArrayList<entity.Archive>();
            while (rs.next()) {
                entity.Archive archives = new entity.Archive();
                archives.setArchiveID(rs.getString("ID"));
                archives.setArchiveName(rs.getString("Name"));
                archives.setArchiveStatus(rs.getString("Status"));
                archive.add(archives);
            }
            return archive;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return new ArrayList<entity.Archive>();
        }
    }
    
    public static ArrayList<entity.Archive> getAllDone() {
        try {
            Connection conn = DataInteraction.getConnect();
            PreparedStatement pst = conn.prepareStatement("select * from Archive where Status='done'");
            ResultSet rs = pst.executeQuery();
            
            ArrayList<entity.Archive> archive = new ArrayList<entity.Archive>();
            while (rs.next()) {
                entity.Archive archives = new entity.Archive();
                archives.setArchiveID(rs.getString("ID"));
                archives.setArchiveName(rs.getString("Name"));
                archives.setArchiveStatus(rs.getString("Status"));
                archive.add(archives);
            }
            return archive;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return new ArrayList<entity.Archive>();
        }
    }
    
    public static ArrayList<entity.Archive> getAllTrash() {
        try {
            Connection conn = DataInteraction.getConnect();
            PreparedStatement pst = conn.prepareStatement("select * from Archive where Status='trash'");
            ResultSet rs = pst.executeQuery();

            ArrayList<entity.Archive> archive = new ArrayList<entity.Archive>();
            while (rs.next()) {
                entity.Archive archives = new entity.Archive();
                archives.setArchiveID(rs.getString("ID"));
                archives.setArchiveName(rs.getString("Name"));
                archives.setArchiveStatus(rs.getString("Status"));
                archive.add(archives);
            }
            return archive;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return new ArrayList<entity.Archive>();
        }
    }
}

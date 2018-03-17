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
public class Categories {
    public static boolean insertCategory(entity.Category category) {
        // PHƯƠNG THỨC INSERT CỦA ĐỐI TƯỢNG CATEGORY
        try {
            String sql = "insert into Categories values(?,?)";

            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, category.getCategoryID());
            pst.setString(2, category.getCategoryName());
            JOptionPane.showMessageDialog(null, "Insert to categories success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insert to categories Fail" + ex.getMessage());
            return false;
        }
    }

    public static boolean editCategory(entity.Category category) {
        // PHƯƠNG THỨC EDIT CỦA ĐỐI TƯỢNG CATEGORY
        String sql = "update Categories set Name=? where ID=?";
        try {
            PreparedStatement pst = interact.DataInteraction.getConnect().prepareCall(sql);
            pst.setString(1, category.getCategoryName());
            pst.setString(2, category.getCategoryID());
            JOptionPane.showMessageDialog(null, "Update Category successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void deleteCategory(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG CATEGORY
        String sql = "delete from Categories where ID ='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Detele Category successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<entity.Category> getAll() {
        try {
            Connection conn = DataInteraction.getConnect();
            PreparedStatement pst = conn.prepareStatement("select * from Categories");
            ResultSet rs = pst.executeQuery();

            ArrayList<entity.Category> category = new ArrayList<entity.Category>();
            while (rs.next()) {
                entity.Category categories = new entity.Category();
                categories.setCategoryID(rs.getString("ID"));
                categories.setCategoryName(rs.getString("Name"));
                category.add(categories);
            }
            return category;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return new ArrayList<entity.Category>();
        }
    }
}

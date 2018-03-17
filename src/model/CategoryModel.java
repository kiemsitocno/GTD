/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DESKTOP-EQP0G7D
 */
public class CategoryModel extends AbstractTableModel {

    private final ArrayList<entity.Category> cateList;
    private final String columnsName[] = {"ID", "CATEGORY"};
    private final Class columnsClass[] = {String.class, String.class};

    public CategoryModel(ArrayList<entity.Category> cateList) {
        this.cateList = cateList;
    }

    @Override
    public int getRowCount() {
        return cateList.toArray().length;
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return cateList.get(rowIndex).getCategoryID();
            case 1:
                return cateList.get(rowIndex).getCategoryName();
            default:
                return null;

        }
    }
    
    @Override
    public String getColumnName(int iCol) {
        return columnsName[iCol];
    }

    @Override
    public Class getColumnClass(int iCol) {
        return columnsClass[iCol];
    }
    
}

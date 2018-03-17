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
public class StuffModel extends AbstractTableModel {

    private final ArrayList<entity.Stuff> stuffList;
    private final String columnsName[] = {"ID", "TASK", "TIME", "DEADTIME"};
    private final Class columnsClass[] = {String.class, String.class, String.class, String.class};

    public StuffModel(ArrayList<entity.Stuff> stuffList) {
        this.stuffList = stuffList;
    }

    @Override
    public int getRowCount() {
        return stuffList.toArray().length;
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return stuffList.get(rowIndex).getStuffID();
            case 1:
                return stuffList.get(rowIndex).getStuffName();
            case 2:
                return stuffList.get(rowIndex).getStuffTime();
            case 3:
                return stuffList.get(rowIndex).getStuffDeadtime();
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

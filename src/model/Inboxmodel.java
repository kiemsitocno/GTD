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
public class Inboxmodel extends AbstractTableModel{
    private final ArrayList<entity.Inbox> inboxList;
    private final String columnsName[] = {"ID", "NAME","CATEGORY","TIME","DEADLINE","SIZE"};
    private final Class columnsClass[] = {String.class, String.class,String.class, String.class,String.class, String.class};

    public Inboxmodel(ArrayList<entity.Inbox> inboxList) {
        this.inboxList = inboxList;
    }

    @Override
    public int getRowCount() {
        return inboxList.toArray().length;
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return inboxList.get(rowIndex).getInboxID();
            case 1:
                return inboxList.get(rowIndex).getInboxName();
            case 2:
                return inboxList.get(rowIndex).getCategoryID();
            case 3:
                return inboxList.get(rowIndex).getInboxTime();
            case 4:
                return inboxList.get(rowIndex).getInboxDeadtime();
            case 5:
                return inboxList.get(rowIndex).getSize();
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

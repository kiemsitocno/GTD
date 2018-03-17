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
public class ArchiveModel extends AbstractTableModel {
    private final ArrayList<entity.Archive> archiveList;
    private final String columnsName[] = {"ID", "NAME", "STATUS"};
    private final Class columnsClass[] = {String.class, String.class, String.class};

    public ArchiveModel(ArrayList<entity.Archive> archiveList) {
        this.archiveList = archiveList;
    }

    @Override
    public int getRowCount() {
        return archiveList.toArray().length;
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return archiveList.get(rowIndex).getArchiveID();
            case 1:
                return archiveList.get(rowIndex).getArchiveName();
            case 2:
                return archiveList.get(rowIndex).getArchiveStatus();
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

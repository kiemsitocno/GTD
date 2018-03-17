/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DESKTOP-EQP0G7D
 */
public class Archive {
    private String archiveID;
    private String archiveName;
    private String archiveStatus;

    public Archive() {
    }

    public Archive(String archiveID, String archiveName, String archiveStatus) {
        this.archiveID = archiveID;
        this.archiveName = archiveName;
        this.archiveStatus = archiveStatus;
    }

    public String getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(String archiveID) {
        this.archiveID = archiveID;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }

    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }
    
}

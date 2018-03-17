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
public class Inbox {
    private String inboxID;
    private String inboxName;
    private String categoryID;
    private String inboxTime;
    private String inboxDeadtime;
    private String size;

    public Inbox() {
    }

    public Inbox(String inboxID, String inboxName, String categoryID, String inboxTime, String inboxDeadtime, String size) {
        this.inboxID = inboxID;
        this.inboxName = inboxName;
        this.categoryID = categoryID;
        this.inboxTime = inboxTime;
        this.inboxDeadtime = inboxDeadtime;
        this.size = size;
    }

    public String getInboxID() {
        return inboxID;
    }

    public void setInboxID(String inboxID) {
        this.inboxID = inboxID;
    }

    public String getInboxName() {
        return inboxName;
    }

    public void setInboxName(String inboxName) {
        this.inboxName = inboxName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getInboxTime() {
        return inboxTime;
    }

    public void setInboxTime(String inboxTime) {
        this.inboxTime = inboxTime;
    }

    public String getInboxDeadtime() {
        return inboxDeadtime;
    }

    public void setInboxDeadtime(String inboxDeadtime) {
        this.inboxDeadtime = inboxDeadtime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    
}

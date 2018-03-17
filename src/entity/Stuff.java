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
public class Stuff {
    private String stuffID;
    private String stuffName;
    private String stuffTime;
    private String stuffDeadtime;

    public Stuff() {
    }

    public Stuff(String stuffID, String stuffName, String stuffTime, String stuffDeadtime) {
        this.stuffID = stuffID;
        this.stuffName = stuffName;
        this.stuffTime = stuffTime;
        this.stuffDeadtime = stuffDeadtime;
    }

    public String getStuffID() {
        return stuffID;
    }

    public void setStuffID(String stuffID) {
        this.stuffID = stuffID;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public String getStuffTime() {
        return stuffTime;
    }

    public void setStuffTime(String stuffTime) {
        this.stuffTime = stuffTime;
    }

    public String getStuffDeadtime() {
        return stuffDeadtime;
    }

    public void setStuffDeadtime(String stuffDeadtime) {
        this.stuffDeadtime = stuffDeadtime;
    }
    
}

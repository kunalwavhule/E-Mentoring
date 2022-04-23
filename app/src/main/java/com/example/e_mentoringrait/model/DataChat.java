package com.example.e_mentoringrait.model;

public class DataChat {
    String msg;
    String ruid;
    String suid;
    String rfullName;
    String sfullName;
    String time;

    public DataChat() {

    }

    public DataChat(String msg, String ruid, String suid, String rfullName, String sfullName, String time) {
        this.msg = msg;
        this.ruid = ruid;
        this.suid = suid;
        this.rfullName = rfullName;
        this.sfullName = sfullName;
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRuid() {
        return ruid;
    }

    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getRfullName() {
        return rfullName;
    }

    public void setRfullName(String rfullName) {
        this.rfullName = rfullName;
    }

    public String getSfullName() {
        return sfullName;
    }

    public void setSfullName(String sfullName) {
        this.sfullName = sfullName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

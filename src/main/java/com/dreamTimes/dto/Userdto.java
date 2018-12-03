package com.dreamTimes.dto;


import java.sql.Date;

public class Userdto {
    private String uname;
    private String upwd;
    private Integer usex;
    private Date ubirthday;
    private String receiver;
    private String raddress;
    private String rtelephone;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRtelephone() {
        return rtelephone;
    }

    public void setRtelephone(String rtelephone) {
        this.rtelephone = rtelephone;
    }

    @Override
    public String toString() {
        return "Userdto{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", usex=" + usex +
                ", ubirthday=" + ubirthday +
                ", receiver='" + receiver + '\'' +
                ", raddress='" + raddress + '\'' +
                ", rtelephone='" + rtelephone + '\'' +
                '}';
    }
}

package com.dreamTimes.beans;

public class Goods {
    private Integer gid;
    private String gname;
    private double gprice;
    private Integer grepertory;
    private Integer gsalevolume;
    private String gstandard;
    private String gphoto;
    private String gremarks;
    private String tname;
    private Integer ifdelete;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public Integer getGrepertory() {
        return grepertory;
    }

    public void setGrepertory(Integer grepertory) {
        this.grepertory = grepertory;
    }

    public Integer getGsalevolume() {
        return gsalevolume;
    }

    public void setGsalevolume(Integer gsalevolume) {
        this.gsalevolume = gsalevolume;
    }

    public String getGstandard() {
        return gstandard;
    }

    public void setGstandard(String gstandard) {
        this.gstandard = gstandard;
    }

    public String getGphoto() {
        return gphoto;
    }

    public void setGphoto(String gphoto) {
        this.gphoto = gphoto;
    }

    public String getGremarks() {
        return gremarks;
    }

    public void setGremarks(String gremarks) {
        this.gremarks = gremarks;
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getIfdelete() {
        return ifdelete;
    }

    public void setIfdelete(Integer ifdelete) {
        this.ifdelete = ifdelete;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", grepertory=" + grepertory +
                ", gsalevolume=" + gsalevolume +
                ", gstandard='" + gstandard + '\'' +
                ", gphoto='" + gphoto + '\'' +
                ", gremarks='" + gremarks + '\'' +
                ", tname='" + tname + '\'' +
                ", ifdelete=" + ifdelete +
                '}';
    }
}

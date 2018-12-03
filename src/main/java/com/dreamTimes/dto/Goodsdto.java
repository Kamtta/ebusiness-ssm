package com.dreamTimes.dto;

import org.springframework.web.multipart.MultipartFile;

public class Goodsdto {
    private String gname;
    private double gprice;
    private Integer grepertory;
    private String gstandard;
    private MultipartFile gphoto;
    private String gremarks;
    private String tname;



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

    public String getGstandard() {
        return gstandard;
    }

    public void setGstandard(String gstandard) {
        this.gstandard = gstandard;
    }

    public MultipartFile getGphoto() {
        return gphoto;
    }

    public void setGphoto(MultipartFile gphoto) {
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

    @Override
    public String toString() {
        return "Goodsdto{" +
                "gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", grepertory=" + grepertory +
                ", gstandard='" + gstandard + '\'' +
                ", gphoto=" + gphoto +
                ", gremarks='" + gremarks + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}

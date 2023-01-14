package com.example.liviewproduct;

public class product {
    private int img;
    private String tensp, giatien, dongia;

    public product(int img, String tensp, String giatien, String dongia) {
        this.img = img;
        this.tensp = tensp;
        this.giatien = giatien;
        this.dongia = dongia;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
}

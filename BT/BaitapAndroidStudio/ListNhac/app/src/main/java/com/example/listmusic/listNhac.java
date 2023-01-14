package com.example.listmusic;

import java.io.Serializable;

public class listNhac implements Serializable {
    private String tenBaiHat, tencasi;
    private int img;

    public listNhac(String tenBaiHat, int img, String tencasi) {
        this.tenBaiHat = tenBaiHat;
        this.img = img;
        this.tencasi = tencasi;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }
}

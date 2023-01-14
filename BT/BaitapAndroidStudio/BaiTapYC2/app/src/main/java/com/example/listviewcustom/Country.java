package com.example.listviewcustom;

public class Country {
    private int img;
    private String name, danso;

    public Country(int img, String name, String danso) {
        this.img = img;
        this.name = name;
        this.danso = danso;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDanso() {
        return danso;
    }

    public void setDanso(String danso) {
        this.danso = danso;
    }
}

package com.example.listmusic;

public class Singer {
    private int img;
    private String name, luotCare;

    public Singer(int img, String name, String luotCare) {
        this.img = img;
        this.name = name;
        this.luotCare = luotCare;
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

    public String getLuotCare() {
        return luotCare;
    }

    public void setLuotCare(String luotCare) {
        this.luotCare = luotCare;
    }
}

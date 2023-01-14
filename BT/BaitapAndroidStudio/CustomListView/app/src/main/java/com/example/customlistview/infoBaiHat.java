package com.example.customlistview;

public class infoBaiHat {
    private String nameSong, singer, timeSong;
    private int img;

    public infoBaiHat(int img, String nameSong, String singer, String timeSong) {
        this.img = img;
        this.nameSong = nameSong;
        this.singer = singer;
        this.timeSong = timeSong;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTimeSong() {
        return timeSong;
    }

    public void setTimeSong(String timeSong) {
        this.timeSong = timeSong;
    }

    @Override
    public String toString() {
        return "infoBaiHat{" +
                "img='" + img + '\'' +
                ", nameSong='" + nameSong + '\'' +
                ", singer='" + singer + '\'' +
                ", timeSong='" + timeSong + '\'' +
                '}';
    }
}

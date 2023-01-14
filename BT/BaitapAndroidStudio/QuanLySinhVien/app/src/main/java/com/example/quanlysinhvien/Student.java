package com.example.quanlysinhvien;

public class Student {
   private String mssv, ten, malop;

    public Student(String mssv, String ten, String malop) {
        this.mssv = mssv;
        this.ten = ten;
        this.malop = malop;
    }
    public String getMssv() {
        return mssv;
    }
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
       .
       .
       .
    public String ConvertToString(){
        return mssv + " - " + ten + " - " + malop;
    }
}

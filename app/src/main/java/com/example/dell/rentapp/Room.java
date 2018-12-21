package com.example.dell.rentapp;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Room {
    private String diachi;
    private String dienthoai;
    private String dientich;
    private String ghichu;
    private String gia;
    private String hinhanh;
    private String tienich;

    public Room() {
    }

    public Room(String diachi, String dienthoai, String dientich, String ghichu, String gia, String hinhanh, String tienich) {
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.dientich = dientich;
        this.ghichu = ghichu;
        this.gia = gia;
        this.hinhanh = hinhanh;
        this.tienich = tienich;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getDientich() {
        return dientich;
    }

    public void setDientich(String dientich) {
        this.dientich = dientich;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTienich() {
        return tienich;
    }

    public void setTienich(String tienich) {
        this.tienich = tienich;
    }

    @Override
    public String toString() {
        return "Room{" +
                "diachi='" + diachi + '\'' +
                ", dienthoai='" + dienthoai + '\'' +
                ", dientich='" + dientich + '\'' +
                ", ghichu='" + ghichu + '\'' +
                ", gia='" + gia + '\'' +
                ", hinhanh='" + hinhanh + '\'' +
                ", tienich='" + tienich + '\'' +
                '}';
    }
}

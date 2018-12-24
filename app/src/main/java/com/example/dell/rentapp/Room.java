package com.example.dell.rentapp;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@SuppressWarnings("serial")
@IgnoreExtraProperties
public class Room implements Serializable {
    private String diachi;
    private String dienthoai;
    private String dientich;
    private String ghichu;
    private String gia;
    private String hinhanh;
    private String ten;
    private String tienich;
    private boolean trangthai;

    public Room() {
    }

    public Room(String diachi, String dienthoai, String dientich, String ghichu, String gia, String hinhanh, String ten, String tienich, boolean trangthai) {
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.dientich = dientich;
        this.ghichu = ghichu;
        this.gia = gia;
        this.hinhanh = hinhanh;
        this.ten = ten;
        this.tienich = tienich;
        this.trangthai = trangthai;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTienich() {
        return tienich;
    }

    public void setTienich(String tienich) {
        this.tienich = tienich;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Thông tin : \n" +
                "Địa chỉ: " + diachi + '\n' +
                "Số Điện Thoại: " + dienthoai + '\n' +
                "Diện tích: " + dientich + '\n' +
                "Ghi chú: " + ghichu + '\n' +
                "Giá: " + gia + '\n' +
                "Tên: " + ten + '\n' +
                "Tiện ích: " + tienich + '\n'
                ;
    }
}

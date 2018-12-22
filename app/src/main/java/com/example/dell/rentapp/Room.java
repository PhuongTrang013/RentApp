package com.example.dell.rentapp;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@SuppressWarnings("serial")
@IgnoreExtraProperties
public class Room implements Serializable {
    private String Diachi;
    private String Dienthoai;
    private String Dientich;
    private String Ghichu;
    private String Gia;
    private String Hinhanh;
    private String Ten;
    private String Tienich;

    public Room(String diachi, String dienthoai, String dientich, String ghichu, String gia, String hinhanh, String ten, String tienich) {
        Diachi = diachi;
        Dienthoai = dienthoai;
        Dientich = dientich;
        Ghichu = ghichu;
        Gia = gia;
        Hinhanh = hinhanh;
        Ten = ten;
        Tienich = tienich;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getDienthoai() {
        return Dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        Dienthoai = dienthoai;
    }

    public String getDientich() {
        return Dientich;
    }

    public void setDientich(String dientich) {
        Dientich = dientich;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String ghichu) {
        Ghichu = ghichu;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getTienich() {
        return Tienich;
    }

    public void setTienich(String tienich) {
        Tienich = tienich;
    }

    @Override
    public String toString() {
        return "" +
                "Ten'" + Ten + '\n' +
                "Diachi:'" + Diachi + '\n' +
                "Dienthoai:'" + Dienthoai + '\n' +
                "Dientich:'" + Dientich + '\n' +
                "Ghichu='" + Ghichu + '\n' +
                "Tienich='" + Tienich + '\n';
    }

}

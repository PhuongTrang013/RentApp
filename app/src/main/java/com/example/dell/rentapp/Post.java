package com.example.dell.rentapp;

public class Post {
    private String tennha;
    private String diachi;
    private String dientich;
    private String tienich;
    private String hinhanh;
    private String gia;
    private String ghichu;
    private String dienthoai;


    public Post() {
    }

    public Post(String tennha, String diachi, String dientich, String tienich, String hinhanh, String gia, String ghichu, String dienthoai) {
        this.tennha = tennha;
        this.diachi = diachi;
        this.dientich = dientich;
        this.tienich = tienich;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.ghichu = ghichu;
        this.dienthoai = dienthoai;
    }

    public String getTennha() {
        return tennha;
    }

    public void setTennha(String tennha) {
        this.tennha = tennha;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDientich() {
        return dientich;
    }

    public void setDientich(String dientich) {
        this.dientich = dientich;
    }

    public String getTienich() {
        return tienich;
    }

    public void setTienich(String tienich) {
        this.tienich = tienich;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
}

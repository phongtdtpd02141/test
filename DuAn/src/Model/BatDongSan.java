/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class BatDongSan {

    private String MaBDS;
    private float DienTich;
    private String DiaChi;
    private float Gia;
    private String Hinh;

    public BatDongSan() {
    }

    public BatDongSan(String MaBDS, float DienTich, String DiaChi, float Gia, String Hinh) {
        this.MaBDS = MaBDS;
        this.DienTich = DienTich;
        this.DiaChi = DiaChi;
        this.Gia = Gia;
        this.Hinh = Hinh;
    }

    public String getMaBDS() {
        return MaBDS;
    }

    public void setMaBDS(String MaBDS) {
        this.MaBDS = MaBDS;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

}

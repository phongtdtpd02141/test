/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Helper.DateHelper;
import java.util.Date;
/**
 *
 * @author ASUS
 */
public class HopDong {
    private String MaHD;
    private String MaNV;
    private String MaKH;
    private String MaBDS;
    private Date NgayLap = DateHelper.now();
    private Float SoTien;

    public HopDong() {
    }

    public HopDong(String MaHD, String MaNV, String MaKH, String MaBDS, Float SoTien) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaBDS = MaBDS;
        this.SoTien = SoTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaBDS() {
        return MaBDS;
    }

    public void setMaBDS(String MaBDS) {
        this.MaBDS = MaBDS;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public Float getSoTien() {
        return SoTien;
    }

    public void setSoTien(Float SoTien) {
        this.SoTien = SoTien;
    }
    
}

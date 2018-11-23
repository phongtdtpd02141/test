/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class KhachHangDAO {
    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang(MaKH, HotenKH, DiaChi, NgaySinh, GioiTinh) VALUES(?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaKH(), model.getHoTen(), model.getDiaChi(), model.getNgaySinh(), model.isGioiTinh());

    }

    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang SET HotenKH=?, DiaChi=?, NgaySinh=?, GioiTinh=? WHERE MaKH=?";
        JdbcHelper.executeUpdate(sql, model.getMaKH(), model.getDiaChi(), model.getNgaySinh(), model.isGioiTinh(), model.getMaKH());

    }

    public void delete(String MaKH) {
        String sql = "DELETE FROM KhachHang WHERE MaKH=?";
        JdbcHelper.executeUpdate(sql, MaKH);
    }

    public List<KhachHang> select() {
        String sql = "SELECT * FROM KhachHang";
        return select(sql);
    }

    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKH(rs.getString("MaKH"));
        model.setHoTen(rs.getString("HotenKH"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        return model;
    }   

    public KhachHang findById(String makh) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
}

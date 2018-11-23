/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO {
public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (MaNV, HotenNV, MatKhau, ChucVu) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaNV(), model.getHoTen(), model.getMatKhau(), model.isChucVu());
    }

    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET MatKhau=?, HotenNV=?, ChucVu=? WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql, model.getMatKhau(), model.getHoTen(), model.isChucVu(), model.getMaNV());
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }

    public NhanVien findById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setHoTen(rs.getString("HotenNV"));
        model.setMatKhau(rs.getString("MatKhau"));       
        model.setChucVu(rs.getBoolean("ChucVu"));
        return model;
    }
}

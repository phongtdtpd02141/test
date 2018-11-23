/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.HopDong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HopDongDAO {
   public void insert(HopDong model) {
        String sql = "INSERT INTO HopDong (MaHD, MaNV, MaKH, MaBDS, NgayLap, SoTien) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHD(), model.getMaNV(), model.getMaKH(), model.getMaBDS(), model.getNgayLap(), model.getSoTien());
    }

    public void update(HopDong model) {
        String sql = "UPDATE HopDong SET MaNV=?, MaKH=?, MaBDS=?, NgayLap=?, SoTien=? WHERE MaHD=?";
        JdbcHelper.executeUpdate(sql, model.getMaHD(), model.getMaNV(), model.getMaKH(), model.getMaBDS(), model.getNgayLap(), model.getSoTien());
    }

    public void delete(String MaHD) {
        String sql = "DELETE FROM HopDong WHERE MaHD=?";
        JdbcHelper.executeUpdate(sql, MaHD);
    }

    public List<HopDong> select() {
        String sql = "SELECT * FROM HopDong";
        return select(sql);
    }

    public HopDong findById(String mahd) {
        String sql = "SELECT * FROM HopDong WHERE MaHD=?";
        List<HopDong> list = select(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<HopDong> select(String sql, Object... args) {
        List<HopDong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HopDong model = readFromResultSet(rs);
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

    private HopDong readFromResultSet(ResultSet rs) throws SQLException {
        HopDong model = new HopDong();
        model.setMaHD(rs.getString("MaHD"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaKH(rs.getString("MaKH"));
        model.setMaBDS(rs.getString("MaBDS"));
        model.setNgayLap(rs.getDate("NgayLap"));
        model.setSoTien(rs.getFloat("SoTien"));
        return model;
    } 
}

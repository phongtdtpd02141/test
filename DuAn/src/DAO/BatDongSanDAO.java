/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.BatDongSan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class BatDongSanDAO {

    public void insert(BatDongSan model) {
        String sql = "INSERT INTO BatDongSan (MaBDS, DienTich, DiaChi, Gia, Hinh) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaBDS(), model.getDienTich(), model.getDiaChi(), model.getGia(), model.getHinh());
    }

    public void update(BatDongSan model) {
        String sql = "UPDATE BatDongSan SET MaBDS=?, DienTich=?, DiaChi=?, Gia=?, Hinh=? WHERE MaBDS=?";
        JdbcHelper.executeUpdate(sql, model.getMaBDS(), model.getDienTich(), model.getDiaChi(), model.getGia(), model.getHinh());
    }

    public void delete(String MaCD) {
        String sql = "DELETE FROM BatDongSan WHERE MaBDS=?";
        JdbcHelper.executeUpdate(sql, MaCD);
    }

    public List<BatDongSan> select() {
        String sql = "SELECT * FROM BatDongSan";
        return select(sql);
    }

    public List<BatDongSan> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM BatDongSan WHERE Gia LIKE ?";
        return select(sql, "%" + keyword + "%");
    }
    public List<BatDongSan> selectByCourse(Integer mabds) {
        String sql = "SELECT * FROM BatDongSan WHERE MaBDS NOT IN (SELECT MaBDS FROM HopDong WHERE MaHD=?)";
        return select(sql, mabds);
    }

    public BatDongSan findById(String macd) {
        String sql = "SELECT * FROM BatDongSan WHERE MaBDS=?";
        List<BatDongSan> list = select(sql, macd);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<BatDongSan> select(String sql, Object... args) {
        List<BatDongSan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    BatDongSan model = readFromResultSet(rs);
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

    private BatDongSan readFromResultSet(ResultSet rs) throws SQLException {
        BatDongSan model = new BatDongSan();
        model.setMaBDS(rs.getString("MaBDS"));
        model.setDienTich(rs.getFloat("DienTich"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setGia(rs.getFloat("Gia"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }
}

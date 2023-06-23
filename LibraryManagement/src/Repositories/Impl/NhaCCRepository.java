/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NhaCC;
import Repositories.INhaCCRepository;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class NhaCCRepository implements INhaCCRepository {

    String sql = "Select * from NhaCC";
    String sqlByID = "Select * from NhaCC where idNhaCC =?";
    String sqlByNameNDiaChi = "select * from NhaCC where TenNhaCC = ? and DiaChi=?";
    final String Insert_SQL = "INSERT INTO NhaCC(TenNhacc, Diachi, SDT, Email) values (?,?,?,?)";
    final String Delete_SQL = "DELETE FROM NhaCC where TenNhaCC = ?";
    final String UPDATE_SQL = "UPDATE NhaCC SET TenNhacc = ?, DIACHi = ?, SDT = ?, Email = ? where IDNhaCC = ?";

    @Override
    public List<NhaCC> getAll() {
        return getBySql(sql);
    }

    @Override
    public NhaCC getByID(String id) {
        return getBySql(sqlByID, id).get(0);
    }

    private List<NhaCC> getBySql(String sql, Object... args) {
        List<NhaCC> _lst = new ArrayList<>();
        PreparedStatement ps = DBConnection.getStmt(sql, args);
        ResultSet rs;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String hoTen = rs.getString(2);
                String diaChi = rs.getString(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                NhaCC nhacc = new NhaCC(id, hoTen, diaChi, sdt, email);
                _lst.add(nhacc);
            }
        } catch (SQLException ex) {
            return null;
        }
        return _lst;
    }

    @Override
    public NhaCC Insert(NhaCC nhacc) {
        int i = DBConnection.ExcuteDungna(Insert_SQL, nhacc.getTen(),
                nhacc.getDiaChi(), nhacc.getSdt(), nhacc.getEmail());
        return i==i?getByNameNDiaChi(nhacc.getTen(), nhacc.getDiaChi()):null;
    }

    @Override
    public NhaCC Update(NhaCC nhacc) {
        int i = DBConnection.ExcuteDungna(UPDATE_SQL, nhacc.getTen(),
                nhacc.getDiaChi(), nhacc.getSdt(), nhacc.getEmail(), nhacc.getId());
        return i==i?getByNameNDiaChi(nhacc.getTen(), nhacc.getDiaChi()):null;
    }

    @Override
    public NhaCC getByNameNDiaChi(String ten, String diaChi) {
        List<NhaCC> _lst = getBySql(sqlByNameNDiaChi, ten, diaChi);
        if(!_lst.isEmpty()){
            return _lst.get(0);
        }
        return null;
    }

}

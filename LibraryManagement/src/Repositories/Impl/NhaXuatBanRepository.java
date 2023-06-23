/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NhaXuatBan;
import Repositories.INhaXuatBanRepository;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class NhaXuatBanRepository implements INhaXuatBanRepository {
    String sql = "Select * from NhaXuatBan";
    String sqlByID = "Select * from NhaXuatBan where idNhaXuatBan =?";
    String insert_NXBCT = "Insert into NXBCT values(?,?)";
    String delete_NXBCT = "delete NXBCT  where idSachCT=?";
    String insert = "Insert into NhaXuatBan(TENNXB, DiaChi) values(?,?)";
    String update = "update NhaXuatBan set TenNXB = ?, DiaChi = ? where idNhaXuatBan =?";
    String sqlByNameNDiaChi = "select * from NhaXuatBan where Tennxb = ? and DiaChi =?";

    @Override
    public NhaXuatBan insert(NhaXuatBan nxb) {
        int i = DBConnection.ExcuteDungna(insert, nxb.getTen(), nxb.getDiaChi());
        return i==1?getByNameNDiaChi(nxb.getTen(), nxb.getDiaChi()):null;
    }


    @Override
    public NhaXuatBan update(NhaXuatBan nxb) {
        int i = DBConnection.ExcuteDungna(update, nxb.getTen(), nxb.getDiaChi(), nxb.getId());
        return i==1?getByID(nxb.getId()):null;
    }

    @Override
    public List<NhaXuatBan> getAll() {
        return getBySql(sql);
    }

    @Override
    public NhaXuatBan getByID(String id) {
        return getBySql(sqlByID, id).get(0);
    }

    private List<NhaXuatBan> getBySql(String sql, Object... args) {
        List<NhaXuatBan> _lst = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                String id = rs.getString(1);
                String hoTen = rs.getString(2);
                String diaChi = rs.getString(3);
                NhaXuatBan tacGia = new NhaXuatBan(id, hoTen, diaChi);
                _lst.add(tacGia);
            }
        } catch (SQLException ex) {
            return null;
        }
        return _lst;
    }

    @Override
    public int insertNXBCT(String idNXB, String idSachCT) {
        return DBConnection.ExcuteDungna(insert_NXBCT, idNXB, idSachCT);
    }

    @Override
    public NhaXuatBan getByNameNDiaChi(String ten, String diaChi) {
        List<NhaXuatBan> nxb = getBySql(sqlByNameNDiaChi, ten, diaChi);
        return !nxb.isEmpty()?getBySql(sqlByNameNDiaChi, ten, diaChi).get(0):null;
    }

    @Override
    public int deleteNXBCT(String idSachCT) {
        return DBConnection.ExcuteDungna(delete_NXBCT, idSachCT);
    }

}

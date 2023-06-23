/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NhaXuatBan;
import DomainModels.PhieuNhap;
import DomainModels.Sach;
import Repositories.ISachCTRepository;
import DomainModels.SachCT;
import Services.Impl.TacGiaService;
import Utilities.DBConnection;
import java.math.BigDecimal;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SachCTRepository implements ISachCTRepository {
    String sql = "Select * from SachCT";
    String sql_by_IDSach = "Select * from SachCT where IDSach = ?";
    String sql_by_ID = "Select * from SachCT where IDSachCT = ?";
    String insert = "insert into SachCT(NamXuatBan, img, GiaInTrenSach, seri,"
            + "IDSach) values (?,?,?,?,?)";
    String sql_by_ma = "select * from Sach where MaSach like ?";
    String sql_by_ten = "select * from Sach where TenSach like ?";
    String sql_by_barcode = "Select * from Sachct where seri = ?";
    String update = "update SachCT set NamXuatBan=?, img=?, GiaInTrenSach=?, seri=? where IdSachCT = ?";
    String sql_count = "Select count(IDCuonSach) as sl from cuonSach where idSachCT=?";
    String delete_NXBCT = "Delete from NXBCT where idSachct=? ";
    String delete = "Delete from sachct where idSachCT=? ";

    @Override
    public SachCT insert(SachCT sachCT) {
        try {
            PreparedStatement ps = DBConnection.getStmt(insert, sachCT.getNamxb(),
                    sachCT.getImg(), sachCT.getGiaIn(), sachCT.getSeri(), sachCT.getSach().getId());
            int i = ps.executeUpdate();
            return i == 1 ? sachCT : null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public SachCT delete(SachCT sach) {
        PhieuNhapRepository REPO_PN = new PhieuNhapRepository();
        PhieuNhap PN = REPO_PN.getByidSachCT(sach.getId()).get(0);
        REPO_PN.delete(PN.getId());
        DBConnection.ExcuteDungna(delete_NXBCT, sach.getId());
        int i = DBConnection.ExcuteDungna(delete, sach.getId());
        return i==0?getByID(sach.getId()):null;
    }

    @Override
    public SachCT update(SachCT sachCT) {
        try {
            PreparedStatement ps = DBConnection.getStmt(update, sachCT.getNamxb(), 
                sachCT.getImg(), sachCT.getGiaIn(), 
                sachCT.getSeri(), sachCT.getId());
            int i = ps.executeUpdate();
            return  i == 0 ? getByID(sachCT.getId()) : null;
        } catch (Exception ex) {
             ex.printStackTrace();
             return null;
        }
    }

    @Override
    public List<SachCT> getAll() {
        return getBySQL(sql);
    }

    @Override
    public SachCT getByIDSach(String ID) {
        return this.getBySQL(sql_by_IDSach, ID).get(0);
    }

    private List<SachCT> getBySQL(String sql, Object... args) {
        SachRepository REPO_SACH = new SachRepository();
        List<SachCT> _lst = new ArrayList<>();
        PreparedStatement ps = DBConnection.getStmt(sql, args);
        ResultSet rs;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                int namXb = rs.getInt(2);
                String img = rs.getString(3);
                BigDecimal giain = rs.getBigDecimal(4);
                String seri = rs.getString(5);
                String idSach = rs.getString(6);
                Sach sach = REPO_SACH.getByID(idSach);
                SachCT sachCT = new SachCT(id, namXb, img, giain, seri, sach);
                _lst.add(sachCT);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return _lst;
    }

    @Override
    public SachCT getByID(String ID) {
        return this.getBySQL(sql_by_ID, ID).get(0);
    }


    @Override
    public SachCT getByBarcode(String barcode) {
        return getBySQL(sql_by_barcode, barcode).get(0);
    }

    @Override
    public int CountCSBYIDSachCT(String id) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql_count, id);
            int count = 0;
            while(rs.next()){
                count = Integer.parseInt(rs.getString(1));
            }
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.DocGia;
import DomainModels.PhieuMuon;
import Repositories.IPhieuMuonRepository;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhieuMuonRepository implements IPhieuMuonRepository{
    
    String sql_all = "Select * from PhieuMuon";
    String sql_by_ma= "Select * from PhieuMuon where MaPhieuMuon = ?";
    String sql_by_id= "Select * from PhieuMuon where IDPhieuMuon = ?";
    String insert = "Insert into PhieuMuon(MaPhieuMuon, NgayMuon, NgayTra, tinhTrang, IDDocGia) values(?,?,?,?,?)";
    String delete = "Delete from phieumuon where IdPhieuMuon = ?";
    String update = "Update phieumuon set tinhtrang = ? where maphieumuon=?";
    
    @Override
    public PhieuMuon insert(PhieuMuon phieuMuon) {
        int i = DBConnection.ExcuteDungna(insert, phieuMuon.getMa(), phieuMuon.getNgaymuon(),
                phieuMuon.getNgayTra(), phieuMuon.getTinhTrang(), phieuMuon.getDocGia().getId());
        return i==1?getByMa(phieuMuon.getMa()):null;
    }

    @Override
    public PhieuMuon delete(String id) {
        int i = DBConnection.ExcuteDungna(delete, id);
        return i==0?getByID(id):null;
    }

    @Override
    public List<PhieuMuon> getAll() {
        return getBySql(sql_all);
    }

    @Override
    public PhieuMuon getByMa(String ma) {
       return getBySql(sql_by_ma, ma).get(0);
    }

    @Override
    public List<PhieuMuon> getBySearch(String tuKhoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private List<PhieuMuon> getBySql(String sql, Object... args){
        DocGiaRepository REPO_DG = new DocGiaRepository();
        try {
            List<PhieuMuon> _lst = new ArrayList<>();
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                String id = rs.getString(1);
                String ma = rs.getString(2);
                Date ngayMuon = rs.getDate(3);
                Date ngayTra = rs.getDate(4);
                Integer tinhTrang = rs.getInt(5);
                String idDocGia = rs.getString(6);
                DocGia dg = REPO_DG.getByID(idDocGia);
                PhieuMuon pm = new PhieuMuon(id, ma, ngayMuon, ngayTra,tinhTrang,dg);
                _lst.add(pm);
            }
            return _lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public PhieuMuon getByID(String ID) {
        return getBySql(sql_by_id, ID).get(0);
    }

    @Override
    public PhieuMuon TraSach(String ma, int loai) {
        int i = DBConnection.ExcuteDungna(update, loai, ma);
        return i==1?getByMa(ma):null;
    }


    
}

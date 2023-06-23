/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.CuonSach;
import DomainModels.PhieuMuon;
import DomainModels.PhieuMuonCT;
import Repositories.IPhieuMuonCTRepository;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhieuMuonCTRepository implements IPhieuMuonCTRepository{
    
    String sql_all = "Select * from PhieuMuonCT";
    String sql_byManID = "Select * from PhieuMuonCT where maPhieuMuon =? and IdCuonSach=?";
    String sql_byMa = "Select * from PhieuMuonCT where maPhieuMuon =?";
    String countLuotMuon = "select count(phieumuonct.idCuonSach) from PhieuMuonCT join"
            + " CuonSach on PhieuMuonCT.idCuonSach = CuonSach.idCuonSach where CuonSach.IDSachCT=?";
    String insert = "Insert into PhieuMuonCT(IDCuonSach, maPhieuMuon) values(?,?)";
    String Delete = "Delete from phieuMuonCT where maPhieuMuon = ?";
    String sql_by_idCuonSach= "Select * from PhieuMuonCT where IdCuonSach = ?";
    
    @Override
    public PhieuMuonCT insert(PhieuMuonCT phieuMuonCT) {
        int i = DBConnection.ExcuteDungna(insert, phieuMuonCT.getCuonSach().getId(),
                phieuMuonCT.getPhieuMuon().getMa());
        return i==1?getByManID(phieuMuonCT.getPhieuMuon().getMa(), phieuMuonCT.getCuonSach().getId()):null;
    }

    @Override
    public PhieuMuonCT delete(String id) {
        int i = DBConnection.ExcuteDungna(Delete, id);
        return null;
    }

    @Override
    public List<PhieuMuonCT> getAll() {
        return getBySql(sql_all);
    }

    @Override
    public PhieuMuonCT getByManID(String ma, String id) {
       return getBySql(sql_byManID, ma, id).get(0);
    }

    @Override
    public List<PhieuMuonCT> getBySearch(String tuKhoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private List<PhieuMuonCT> getBySql(String sql, Object... args){
        PhieuMuonRepository REPO_PM = new PhieuMuonRepository();
        CuonSachRepository REPO_CS = new CuonSachRepository();
        try {
            List<PhieuMuonCT> _lst = new ArrayList<>();
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                String idPhieu = rs.getString(1);
                String id = rs.getString(2);
                String ma = rs.getString(3);
                CuonSach cuonSach = REPO_CS.getByID(id).get(0);
                PhieuMuon phieuMuon = REPO_PM.getByMa(ma);
                PhieuMuonCT pm = new PhieuMuonCT(idPhieu, cuonSach, phieuMuon);
                _lst.add(pm);
            }
            return _lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PhieuMuonCT> getByMa(String ma) {
        return getBySql(sql_byMa, ma);
    }
    @Override
    public List<PhieuMuonCT> getByIDCuonSach(String id) {
        return getBySql(sql_by_idCuonSach, id);
    }

    @Override
    public String LuotMuonSach(String idSachCT) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(countLuotMuon, idSachCT);
            while(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }
    
}

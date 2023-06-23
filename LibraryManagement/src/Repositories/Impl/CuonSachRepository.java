/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.CuonSach;
import DomainModels.PhieuMuon;
import DomainModels.PhieuMuonCT;
import DomainModels.SachCT;
import Repositories.ICuonSachRepository;
import Utilities.DBConnection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CuonSachRepository implements ICuonSachRepository{
    String getAll = "Select * from CuonSach orderby maCuonSach asc";
    String getByIDSachCT = "Select * from CuonSach where IDSachCT = ?";
    String getSachDuocMuon = "Select * from CuonSach where IDSachCT = ? and TrangThai = 0";
    String getByTTNID = "Select * from CuonSach where IDSachCT = ? and tinhTrang <=? order by tinhTrang DESC";
    String getByIDAndMa = "Select * from CuonSach where IDSachCT = ? and MaCuonSach = ?";
    String getByMa = "Select * from CuonSach where MaCuonSach = ?";
    String getByIDCuonSach = "Select * from CuonSach where IDCuonSach = ?";
    String insert = "exec addcuonsach ?, ?, ?";
    String deletePM = "Delete from phieuMuonct where idcuonsach=? Delete from phieumuon where idphieuMuon=? ";
    String delete = "Delete from cuonsach where idCuonSach=?";
    String upDate = "Update CuonSach set tinhTrang = ?, trangthai=? where MaCuonSach = ? and IdSachCT = ?";
    @Override
    public CuonSach insert(int soLuong, CuonSach cuonSach, int soBatDau) {
        int i = DBConnection.ExcuteDungna(insert, soLuong, cuonSach.getSachct().getId(), soBatDau);
        return i==1?getByIDSachCT(cuonSach.getSachct().getId()).get(0):null;
    }

    @Override
    public CuonSach delete(String id) {
        PhieuMuonCTRepository REPO_PMCT = new PhieuMuonCTRepository();
        List<PhieuMuonCT> pmct = REPO_PMCT.getByIDCuonSach(id);
        if(!pmct.isEmpty()){
            DBConnection.ExcuteDungna(deletePM, id, pmct.get(0).getPhieuMuon().getId());
        }
        int i = DBConnection.ExcuteDungna(delete, id);
        return i==0?getByIDSachCT(id).get(0):null;
    }

    @Override
    public CuonSach update(CuonSach cuonSach) {
        int i = DBConnection.ExcuteDungna(upDate, cuonSach.getTinhTrang(), cuonSach.getTrangThai(), cuonSach.getMa(), cuonSach.getSachct().getId());
        return i==1?getByIDSachCT(cuonSach.getSachct().getId()).get(0):null;
    }

    @Override
    public List<CuonSach> getAll() {
        return getBySQL(getAll);
    }

    @Override
    public List<CuonSach> getByIDSachCT(String id) {
        List<CuonSach> _lst = getBySQL(getByIDSachCT, id);
        _lst.sort((CuonSach o1, CuonSach o2) -> o1.getMa()>o2.getMa()?1:-1);
        return _lst;
    }
    
    public List<CuonSach> getBySQL(String sql, Object ...args){
        SachCTRepository REPO_SACHCT = new SachCTRepository();
        List<CuonSach> _lst = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                String id = rs.getString(1);
                int ma = rs.getInt(2);
                String idSachCT = rs.getString(3);
                float trangThai  = rs.getFloat(4);
                boolean tinhTrang  = rs.getBoolean(5);
                SachCT sachCT = REPO_SACHCT.getByID(idSachCT);
                CuonSach cs = new CuonSach(id, ma, sachCT, trangThai, tinhTrang);
                _lst.add(cs);
            }
            return _lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CuonSach> getByID(String id) {
        return getBySQL(getByIDCuonSach, id);
    }

    @Override
    public List<CuonSach> getByMa(String id) {
        return getBySQL(getByMa, id);
    }

    @Override
    public CuonSach getByMaAndID(String id, String ma) {
        return getBySQL(getByIDAndMa, id, ma).get(0);
    }

    @Override
    public List<CuonSach> getByTinhTrangNID(String tinhTrang, String id) {
        return getBySQL(getByTTNID, id, tinhTrang);
    }

    @Override
    public List<CuonSach> getSachDuocMuon(String idsachct) {
        return getBySQL(getSachDuocMuon, idsachct);
    }
}

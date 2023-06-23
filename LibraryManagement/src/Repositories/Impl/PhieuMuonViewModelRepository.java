/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.CuonSach;
import DomainModels.DocGia;
import DomainModels.PhieuMuon;
import DomainModels.PhieuMuonCT;
import DomainModels.Sach;
import DomainModels.SachCT;
import Utilities.DBConnection;
import ViewModels.PhieuMuonTableViewModel;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Repositories.IPhieuMuonViewModelRepository;
import ViewModels.PhieuMuonViewModel;

/**
 *
 * @author Admin
 */
public class PhieuMuonViewModelRepository implements IPhieuMuonViewModelRepository{
    String sql="""
               SELECT DISTINCT DocGia.MaDocGia, TenDOcGia, PhieuMuon.MaPhieuMuon, NgayMuon, NgayTra, TinhTrang from DocGia
               join PhieuMuon on PhieuMuon.IDDocGia = DocGia.IDDocGia
               join PhieuMuonCT on PhieuMuonCT.MaPhieuMuon = PhieuMuon.MaPhieuMuon""";
    String sqlByMaPM = sql +" where PhieuMuon.maphieumuon like ?";
    String sqlByMaDG = sql +" where DocGia.madocgia like ?";
    String sqlByTenDG = sql +" where tendocgia like ?";
    @Override
    public List<PhieuMuonTableViewModel> getAll() {
        return getBySQL(sql);
    }

    @Override
    public PhieuMuonViewModel getByMaPhieu(String ma) {
        PhieuMuonRepository REPO_PM =new PhieuMuonRepository();
        PhieuMuonCTRepository REPO_PMCT =new PhieuMuonCTRepository();
        PhieuMuon pm = REPO_PM.getByMa(ma);
        List<PhieuMuonCT> pmct = REPO_PMCT.getByMa(ma);
        List<CuonSach> cuonSach = new ArrayList<>();
        for (PhieuMuonCT phieuMuonCT : pmct) {
            cuonSach.add(phieuMuonCT.getCuonSach());
        }
        DocGia docGia = pm.getDocGia();
        List<SachCT> sachCT = new ArrayList<>();
        for (CuonSach cuonSach1 : cuonSach) {
            sachCT.add(cuonSach1.getSachct());
        }
        List<Sach> sach = new ArrayList<>();
        for (SachCT sachCT1 : sachCT) {
            sach.add(sachCT1.getSach());
        }
        return new PhieuMuonViewModel(pm, sach, cuonSach, docGia);
    }

    @Override
    public List<PhieuMuonTableViewModel> getByKeyWord(String tuKhoa) {
        tuKhoa = "%"+tuKhoa+"%";
        List<PhieuMuonTableViewModel> _lst = getBySQL(sqlByMaPM, tuKhoa);
        if(_lst.isEmpty()){
            _lst = getBySQL(sqlByMaDG, tuKhoa);
        }
        if(_lst.isEmpty()){
            _lst = getBySQL(sqlByTenDG, tuKhoa);
        }
        return _lst;
    }
    
    private List<PhieuMuonTableViewModel> getBySQL(String sql, Object... args){
        try {
            List<PhieuMuonTableViewModel> _lst = new ArrayList<>();
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                String maDG = rs.getString(1);
                String tenDG = rs.getString(2);
                String maPM = rs.getString(3);
                String ngayMuon = rs.getString(4);
                String ngayTra = rs.getString(5);
                String tt = rs.getString(6);
                Integer tinhTrang = Integer.parseInt(tt);
                PhieuMuonTableViewModel model = new PhieuMuonTableViewModel(maDG, tenDG, maPM, ngayMuon, ngayTra, tinhTrang);
                _lst.add(model);
            }
            return _lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

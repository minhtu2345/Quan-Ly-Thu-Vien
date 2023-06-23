/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NhaXuatBan;
import DomainModels.PhieuNhap;
import DomainModels.Sach;
import DomainModels.SachCT;
import Repositories.KhoSachRepository;
import Utilities.DBConnection;
import Utilities.DBContext;
import ViewModels.KhoSachViewModels;
import ViewModels.SachCTViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huong
 */
public class KhoSachImpl implements KhoSachRepository {
    String sql_TheLoai = """
                         SELECT TenTL FROM TheLoaiSach JOIN TLSACHCT ON TheLoaiSach.IDTL = TLSACHCT.IdTLSach
                         JOIN Sach ON sach.IDSach = TLSACHCT.IDSach where sach.IDSach = ? """;
    String sql_TacGia = """
                        SELECT TenTacGia FROM TacGia JOIN TacGiaCT ON TacGia.IDTacGia = TacGiaCT.IDTacGia
                        JOIN Sach ON sach.IDSach = TacGiaCT.IDSach where sach.IDSach = ?""";
    String sql_NCC = """
                        SELECT TenNhaCC FROM NhaCC JOIN NHACCCT ON NHACCCT.IdNhacc = NhaCC.IdNhaCC
                        JOIN PhieuNhap ON sach.IDSach = NHACCCT.IDSach where sach.IDSach = ?""";
    String sql_NXB = """
                        SELECT TENNXB+'-'+DiaChi as thongtin FROM NhaXuatBan JOIN NXBCT ON NXBCT.IDNhaXuatBan = NhaXuatBan.IDNhaXuatBan
                        join SachCT ON SachCT.IDSachCT = NXBCT.IDSACHCT where SachCT.IDSachCT = ?""";
    String sql = "select * from sach";
    String sql_search_ten = sql + " where Sach.TenSach like ?";
    String sql_search_ma = sql + " where Sach.MaSach like ?";

    @Override
    public List<KhoSachViewModels> getALl() {
        List<KhoSachViewModels> listks = getBySql(sql);
        return listks;
    }

    @Override
    public SachCTViewModel getKhoSachView(String ma) {
        SachRepository REPO_SACH = new SachRepository();
        SachCTRepository REPO_SACHCT = new SachCTRepository();
        PhieuNhapRepository REPO_PN = new PhieuNhapRepository();
        Sach sach = REPO_SACH.getByMa(ma);
        String idSach = sach.getId();
        SachCT sachCT = REPO_SACHCT.getByIDSach(idSach);
        PhieuNhap PN = REPO_PN.getByidSachCT(sachCT.getId()).get(0);
        List<String> _lstTacGia = getEnityName(sql_TacGia, idSach);
        String NXB = getEnityName(sql_NXB, sachCT.getId()).get(0);
        List<String> _lstTheLoai = getEnityName(sql_TheLoai, idSach);
        int count = REPO_SACHCT.CountCSBYIDSachCT(PN.getIdSachCT());
        SachCTViewModel view = new SachCTViewModel(sach.getMa(), sach.getTen(),
                sachCT.getImg(), _lstTacGia, count, NXB, _lstTheLoai, sachCT.getNamxb(),
                sachCT.getGiaIn());
        return view;
    }

    public List<String> getEnityName(String sql, Object... args) {
        List<String> _lst = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                String ten = rs.getString(1);
                _lst.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return _lst;
    }
    
    private List<KhoSachViewModels> getBySql(String sql, Object...args){
        SachRepository REPO_SACH = new SachRepository();
        List<Sach> sach = REPO_SACH.getBySQL(sql, args);
        List<KhoSachViewModels> _lst = new ArrayList<>();
        for (Sach sach1 : sach) {
            String idSach = sach1.getId();
            List<String> _lstTheLoai = getEnityName(sql_TheLoai, idSach);
            KhoSachViewModels model = new KhoSachViewModels(sach1.getMa(), sach1.getTen(), _lstTheLoai);
            _lst.add(model);
        }
        return _lst;
    }

    @Override
    public List<KhoSachViewModels> getBySearch(String tuKhoa) {
        tuKhoa = "%"+tuKhoa+"%";
       List<KhoSachViewModels> _lst = getBySql(sql_search_ma, tuKhoa);
       if(_lst.isEmpty()){
           _lst = getBySql(sql_search_ten, tuKhoa);
       }
        return _lst;    
    }

}

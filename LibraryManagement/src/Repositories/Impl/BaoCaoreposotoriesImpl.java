/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.ViPham;
import Repositories.BaoCaoRepositories;
import Utilities.DBConnection;
import Utilities.DBContext;
import ViewModels.BaoCaoDSViewModels;
import ViewModels.BaoCaoPMViewModels;
import ViewModels.DocGiaViPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Apc
 */
public class BaoCaoreposotoriesImpl implements BaoCaoRepositories {
    String insertLoiVPCT = "Insert into LoiViPhamCT values(?,?)";
    String sql = "Select * from vipham";
    String getLoiViPham = "Select IDLoiViPham from LoiViPhamCT where idViPham=?";

    @Override
    public List<BaoCaoPMViewModels> getPhieuMuonByMa(String ma) {
        ArrayList<BaoCaoPMViewModels> dsbaoCaoPMViewModelses = new ArrayList<>();

        try {
            Connection connection = DBContext.getConnection();
            String sql = """
                         SELECT dg.TenDOcGia,s.TenSach,pm.NgayMuon FROM DocGia dg 
                               JOIN PhieuMuon pm ON pm.IDDocGia = dg.IDDocGia
                               JOIN PhieuMuonCT ct ON pm.MaPhieuMuon = ct.MaPhieuMuon
                               JOIN CuonSach cs ON cs.idCuonSach = ct.idCuonSach
                               JOIN SachCT sct ON sct.IDSachCT = cs.IDSachCT
                               JOIN Sach s ON s.IDSach = sct.IDSach
                         where pm.MaPhieuMuon = ?""";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String DocGia = rs.getString("TenDOcGia");
                String Sach = rs.getString("TenSach");
                Date NgayMuon = rs.getDate("NgayMuon");
                BaoCaoPMViewModels baoCaoPMViewModels = new BaoCaoPMViewModels(DocGia, Sach, NgayMuon);
                dsbaoCaoPMViewModelses.add(baoCaoPMViewModels);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsbaoCaoPMViewModelses;
    }

    @Override
    public List<ViPham> getBaoCaoBymaPM(String ma) {
        ArrayList<ViPham> dsViPhams = new ArrayList<>();

        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT idViPham, MaPM,MoTa,HinhPhat,NgayVP FROM ViPham\n"
                    + "WHERE MaPM = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("idViPham");
                String MaPM = rs.getString("MaPM");
                String moTa = rs.getString("MoTa");
                String hinhPhat = rs.getString("HinhPhat");
                Date NgayVP = rs.getDate("NgayVP");
                ViPham viPham = new ViPham();
                viPham.setIdVP(id);
                viPham.setMaPM(MaPM);
                viPham.setMoTa(moTa);
                viPham.setHinhPhat(hinhPhat);
                viPham.setNgayVP(NgayVP);
                dsViPhams.add(viPham);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsViPhams;
    }

    @Override
    public List<BaoCaoDSViewModels> LoadTableBaoCao() {
        ArrayList<BaoCaoDSViewModels> dsTablebaoCaoPMViewModelses = new ArrayList<>();

        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT ct.MaPhieuMuon,dg.MaDocGia,vp.NgayVP FROM DocGia dg\n"
                    + "JOIN PhieuMuon pm ON dg.IDDocGia = pm.IDDocGia\n"
                    + "JOIN PhieuMuonCT ct ON pm.MaPhieuMuon = ct.MaPhieuMuon\n"
                    + "JOIN CuonSach cs ON ct.idCuonSach = cs.idCuonSach\n"
                    + "JOIN SachCT Sct ON Sct.IDSachCT = cs.IDSachCT\n"
                    + "JOIN Sach S ON S.IDSach = Sct.IdSach\n"
                    + "JOIN ViPham vp ON vp.MaPM = ct.MaPhieuMuon";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPM = rs.getString("MaPhieuMuon");
                String maDG = rs.getString("MaDocGia");
                Date ngayMuon = rs.getDate("NgayVP");
                BaoCaoDSViewModels baoCaoDSViewModels = new BaoCaoDSViewModels(maPM, maDG, ngayMuon);
                dsTablebaoCaoPMViewModelses.add(baoCaoDSViewModels);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsTablebaoCaoPMViewModelses;
    }

    @Override
    public void Them(ViPham vp) {
        String sql = "INSERT into ViPham(MoTa,HinhPhat,NgayVP,MaPM) VALUES (?,?,CURRENT_TIMESTAMP,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, vp.getMoTa());
            ps.setObject(2, vp.getHinhPhat());
            //System.out.println(vp.getNgayVP());
            //ps.setObject(3, new java.sql.Date(vp.getNgayVP().getTime()));
            //ps.setObject(3, vp.getNgayVP(java.time.LocalDate.now()));
            //ps.setObject(3, new java.time.LocalDate.now(vp.getNgayVP().getTime()));
            ps.setObject(3, vp.getMaPM());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void Sua(ViPham vp, String ma) {
        String sql = " UPDATE [dbo].[ViPham]\n"
                + "                          SET[MoTa] = ?\n"
                + "                             ,[HinhPhat] = ?\n"
                + "                     ,NgayVP=CURRENT_TIMESTAMP\n"
                + " WHERE [MaPM] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, vp.getMoTa());
            ps.setString(2, vp.getHinhPhat());
            //ps.setObject(3, vp.getNgayVP());
            ps.setString(3, ma);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void Xoa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BaoCaoDSViewModels> getByMaDG(String maDG) {
        ArrayList<BaoCaoDSViewModels> dsbaoCaoPM = new ArrayList<>();

        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT ct.MaPhieuMuon,dg.MaDocGia,vp.NgayVP FROM DocGia dg\n"
                    + "JOIN PhieuMuon pm ON dg.IDDocGia = pm.IDDocGia\n"
                    + "JOIN PhieuMuonCT ct ON pm.IDPhieuMuon = ct.IDPhieuMuon\n"
                    + "JOIN CuonSach cs ON ct.MaCuonSach = cs.MaCuonSach\n"
                    + "JOIN SachCT Sct ON Sct.IDSachCT = cs.IDSachCT\n"
                    + "JOIN Sach S ON S.IDSach = Sct.IdSach\n"
                    + "JOIN ViPham vp ON vp.MaPM = ct.MaPhieuMuon\n"
                    + "WHERE dg.MaDocGia = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maDG);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPM = rs.getString("MaPhieuMuon");
                String madg = rs.getString("MaDocGia");
                Date ngaPM = rs.getDate("NgayVP");
                BaoCaoDSViewModels timKiem = new BaoCaoDSViewModels(maPM, madg, ngaPM);
                dsbaoCaoPM.add(timKiem);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsbaoCaoPM;
    }

    @Override
    public List<DocGiaViPhamViewModel> getViewViPham() {
        return null;
    }

    @Override
    public void insertLoiVpCT(String idViPham, String idLoiViPham) {
        DBConnection.ExcuteDungna(insertLoiVPCT, idViPham, idLoiViPham);
    }

    @Override
    public List<ViPham> getAll() {
        List<ViPham> _lst = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while(rs.next()){
                String id = rs.getString(1);
                Date ngayViet = rs.getDate(2);
                String hinhPhat = rs.getString(3);
                String moTa = rs.getString(4);
                String phieuMuon = rs.getString(5);
                ViPham vp = new ViPham(id, ngayViet, hinhPhat, moTa, phieuMuon);
                _lst.add(vp);
            }
            return _lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getLoiThuocViPham(String id) {
        List<String> _lst = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(getLoiViPham, id);
            while(rs.next()){
                String idLOI = rs.getString(1);
                _lst.add(idLOI);
            }
            return _lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IPhieuNhapRepository;
import DomainModels.PhieuNhap;
import Utilities.DBConnection;
import java.math.BigDecimal;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhieuNhapRepository implements IPhieuNhapRepository{
    String sql = "Select * from PhieuNhap";
    String sql_by_ma = "Select * from PhieuNhap where MaPhieuNhap = ?";
    String sql_by_id = "Select * from PhieuNhap where IDPhieuNhap = ?";
    String insert = "Insert into phieunhap(IDSachCT, MaPhieuNhap, NgayNhap, TinhTrang,"
                    + " SoLuongNhap, GiaNhap) values (?,?,?,?,?,?)";
    String insert_nccct = "Insert into Nhaccct values(?,?)";
    String sql_nccct = "select IDNhacc from Nhaccct where idPhieuNhap=?";
    String sql_by_id_sachct = "Select * from PhieuNhap where idSachCt = ?";
    String deleteNhaccct = "Delete from NhaCCCt where idphieuNhap = ? ";
    String delete =  "Delete from phieunhap where idphieunhap=?";

    @Override
    public PhieuNhap insert(PhieuNhap PN) {
        int i = DBConnection.ExcuteDungna(insert,PN.getIdSachCT(), PN.getMa(), PN.getNgay(), PN.getTinhtrang(), PN.getSl(), PN.getGiaNhap());
        return i==1?getByMa(PN.getMa()):null;
    }

    @Override
    public PhieuNhap delete(String id) {
        PhieuNhap PN = getByid(id);
        List<PhieuNhap> _lst = getByidSachCT(PN.getIdSachCT());
        int i=0;
        for (PhieuNhap phieuNhap : _lst) {
            DBConnection.ExcuteDungna(deleteNhaccct, phieuNhap.getId());
            i = DBConnection.ExcuteDungna(delete, phieuNhap.getId());
        }
        return i==0?getByid(id):null;
    }

    @Override
    public PhieuNhap update(PhieuNhap tacGia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PhieuNhap> getAll() {
        return getBySQL(sql);
    }

    @Override
    public PhieuNhap getByMa(String ma) {
        return getBySQL(sql_by_ma, ma).get(0);
    }
    
    private List<PhieuNhap> getBySQL(String sql_query, Object ...args){
        List<PhieuNhap> _lst = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql_query, args);
            while(rs.next()){
                String id = rs.getString(1);
                String idSachct = rs.getString(2);
                String Ma = rs.getString(3);
                Date ngayNhap = rs.getDate(4);
                Boolean tinhTrang = rs.getBoolean(5);
                Integer sl = rs.getInt(6);
                BigDecimal giaNhap = rs.getBigDecimal(7);
                PhieuNhap pn = new PhieuNhap(id, Ma, idSachct, ngayNhap, tinhTrang, sl, giaNhap);
                _lst.add(pn);
            }
            return _lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    

    @Override
    public PhieuNhap getByid(String id) {
        return getBySQL(sql_by_id, id).get(0);
    }

    @Override
    public int InsertNCCCT(String idPhieuNhap, String idnhaCC) {
        PreparedStatement ps = DBConnection.getStmt(insert_nccct, idPhieuNhap, idnhaCC);
        try {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<PhieuNhap> getByidSachCT(String id) {
        return getBySQL(sql_by_id_sachct, id);
    }

    @Override
    public String getIDNCCBYIDpn(String idphieuNhap) {
        try {
            ResultSet rs= DBConnection.getDataFromQuery(sql_nccct, idphieuNhap);
            String id="";
            while(rs.next()){
                if(rs.getString(1).equals("")){
                    continue;
                }
                id = rs.getString(1);
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}

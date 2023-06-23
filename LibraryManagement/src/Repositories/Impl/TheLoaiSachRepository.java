/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.TheLoaiSach;
import Repositories.ITheLoaiRepository;
import Utilities.DBConnection;
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
public class TheLoaiSachRepository implements ITheLoaiRepository{
    
    String sql = "Select * from TheLoaiSach";
    String sql_by_ma = "Select * from TheLoaiSach where IDTheLoaiSach = ?";
    String sql_by_ten = "Select * from TheLoaiSach where TenTL = ?";
    String insert_TLCT = "Insert into TLSachCT(IDSach, IDTLSach) values(?,?)";
    String delete_TLCT = "delete tlsachct where idsach=?";
    String insert_TL = "Insert into TheLoaiSach(TenTL) values(?)";
    String update_TL = "Update TheLoaiSach set TenTl = ? where IdTL = ?";
    
    @Override
    public TheLoaiSach insert(TheLoaiSach tacGia) {
        int i = DBConnection.ExcuteDungna(insert_TL, tacGia.getTen());
        return i==1?getByName(tacGia.getTen()):null;
    }

    @Override
    public TheLoaiSach update(TheLoaiSach tacGia) {
        int i = DBConnection.ExcuteDungna(update_TL, tacGia.getTen(), tacGia.getId());
        return i==1?getByName(tacGia.getTen()):null;
    }

    @Override
    public List<TheLoaiSach> getAll() {
        return getBySQL(sql);
    }

    @Override
    public TheLoaiSach getByID(String ID) {
        return this.getBySQL(sql_by_ma, ID).get(0);
    }
    
    private List<TheLoaiSach> getBySQL(String sql, Object ...args){
        List<TheLoaiSach> _lst = new ArrayList<>();
        PreparedStatement ps = DBConnection.getStmt(sql, args);
        ResultSet rs;
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String ten = rs.getString(2);
                TheLoaiSach theLoai = new TheLoaiSach(id, ten);
                _lst.add(theLoai);
            }
        } catch (SQLException ex) {
            return null;
        }
        return _lst;
    }

    @Override
    public TheLoaiSach getByName(String name) {
        List<TheLoaiSach> tls = getBySQL(sql_by_ten,name);
        if(tls.isEmpty()){
            return null;
        }
        return tls.get(0);
    }

    @Override
    public int insertTheLoaiCT(String idsach, String idTl) {
        PreparedStatement ps = DBConnection.getStmt(insert_TLCT, idsach, idTl);
        try {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public int deleteTheLoaiCT(String idSach) {
        return DBConnection.ExcuteDungna(delete_TLCT, idSach);
    }

    
}

package Repositories.Impl;

import DomainModels.*;
import Repositories.IDocGiaRepository;
import Utilities.DBConnection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class DocGiaRepository implements IDocGiaRepository{
    String sql = "select * from DocGia";
    String sql_by_ma = "select * from DocGia where madocgia like ?";
    String sql_by_ten = "select * from DocGia where TenDOcGia like ?";
    String sql_by_id = "select * from DocGia where idDocGia = ?";
    String insert = "insert into DocGia(MADOCGIA, TenDOcGia, sdt, email, SoCMND, DiaCHi, "
            + "GioiTinh, ngaysinh, img) values (?,?,?,?,?,?,?,?,?)";
    String delete = "Delete from DocGia where madocgia =?";
    String update = "Update docgia set TenDOcGia=?, sdt=?, email=?, SoCMND=?, DiaCHi=?, "
            + "GioiTinh=?, ngaysinh=?, img=? where madocgia=?";
    @Override
    public DocGia insert(DocGia docgia) {
        int i = DBConnection.ExcuteDungna(insert, docgia.getMa(), docgia.getHoTen(),
                docgia.getSdt(), docgia.getEmail(), docgia.getCmnd(), docgia.getDiaChi()
                ,docgia.getGioiTinh(), docgia.getNgaySinh(), docgia.getImg());
        return i==1?getByMa(docgia.getMa()):null;
    }

    @Override
    public DocGia delete(String ma) {
        int i = DBConnection.ExcuteDungna(delete, ma);
        return null;
    }

    @Override
    public DocGia update(DocGia docgia) {
        int i = DBConnection.ExcuteDungna(update, docgia.getHoTen(), docgia.getSdt(),
                docgia.getEmail(), docgia.getCmnd(), docgia.getDiaChi(),docgia.getGioiTinh(),
                docgia.getNgaySinh(), docgia.getImg(), docgia.getMa());
        return i==1?getByMa(docgia.getMa()):null;
    }

    @Override
    public List<DocGia> getAll() {
        return getBySql(sql);
    }
    
    public List<DocGia> getBySql(String sql_query, Object... args) {
        List<DocGia> _lst = new ArrayList<>();
        try {
            ResultSet  rs = DBConnection.getDataFromQuery(sql_query, args);
            while(rs.next()){
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                String cmnd = rs.getString(6);
                Date ngaySinh = rs.getDate(7);
                String diaChi = rs.getString(8);
                Boolean gioiTinh = rs.getBoolean(9);
                String img = rs.getString(10);
                DocGia docGia = new DocGia(id, ma, ten, sdt, email, cmnd, ngaySinh, diaChi, gioiTinh, img);
                _lst.add(docGia);
            }
            return _lst;
        } catch (SQLException ex) {
            System.out.println("lỗi lấy dữ liệu");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public DocGia getByMa(String ma) {
        return getBySql(sql_by_ma, ma).get(0);
    }

    @Override
    public List<DocGia> getBySearch(String tuKhoa) {
        tuKhoa = "%"+tuKhoa+"%";
        //Lấy danh sách bằng mã
        List<DocGia> _lst = getBySql(sql_by_ma, tuKhoa);
        //Lấy danh sách bằng tên
        if (_lst.isEmpty()) {
            _lst = getBySql(sql_by_ten, tuKhoa);
        }
        return _lst;
    }

    @Override
    public DocGia getByID(String ID) {
        return getBySql(sql_by_id, ID).get(0);
    }
    
}

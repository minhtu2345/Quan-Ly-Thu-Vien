/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.TaiKhoan;
import Repositories.IDangNhapRepository;
import Utilities.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DangNhapRepository implements IDangNhapRepository{
    String sql = "Select * from DangNhap";
    String sql_otp = "Select * from DangNhap where otp =?";

    @Override
    public TaiKhoan getTaiKhoan() {
        return getBySql(sql).get(0);
    }

    @Override
    public TaiKhoan getTaiKhoanByOTP(String otp) {
        return getBySql(sql_otp, otp).get(0);
    }
    
    private List<TaiKhoan> getBySql(String sql, Object ...args){
        List<TaiKhoan> _lst = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while(rs.next()){
                String taiKhoana = rs.getString(1);
                String matKhau = rs.getString(2);
                String otp = rs.getString(3);
                TaiKhoan taiKhoan = new TaiKhoan(taiKhoana, matKhau, otp);
                _lst.add(taiKhoan);
            }
        } catch (SQLException ex) {
            return null;
        }
        return _lst;
    }

    @Override
    public Integer login(String taiKhoan, String matKhau) {
        TaiKhoan taiKhoandn = getTaiKhoan();
        int check = taiKhoandn.getTaiKhoan().equals(taiKhoan) && taiKhoandn.getMatKhau().equals(matKhau)?1:-1;
        return check;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IThongKeRepository;
import Utilities.DBConnection;
import ViewModels.SachYeuThich;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeRepository implements IThongKeRepository{
    String sql_sach_yeu_Thich = """
                                  select masach, tensach, count(masach) as luotmuon from sach
                                			join SachCT on sach.IDSach = SachCT.IDSach
                                			join CuonSach on CuonSach.IDSachCT = SachCT.IDSachCT
                                			join PhieuMuonCT on CuonSach.idCuonSach = PhieuMuonCT.idCuonSach
                                            group by MASACH, tensach 
                                            order by luotmuon desc
                                """;
    
    @Override
    public List<SachYeuThich> getSachYeuThich() {
        List<SachYeuThich> _lst = new ArrayList<>();
        try {
            ResultSet  rs = DBConnection.getDataFromQuery(sql_sach_yeu_Thich);
            while(rs.next()){
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                int luotmuon = rs.getInt(3);
                SachYeuThich sach = new SachYeuThich(ma, ten, luotmuon);
                _lst.add(sach);
            }
            return _lst;
        } catch (SQLException ex) {
            System.out.println("lỗi lấy dữ liệu");
            ex.printStackTrace();
            return null;
        }
    }
    
}

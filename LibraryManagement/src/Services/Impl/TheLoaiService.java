/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.TheLoaiSach;
import Repositories.ITheLoaiRepository;
import Repositories.Impl.TheLoaiSachRepository;
import Services.ITheLoaiSachService;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class TheLoaiService implements ITheLoaiSachService{
    final TheLoaiSachRepository REPO;

    public TheLoaiService() {
        this.REPO = new TheLoaiSachRepository();
    }
    
    @Override
    public void insert(TheLoaiSach loaiSach, Component c) {
        TheLoaiSach Exist = REPO.getByName(loaiSach.getTen());
        String mess = Exist!=null?"Thể loại sách đã tồn tại trong danh sách":"";
        if(!mess.equals("")){
            JOptionPane.showMessageDialog(c, mess);
            return;
        }
        TheLoaiSach tls = REPO.insert(loaiSach);
        mess = tls!=null?"Thêm thể loại sách thành công":"Thêm thể loại sách thất bại";
        JOptionPane.showMessageDialog(c, mess);
    }

    @Override
    public void update(TheLoaiSach loaiSach, Component c) {
        TheLoaiSach tls = REPO.update(loaiSach);
        String mess = tls!=null?"Sửa thể loại sách thành công":"Sửa thể loại sách thất bại";
        JOptionPane.showMessageDialog(c, mess);
    }

    @Override
    public List<TheLoaiSach> getAll() {
        return REPO.getAll();
    }

    @Override
    public TheLoaiSach getByID(String ID) {
        return REPO.getByID(ID);
    }

    @Override
    public TheLoaiSach getByName(String name) {
        return REPO.getByName(name);
    }

    @Override
    public int insertTLCT(String idSach, String idtl) {
        return REPO.insertTheLoaiCT(idSach, idtl);
    }


    @Override
    public int deleteTheLoaiCT(String idSach) {
        return REPO.deleteTheLoaiCT(idSach);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.Sach;
import Repositories.Impl.SachRepository;
import Services.ISachService;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SachService implements ISachService {

    final SachRepository REPO;
    
    public SachService() {
        this.REPO = new SachRepository();
    }
    
    @Override
    public Sach insert(Sach sach) {
        return REPO.insert(sach);
    }
    
    @Override
    public void delete(Sach sach, Component c) {
        Sach getSachD = REPO.delete(sach);
        String mess;
        mess = getSachD==null?"Xóa sách thành công":"Xóa sách thất bại";
        JOptionPane.showMessageDialog(c, mess);
    }
    
    @Override
    public Sach update(Sach sach) {
        return REPO.update(sach);
    }
    
    @Override
    public List<Sach> getAll() {
        return REPO.getAll();
    }
    
    @Override
    public Sach getByMa(String ma) {
        return REPO.getByMa(ma);
    }
    
    @Override
    public Sach getByID(String id) {
        return REPO.getByID(id);
    }

    
}

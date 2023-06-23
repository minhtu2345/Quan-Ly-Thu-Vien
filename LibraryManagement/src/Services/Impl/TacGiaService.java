/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.Sach;
import DomainModels.TacGia;
import Repositories.Impl.TacGiaRepository;
import Services.ITacGiaService;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class TacGiaService implements ITacGiaService {
    
    final TacGiaRepository REPO;
    
    public TacGiaService() {
        this.REPO = new TacGiaRepository();
    }
    
    @Override
    public void insert(TacGia tacGia, Component c) {
        TacGia tg = REPO.insert(tacGia);
        String mess = tg==null?"Thêm tác giả thất bại!":"Thêm tác giả thành công!";
        JOptionPane.showMessageDialog(c, mess);
    }
    
    @Override
    public void update(TacGia tacGia, Component c) {
        TacGia tg = REPO.update(tacGia);
        String mess = tg==null?"Sửa tác giả thất bại!":"Sửa tác giả thành công!";
        JOptionPane.showMessageDialog(c, mess);
    }
    
    @Override
    public List<TacGia> getAll() {
        return REPO.getAll();
    }
    
    @Override
    public TacGia getByMa(String ma) {
        return REPO.getByMa(ma);
    }
    
    @Override
    public void insertTGCT(String idsach, String idTG) {
        REPO.InsertTacGiaCT(idsach, idTG);
    } 

    @Override
    public int deleteTacGiaCT(Sach sach) {
        return REPO.deleteTacGiaCT(sach);
    }
    
}

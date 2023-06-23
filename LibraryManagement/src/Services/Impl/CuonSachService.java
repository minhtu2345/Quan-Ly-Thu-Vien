/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.CuonSach;
import Repositories.Impl.CuonSachRepository;
import Services.ICuonSachService;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CuonSachService implements ICuonSachService{
    final CuonSachRepository REPO;

    public CuonSachService() {
        this.REPO = new CuonSachRepository();
    }
    
    
    @Override
    public CuonSach insert(int soluong, CuonSach cuonSach, int soBatDau) {
        return REPO.insert(soluong, cuonSach, soBatDau);
    }

    @Override
    public void delete(String id, Component c) {
        CuonSach cs= REPO.delete(id);
        String mess = cs==null?"":"Cuốn sách đang được mượn\n Không thể xóa hoặc giảm số lượng";
        if(!mess.equals("")){
            JOptionPane.showMessageDialog(c, mess);
        }
    }

    @Override
    public CuonSach update(CuonSach cuonSach) {
        return REPO.update(cuonSach);
    }

    @Override
    public List<CuonSach> getAll() {
        return REPO.getAll();
    }

    @Override
    public List<CuonSach> getByIDSachCT(String id) {
        return  REPO.getByIDSachCT(id);
    }

    @Override
    public List<CuonSach> getByID(String id) {
        return REPO.getByID(id);
    }

    @Override
    public List<CuonSach> getByMa(String id) {
        return REPO.getByMa(id);
    }

    @Override
    public CuonSach getByMaAndID(String id, String ma) {
        return REPO.getByMaAndID(id, ma);
    }

    @Override
    public List<CuonSach> getByTinhTrangNID(String tinhTrang, String id) {
        return REPO.getByTinhTrangNID(tinhTrang, id);
    }

    @Override
    public List<CuonSach> getSachDuocMuon(String idsachCt) {
        return REPO.getSachDuocMuon(idsachCt);
    }

}

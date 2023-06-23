/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.NhaXuatBan;
import Repositories.Impl.NhaXuatBanRepository;
import Services.INhaXuatBanService;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NhaXuatBanService implements INhaXuatBanService {
    
    final NhaXuatBanRepository REPO;
    
    public NhaXuatBanService() {
        this.REPO = new NhaXuatBanRepository();
    }
    
    @Override
    public void insert(NhaXuatBan nhaXuatBan, Component c) {
        NhaXuatBan nxb = REPO.getByNameNDiaChi(nhaXuatBan.getTen(), nhaXuatBan.getDiaChi());
        String mess = nxb!=null?"Nhà xuất bản đã có sẵn trong danh sách":"";
        if(!mess.equals("")){
            JOptionPane.showMessageDialog(c, mess);
            return;
        }
        nxb = REPO.insert(nhaXuatBan);
        mess = nxb!=null?"Thêm nhà xuất bản thành công":"Thêm nhà xuất bản thất bại";
        JOptionPane.showMessageDialog(c, mess);
    }
    
    
    @Override
    public void update(NhaXuatBan nhaXuatBan, Component c) {
        NhaXuatBan nxb = REPO.update(nhaXuatBan);
        String mess = nxb!=null?"Sửa nhà xuất bản thành công":"Sửa nhà xuất bản thất bại";
        JOptionPane.showMessageDialog(c, mess);
    }
    
    @Override
    public List<NhaXuatBan> getAll() {
        return REPO.getAll();
    }
    
    @Override
    public NhaXuatBan getByID(String id) {
        return REPO.getByID(id);
    }
    
    @Override
    public int insertNXBCT(String idNXB, String idSachCt) {
        return REPO.insertNXBCT(idNXB, idSachCt);
    }
    
    @Override
    public NhaXuatBan getByNameNDiaChi(String ten, String diaChi) {
        return REPO.getByNameNDiaChi(ten, diaChi);
    }

    @Override
    public int deleteNXBCT(String idSachCT) {
        return REPO.deleteNXBCT(idSachCT);
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.NhaCC;
import Repositories.Impl.NhaCCRepository;
import Services.INhaCCService;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NhaCCService implements INhaCCService {
    final NhaCCRepository REPO;

    public NhaCCService() {
        this.REPO = new NhaCCRepository();
    }
    
    

    @Override
    public void Insert(NhaCC nhacc, Component c) {
        NhaCC ncc = REPO.getByNameNDiaChi(nhacc.getTen(), nhacc.getDiaChi());
        String mess = ncc!=null?"Nhà cung cấp đã có sẵn trong danh sách":"";
        if(!mess.equals("")){
            JOptionPane.showMessageDialog(c, mess);
            return;
        }
        ncc = REPO.Insert(nhacc);
        mess = ncc!=null?"Thêm nhà cung cấp thành công":"Thêm nhà cung cấp thất bại";
        JOptionPane.showMessageDialog(c, mess);
    }

    @Override
    public void Update(NhaCC nhacc, Component c) {
        NhaCC ncc = REPO.Update(nhacc);
        String mess = ncc!=null?"Sửa nhà cung cấp thành công":"Sửa nhà cung cấp thất bại";
        JOptionPane.showMessageDialog(c, mess);
    }

    @Override
    public List<NhaCC> getAll() {
        return REPO.getAll();
    }

    @Override
    public NhaCC getByID(String id) {
        return REPO.getByID(id);
    }

    @Override
    public NhaCC getByNameNDiaChi(String ten, String diaChi) {
        return REPO.getByNameNDiaChi(ten, diaChi);
    }
    
    
}

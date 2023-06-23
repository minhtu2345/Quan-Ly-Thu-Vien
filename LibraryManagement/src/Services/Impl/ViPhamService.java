/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.LoiVP;
import Repositories.Impl.ViPhamRepositoryImpl;
import Repositories.ViPhamRepository;
import Services.IViPhamService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ViPhamService implements IViPhamService{
    final ViPhamRepositoryImpl REPO;

    public ViPhamService() {
        this.REPO = new ViPhamRepositoryImpl();
    }
    
    @Override
    public List<LoiVP> getAll() {
        return REPO.getAll();
    }

    @Override
    public void Them(LoiVP loiVP) {
        REPO.Them(loiVP);
    }

    @Override
    public void Sua(String ma, LoiVP loiVP) {
        REPO.Sua(ma, loiVP);
    }

    @Override
    public void Xoa(String ma) {
        REPO.Xoa(ma);
    }

    @Override
    public LoiVP getByTen(String ten) {
        return REPO.getByTen(ten);
    }

    @Override
    public LoiVP getByid(String id) {
        return REPO.getByid(id);
    }
    
}

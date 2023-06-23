/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.LoiVP;
import Repositories.Impl.ViPhamRepositoryImpl;
import Repositories.ViPhamRepository;
import Services.LoiVPServices;
import java.util.List;

/**
 *
 * @author Apc
 */
public class LoiVPRepoditoryImpl implements LoiVPServices{
    private ViPhamRepository loiVPrepository;

    public LoiVPRepoditoryImpl() {
        loiVPrepository = new ViPhamRepositoryImpl();
    }
    
    
    @Override
    public List<LoiVP> getLoiVPs() {
        List<LoiVP> loiVPs = loiVPrepository.getAll();
        return loiVPs;
    }

    @Override
    public void Them(LoiVP loiVP) {
        loiVPrepository.Them(loiVP);
    }

    @Override
    public void Sua(LoiVP loiVP, String id) {
        loiVPrepository.Sua(id, loiVP);
    }

    @Override
    public void Xoa(String id) {
        loiVPrepository.Xoa(id);
    }
    
}

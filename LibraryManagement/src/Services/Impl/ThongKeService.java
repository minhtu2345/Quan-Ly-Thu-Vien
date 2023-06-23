/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import Repositories.Impl.ThongKeRepository;
import Services.IThongKeService;
import ViewModels.SachYeuThich;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeService implements IThongKeService{
    ThongKeRepository repo;

    public ThongKeService() {
        repo = new ThongKeRepository();
    }
    
    @Override
    public List<SachYeuThich> getSachYeuThich() {
        return repo.getSachYeuThich();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import Repositories.Impl.KhoSachImpl;
import Repositories.KhoSachRepository;
import Services.KhoSachService;
import ViewModels.KhoSachViewModels;
import ViewModels.SachCTViewModel;
import java.util.List;

/**
 *
 * @author Apc
 */
public class KhoSachServices implements KhoSachService {

    private KhoSachRepository khoSach;

    public KhoSachServices() {
        khoSach = new KhoSachImpl();
    }
    

    @Override
    public List<KhoSachViewModels> getAll() {
        return khoSach.getALl();
    }

    @Override
    public SachCTViewModel getKhoSachView(String ma) {
        return khoSach.getKhoSachView(ma);
    }

    @Override
    public List<KhoSachViewModels> getBySearch(String tuKhoa) {
        return khoSach.getBySearch(tuKhoa);
    }

}

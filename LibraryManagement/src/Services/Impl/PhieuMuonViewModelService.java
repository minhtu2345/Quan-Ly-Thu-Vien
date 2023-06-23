/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import Repositories.Impl.PhieuMuonViewModelRepository;
import ViewModels.PhieuMuonTableViewModel;
import java.util.List;
import Services.IPhieuMuonViewModelService;
import ViewModels.PhieuMuonViewModel;

/**
 *
 * @author Admin
 */
public class PhieuMuonViewModelService implements IPhieuMuonViewModelService{
    PhieuMuonViewModelRepository REPO;

    public PhieuMuonViewModelService() {
        this.REPO = new PhieuMuonViewModelRepository();
    }

    @Override
    public List<PhieuMuonTableViewModel> getAll() {
        return REPO.getAll();
    }

    @Override
    public PhieuMuonViewModel getByMaPhieu(String ma) {
        return REPO.getByMaPhieu(ma);
    }

    @Override
    public List<PhieuMuonTableViewModel> getByKeyWord(String tuKhoa) {
        return REPO.getByKeyWord(tuKhoa);
    }
    
}

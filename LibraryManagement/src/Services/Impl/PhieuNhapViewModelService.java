/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.PhieuNhap;
import Repositories.Impl.PhieuNhapViewModelRepository;
import Services.IPhieuNhapViewModelService;
import ViewModels.PhieuNhapViewmodel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuNhapViewModelService implements IPhieuNhapViewModelService {

    final PhieuNhapViewModelRepository REPO;

    public PhieuNhapViewModelService() {
        REPO = new PhieuNhapViewModelRepository();
    }
    

    @Override
    public PhieuNhapViewmodel getPhieuNhapView(String ma, PhieuNhap pn) {
        return REPO.getPhieuNhapView(ma, pn);
    }

    @Override
    public List<PhieuNhapViewmodel> getAll() {
        return REPO.getAll();
    }

    @Override
    public List<PhieuNhapViewmodel> getByMa(String ma) {
        return REPO.getByMa(ma);
    }

}

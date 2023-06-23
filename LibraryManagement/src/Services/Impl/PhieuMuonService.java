/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.PhieuMuon;
import Repositories.Impl.PhieuMuonRepository;
import Services.IPhieuMuonService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuMuonService implements IPhieuMuonService{
    final PhieuMuonRepository REPO;

    public PhieuMuonService() {
        this.REPO = new PhieuMuonRepository();
    }
    

    @Override
    public PhieuMuon insert(PhieuMuon phieuMuon) {
        return REPO.insert(phieuMuon);
    }

    @Override
    public PhieuMuon delete(String id) {
        return REPO.delete(id);
    }

    @Override
    public List<PhieuMuon> getAll() {
        return REPO.getAll();
    }

    @Override
    public PhieuMuon getByMa(String ma) {
        return REPO.getByMa(ma);
    }

    @Override
    public List<PhieuMuon> getBySearch(String tuKhoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PhieuMuon getByID(String ID) {
        return REPO.getByID(ID);
    }

    @Override
    public PhieuMuon TraSach(String ma, int loai) {
        return REPO.TraSach(ma, loai);
    }
    
}

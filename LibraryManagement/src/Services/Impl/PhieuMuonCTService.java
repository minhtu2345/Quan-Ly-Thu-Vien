/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.PhieuMuonCT;
import Repositories.Impl.PhieuMuonCTRepository;
import Services.IPhieuMuonCTService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuMuonCTService  implements IPhieuMuonCTService{
    final PhieuMuonCTRepository REPO;

    public PhieuMuonCTService() {
        this.REPO = new PhieuMuonCTRepository();
    }
    
    
    @Override
    public PhieuMuonCT insert(PhieuMuonCT phieuMuonct) {
        return REPO.insert(phieuMuonct);
    }

    @Override
    public PhieuMuonCT delete(String ma) {
        return REPO.delete(ma);
    }

    @Override
    public List<PhieuMuonCT> getAll() {
        return REPO.getAll();
    }

    @Override
    public PhieuMuonCT getByManID(String ma, String id) {
        return REPO.getByManID(ma, id);
    }

    @Override
    public List<PhieuMuonCT> getBySearch(String tuKhoa) {
        return REPO.getBySearch(tuKhoa);
    }

    @Override
    public List<PhieuMuonCT> getByMa(String ma) {
        return REPO.getByMa(ma);
    }

    @Override
    public List<PhieuMuonCT> getByIDCuonSach(String id) {
        return REPO.getByIDCuonSach(id);
    }

    @Override
    public String LuotMuonSach(String idSachCT) {
        return REPO.LuotMuonSach(idSachCT);
    }
    
}

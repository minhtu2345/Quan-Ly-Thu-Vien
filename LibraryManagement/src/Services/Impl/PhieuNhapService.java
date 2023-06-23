/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.PhieuNhap;
import Repositories.Impl.PhieuNhapRepository;
import Services.IPhieuNhapService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuNhapService implements IPhieuNhapService{
    final PhieuNhapRepository REPO;

    public PhieuNhapService() {
        this.REPO = new PhieuNhapRepository();
    }

    @Override
    public PhieuNhap insert(PhieuNhap phieuNhap) {
        return REPO.insert(phieuNhap);
    }

    @Override
    public PhieuNhap delete(String id) {
        return REPO.delete(id);
    }

    @Override
    public PhieuNhap update(PhieuNhap phieuNhap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PhieuNhap> getAll() {
        return REPO.getAll();
    }

    @Override
    public PhieuNhap getByMa(String ma) {
        return REPO.getByMa(ma);
    }

    @Override
    public int InsertNCCCT(String idPhieuNhap, String nhaCC) {
        return REPO.InsertNCCCT(idPhieuNhap, nhaCC);
    }

    @Override
    public PhieuNhap getByID(String id) {
        return REPO.getByid(id);
    }

    @Override
    public List<PhieuNhap> getByidSachCT(String id) {
        return REPO.getByidSachCT(id);
    }

    @Override
    public String getIDNCCBYIDpn(String idphieuNhap) {
        return REPO.getIDNCCBYIDpn(idphieuNhap);
    }
    
}

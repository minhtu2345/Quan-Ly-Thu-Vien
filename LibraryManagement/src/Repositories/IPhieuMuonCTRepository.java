/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.PhieuMuonCT;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IPhieuMuonCTRepository {
    public PhieuMuonCT insert(PhieuMuonCT phieuMuonct);
    public PhieuMuonCT delete(String id);
    public List<PhieuMuonCT> getAll();
    public PhieuMuonCT getByManID(String ma, String id);
    public List<PhieuMuonCT> getByMa(String ma);
    public List<PhieuMuonCT> getBySearch(String tuKhoa);
    public List<PhieuMuonCT> getByIDCuonSach(String id);
    public String LuotMuonSach(String idSachCT);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.PhieuMuon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IPhieuMuonRepository {
    public PhieuMuon insert(PhieuMuon phieuMuon);
    public PhieuMuon delete(String id);
    public PhieuMuon TraSach(String ma, int loai);
    public List<PhieuMuon> getAll();
    public PhieuMuon getByMa(String ma);
    public PhieuMuon getByID(String ID);
    public List<PhieuMuon> getBySearch(String tuKhoa);
}

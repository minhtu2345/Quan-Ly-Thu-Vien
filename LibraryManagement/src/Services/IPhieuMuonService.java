/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.PhieuMuon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IPhieuMuonService {
    public PhieuMuon insert(PhieuMuon phieuMuon);
    public PhieuMuon delete(String ma);
    public List<PhieuMuon> getAll();
    public PhieuMuon getByMa(String ma);
    public PhieuMuon getByID(String ID);
    public List<PhieuMuon> getBySearch(String tuKhoa);
    public PhieuMuon TraSach(String ma, int loai);
}

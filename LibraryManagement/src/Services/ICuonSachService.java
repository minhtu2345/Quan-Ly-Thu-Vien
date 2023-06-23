/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.CuonSach;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICuonSachService {
    public CuonSach insert(int soluong, CuonSach cuonSach, int soBatDau);
    public void delete(String id, Component c);
    public List<CuonSach> getAll();
    public List<CuonSach> getByIDSachCT(String id);
    public List<CuonSach> getByID(String id);
    public List<CuonSach> getByMa(String id);
    public CuonSach getByMaAndID(String id, String ma);
    public CuonSach update(CuonSach cuonSach);
    public List<CuonSach> getByTinhTrangNID(String tinhTrang, String id);
    public List<CuonSach> getSachDuocMuon(String idsachCt);
    
}

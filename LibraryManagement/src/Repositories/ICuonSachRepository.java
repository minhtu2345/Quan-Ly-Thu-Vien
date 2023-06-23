/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.CuonSach;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICuonSachRepository {
    public CuonSach insert(int soluong, CuonSach cuonSach, int soBatDau);
    public CuonSach delete(String id);
    public CuonSach update(CuonSach  cs);
    public List<CuonSach> getAll();
    public List<CuonSach> getByIDSachCT(String id);
    public List<CuonSach> getByTinhTrangNID(String tinhTrang, String id);
    public List<CuonSach> getByID(String id);
    public List<CuonSach> getByMa(String id);
    public CuonSach getByMaAndID(String id, String ma);
    public List<CuonSach> getSachDuocMuon(String idsachCt);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.PhieuNhap;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IPhieuNhapRepository {
    public PhieuNhap insert(PhieuNhap phieuNhap);
    public PhieuNhap delete(String id);
    public PhieuNhap update(PhieuNhap phieuNhap);
    public List<PhieuNhap> getAll();
    public PhieuNhap getByMa(String Ma);
    public PhieuNhap getByid(String id);
    public List<PhieuNhap> getByidSachCT(String id);
    public String getIDNCCBYIDpn(String idphieuNhap);
    public int InsertNCCCT(String idPhieuNhap, String nhaCC); 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NhaXuatBan;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhaXuatBanRepository {
    public NhaXuatBan insert(NhaXuatBan nhaXuatBan);
    public NhaXuatBan update(NhaXuatBan nhaXuatBan);
    public List<NhaXuatBan> getAll();
    public NhaXuatBan getByID(String id);
    public NhaXuatBan getByNameNDiaChi(String ten, String diaChi);
    public int insertNXBCT(String idNXB, String idSachCT); 
    public int deleteNXBCT(String idSachCT); 
}

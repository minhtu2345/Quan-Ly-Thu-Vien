/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhaXuatBan;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhaXuatBanService {
    public void insert(NhaXuatBan nhaXuatBan, Component c);
    public void update(NhaXuatBan nhaXuatBan, Component c);
    public List<NhaXuatBan> getAll();
    public NhaXuatBan getByID(String id);
    public NhaXuatBan getByNameNDiaChi(String ten, String diaChi);
    public int insertNXBCT(String idNXB, String idSachCT); 
    public int deleteNXBCT(String idSachCT); 
}

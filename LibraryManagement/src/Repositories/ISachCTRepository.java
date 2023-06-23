/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NhaXuatBan;
import DomainModels.Sach;
import DomainModels.SachCT;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISachCTRepository {
    public SachCT insert(SachCT sachCT);
    public SachCT delete(SachCT sach);
    public SachCT update(SachCT sachCT);
    public List<SachCT> getAll();
    public SachCT getByIDSach(String ID);
    public SachCT getByID(String ID);
    public SachCT getByBarcode(String barcode);
    public int CountCSBYIDSachCT (String id);
    
}

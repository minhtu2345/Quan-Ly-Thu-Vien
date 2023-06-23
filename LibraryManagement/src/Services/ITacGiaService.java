/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.Sach;
import DomainModels.TacGia;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ITacGiaService {
    public void insert(TacGia tacGia, Component c);
    public void update(TacGia tacGia, Component c);
    public List<TacGia> getAll();
    public TacGia getByMa(String ma);
    public void insertTGCT(String idsach, String idTG);
    public int deleteTacGiaCT(Sach sach);
}

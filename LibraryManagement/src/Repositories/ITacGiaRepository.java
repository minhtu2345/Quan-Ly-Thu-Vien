/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Sach;
import DomainModels.TacGia;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ITacGiaRepository {
    public TacGia insert(TacGia tacGia);
    public TacGia update(TacGia tacGia);
    public List<TacGia> getAll();
    public TacGia getByMa(String ma);
    public TacGia getByID(String id);
    public int InsertTacGiaCT(String idsach, String idTacGia);
    public int deleteTacGiaCT(Sach sach);
   
}

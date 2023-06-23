/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.TheLoaiSach;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ITheLoaiRepository {
    public TheLoaiSach insert(TheLoaiSach loaiSach);
    public TheLoaiSach update(TheLoaiSach loaiSach);
    public List<TheLoaiSach> getAll();
    public TheLoaiSach getByID(String ID);
    public TheLoaiSach getByName(String name);
    public int insertTheLoaiCT(String idSach, String idTheLoai);
    public int deleteTheLoaiCT(String idSach);
}

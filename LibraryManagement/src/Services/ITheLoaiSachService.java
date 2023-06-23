/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.TheLoaiSach;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ITheLoaiSachService {
    public void insert(TheLoaiSach loaiSach, Component c);
    public void update(TheLoaiSach loaiSach, Component c);
    public List<TheLoaiSach> getAll();
    public TheLoaiSach getByID(String ID);
    public TheLoaiSach getByName(String name);
    public int insertTLCT(String idSach, String idtl);
    public int deleteTheLoaiCT(String idSach);
}

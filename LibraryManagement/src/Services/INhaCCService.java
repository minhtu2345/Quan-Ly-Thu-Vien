/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhaCC;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhaCCService {
    public void Insert(NhaCC nhacc, Component c);
    public void Update(NhaCC nhacc, Component c);
    public List<NhaCC> getAll();
    public NhaCC getByID(String id);
    public NhaCC getByNameNDiaChi(String ten,String diaChi);
}

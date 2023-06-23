/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.Sach;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISachService {
    public Sach insert(Sach khoSach);
    public void delete(Sach sach, Component c);
    public Sach update(Sach sach);
    public List<Sach> getAll();
    public Sach getByMa(String Ma);
    public Sach getByID(String id);
}

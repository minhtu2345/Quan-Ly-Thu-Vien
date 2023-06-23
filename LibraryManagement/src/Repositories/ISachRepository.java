/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Sach;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISachRepository {
    public Sach insert(Sach khoSach);
    public Sach delete(Sach sach);
    public Sach update(Sach khoSach);
    public List<Sach> getAll();
    public Sach getByMa(String Ma);
    public Sach getByID(String id);
}

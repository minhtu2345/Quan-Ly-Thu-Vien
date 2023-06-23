/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.LoiVP;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IViPhamService {
    List<LoiVP> getAll();
    void Them(LoiVP loiVP);
    void Sua(String ma,LoiVP loiVP);
    void Xoa(String ma);
    LoiVP getByTen(String ten);
    LoiVP getByid(String id);
}

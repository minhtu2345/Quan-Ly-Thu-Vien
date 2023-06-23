/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.LoiVP;
import java.util.List;

/**
 *
 * @author Apc
 */
public interface LoiVPServices {
    List<LoiVP> getLoiVPs();
    void Them(LoiVP loiVP);
    void Sua(LoiVP loiVP,String id);
    void Xoa(String id);
}

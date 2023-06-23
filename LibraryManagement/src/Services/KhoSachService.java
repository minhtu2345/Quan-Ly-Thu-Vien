/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.KhoSachViewModels;
import ViewModels.SachCTViewModel;
import java.util.List;

/**
 *
 * @author Apc
 */
public interface KhoSachService {
    List<KhoSachViewModels> getAll();
    public SachCTViewModel getKhoSachView(String ma);
    List<KhoSachViewModels> getBySearch(String tuKhoa); 
    
}

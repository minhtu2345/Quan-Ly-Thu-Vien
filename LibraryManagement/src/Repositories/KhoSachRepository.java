/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import ViewModels.KhoSachViewModels;
import ViewModels.SachCTViewModel;
import java.util.List;


/**
 *
 * @author Apc
 */
public interface KhoSachRepository {
    List<KhoSachViewModels> getALl();
    public SachCTViewModel getKhoSachView(String ma);
    List<KhoSachViewModels> getBySearch(String tuKhoa); 
}

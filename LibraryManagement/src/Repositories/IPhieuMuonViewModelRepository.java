/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import ViewModels.PhieuMuonTableViewModel;
import ViewModels.PhieuMuonViewModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IPhieuMuonViewModelRepository {
    public List<PhieuMuonTableViewModel> getAll();
    public PhieuMuonViewModel getByMaPhieu(String ma);
    public List<PhieuMuonTableViewModel> getByKeyWord(String tuKhoa);
}

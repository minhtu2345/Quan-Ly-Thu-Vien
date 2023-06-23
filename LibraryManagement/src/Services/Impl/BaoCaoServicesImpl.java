/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.ViPham;
import Repositories.BaoCaoRepositories;
import Repositories.Impl.BaoCaoreposotoriesImpl;
import Services.BaoCaoServices;
import ViewModels.BaoCaoDSViewModels;
import ViewModels.BaoCaoPMViewModels;
import java.util.List;

/**
 *
 * @author Apc
 */
public class BaoCaoServicesImpl implements BaoCaoServices{
    private BaoCaoRepositories BaoCaoRepositories;

    public BaoCaoServicesImpl() {
        BaoCaoRepositories = new BaoCaoreposotoriesImpl();
    }
    
    
    @Override
    public List<BaoCaoPMViewModels> getPhieuMuonByMa(String ma) {
        List<BaoCaoPMViewModels> baoCaoPMViewModelses = BaoCaoRepositories.getPhieuMuonByMa(ma);
        return baoCaoPMViewModelses;
    }
    @Override
    public List<BaoCaoDSViewModels> LoadTableBaoCao() {
        List<BaoCaoDSViewModels> baoCaoDSViewModelses = BaoCaoRepositories.LoadTableBaoCao();
        return baoCaoDSViewModelses;
    }
    @Override
    public List<ViPham> LoadtableViPhams(String ma) {
        //System.out.println(ma);
        List<ViPham> getBaoCaoByPM = BaoCaoRepositories.getBaoCaoBymaPM(ma);
        return getBaoCaoByPM;
    }

    @Override
    public ViPham Them(ViPham vp) {
        BaoCaoRepositories.Them(vp);
        return getBaoCaoBymaPM(vp.getMaPM()).get(0);
    }

    @Override
    public void Sua(String ma,ViPham vp) {
        BaoCaoRepositories.Sua(vp, ma);
    }

    @Override
    public void Xoa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BaoCaoDSViewModels> getByMaDG(String maDG) {
        List<BaoCaoDSViewModels> timKiem = BaoCaoRepositories.getByMaDG(maDG);
        return timKiem;
    }

    @Override
    public void insertLoiVpCT(String idViPham, String idLoiViPham) {
        BaoCaoRepositories.insertLoiVpCT(idViPham, idLoiViPham);
    }

    @Override
    public List<ViPham> getAll() {
        return BaoCaoRepositories.getAll();
    }

    @Override
    public List<String> getLoiThuocViPham(String id) {
        return BaoCaoRepositories.getLoiThuocViPham(id);
    }

    @Override
    public List<ViPham> getBaoCaoBymaPM(String ma) {
            return BaoCaoRepositories.getBaoCaoBymaPM(ma);
    }

    
}

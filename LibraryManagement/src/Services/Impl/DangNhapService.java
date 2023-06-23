/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.TaiKhoan;
import Repositories.Impl.DangNhapRepository;
import Services.IDangNhapService;

/**
 *
 * @author Admin
 */
public class DangNhapService implements IDangNhapService{
    final DangNhapRepository REPO;

    public DangNhapService() {
        this.REPO = new DangNhapRepository();
    }

    @Override
    public TaiKhoan getTaiKhoan() {
        return REPO.getTaiKhoan();
    }

    @Override
    public TaiKhoan getTaiKhoanByOTP(String otp) {
        return REPO.getTaiKhoanByOTP(otp);
    }

    @Override
    public Integer login(String taiKhoan, String matKhau) {
        return REPO.login(taiKhoan, matKhau);
    }
    
}

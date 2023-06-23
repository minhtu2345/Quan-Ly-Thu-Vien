/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.TaiKhoan;

/**
 *
 * @author Admin
 */
public interface IDangNhapRepository {
    public TaiKhoan getTaiKhoan();
    public TaiKhoan getTaiKhoanByOTP(String otp);
    public Integer login(String taiKhoan, String matKhau);
}

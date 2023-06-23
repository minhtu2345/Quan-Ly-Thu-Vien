/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Admin
 */
public class TaiKhoan {
    private String taiKhoan;
    private String matKhau;
    private String otp;

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan, String matKhau, String otp) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.otp = otp;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getOtp() {
        return otp;
    }
    
    
}

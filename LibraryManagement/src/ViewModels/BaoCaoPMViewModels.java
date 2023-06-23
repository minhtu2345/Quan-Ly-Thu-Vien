/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author Apc
 */
public class BaoCaoPMViewModels {
    private String tenDG;
    private String tenSach;
    private Date ngayMuon;

    public BaoCaoPMViewModels() {
    }

    public BaoCaoPMViewModels(String tenDG, String tenSach, Date ngayMuon) {
        this.tenDG = tenDG;
        this.tenSach = tenSach;
        this.ngayMuon = ngayMuon;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    @Override
    public String toString() {
        return "BaoCaoPMViewModels{" + "tenDG=" + tenDG + ", tenSach=" + tenSach + ", ngayMuon=" + ngayMuon + '}';
    }
    
    
}

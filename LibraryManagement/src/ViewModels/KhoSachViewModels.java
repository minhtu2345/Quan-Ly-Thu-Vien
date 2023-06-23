/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.List;

/**
 *
 * @author Apc
 */
public class KhoSachViewModels {
    private String MaSach;
    private String TenSach;
    private List<String> TenLoaiSach;

    public KhoSachViewModels() {
    }

    public KhoSachViewModels(String MaSach, String TenSach, List<String> TenLoaiSach) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenLoaiSach = TenLoaiSach;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public List<String> getTenLoaiSach() {
        return TenLoaiSach;
    }

    public void setTenLoaiSach(List<String> TenLoaiSach) {
        this.TenLoaiSach = TenLoaiSach;
    }

    @Override
    public String toString() {
        return "KhoSachViewModels{" + "MaSach=" + MaSach + ", TenSach=" + TenSach + ", TenLoaiSach=" + TenLoaiSach + '}';
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Admin
 */
public class SachYeuThich {
    private String masach;
    private String tenSach;
    private Integer luotMuon;

    public SachYeuThich() {
    }

    public SachYeuThich(String masach, String tenSach, Integer luotMuon) {
        this.masach = masach;
        this.tenSach = tenSach;
        this.luotMuon = luotMuon;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Integer getLuotMuon() {
        return luotMuon;
    }

    public void setLuotMuon(Integer luotMuon) {
        this.luotMuon = luotMuon;
    }
    
    
}

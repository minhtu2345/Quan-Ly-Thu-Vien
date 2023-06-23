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
public class BaoCaoDSViewModels {
    private String maPM;
    private String maDG;
    private Date ngayViet;

    public BaoCaoDSViewModels() {
    }

    public BaoCaoDSViewModels(String maPM, String maDG, Date ngayViet) {
        this.maPM = maPM;
        this.maDG = maDG;
        this.ngayViet = ngayViet;
    }

    public String getMaPM() {
        return maPM;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public Date getNgayViet() {
        return ngayViet;
    }

    public void setNgayViet(Date ngayViet) {
        this.ngayViet = ngayViet;
    }
    
}

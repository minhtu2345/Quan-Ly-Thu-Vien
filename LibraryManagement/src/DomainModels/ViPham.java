/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author Apc
 */
public class ViPham {
    private String idVP;
    private Date ngayVP;
    private String hinhPhat;
    private String moTa;
    private String maPM;

    public ViPham() {
    }

    public ViPham(String idVP, Date ngayVP, String hinhPhat, String moTa, String maPM) {
        this.idVP = idVP;
        this.ngayVP = ngayVP;
        this.hinhPhat = hinhPhat;
        this.moTa = moTa;
        this.maPM = maPM;
    }

    public String getIdVP() {
        return idVP;
    }

    public void setIdVP(String idVP) {
        this.idVP = idVP;
    }

    public Date getNgayVP() {
        return ngayVP;
    }

    public void setNgayVP(Date ngayVP) {
        this.ngayVP = ngayVP;
    }

    public String getHinhPhat() {
        return hinhPhat;
    }

    public void setHinhPhat(String hinhPhat) {
        this.hinhPhat = hinhPhat;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaPM() {
        return maPM;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    @Override
    public String toString() {
        return "ViPham{" + "idVP=" + idVP + ", ngayVP=" + ngayVP + ", hinhPhat=" + hinhPhat + ", moTa=" + moTa + ", maPM=" + maPM + '}';
    }

    

    
}

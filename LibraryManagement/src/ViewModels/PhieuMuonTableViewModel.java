/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PhieuMuonTableViewModel {
    private String maDocGia;
    private String tenDocGia;
    private String maPhieuMuon;
    private String ngayViet;
    private String ngayTra;
    private Integer tinhTrang;

    public PhieuMuonTableViewModel() {
    }

    public PhieuMuonTableViewModel(String maDocGia, String tenDocGia, String maPhieuMuon, String ngayViet, String ngayTra, Integer tinhTrang) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.maPhieuMuon = maPhieuMuon;
        this.ngayViet = ngayViet;
        this.ngayTra = ngayTra;
        this.tinhTrang = tinhTrang;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getNgayViet() {
        return ngayViet;
    }

    public void setNgayViet(String ngayViet) {
        this.ngayViet = ngayViet;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}

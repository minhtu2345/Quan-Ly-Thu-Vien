/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuNhapViewmodel {

    private String idPhieuNhap;
    private String maSach;
    private String tenSach;
    private String img;
    private List<String> tacGia;
    private Integer soLuong;
    private String nhaXuatBan;
    private List<String> theLoai;
    private Integer nxb;
    private Date ngayNhap;
    private BigDecimal giaNhap;
    private String nhaCC;
    private String seri;

    public PhieuNhapViewmodel() {
    }

    public PhieuNhapViewmodel(String idPhieuNhap, String maSach, String tenSach, String img, List<String> tacGia, Integer soLuong, String nhaXuatBan, List<String> theLoai, Integer nxb, Date ngayNhap, BigDecimal giaNhap, String nhaCC, String seri) {
        this.idPhieuNhap = idPhieuNhap;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.img = img;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
        this.theLoai = theLoai;
        this.nxb = nxb;
        this.ngayNhap = ngayNhap;
        this.giaNhap = giaNhap;
        this.nhaCC = nhaCC;
        this.seri = seri;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }
    
    

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(String idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<String> getTacGia() {
        return tacGia;
    }

    public void setTacGia(List<String> tacGia) {
        this.tacGia = tacGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public List<String> getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(List<String> theLoai) {
        this.theLoai = theLoai;
    }

    public Integer getNxb() {
        return nxb;
    }

    public void setNxb(Integer nxb) {
        this.nxb = nxb;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getNhaCC() {
        return nhaCC;
    }

    public void setNhaCC(String nhaCC) {
        this.nhaCC = nhaCC;
    }

    
}

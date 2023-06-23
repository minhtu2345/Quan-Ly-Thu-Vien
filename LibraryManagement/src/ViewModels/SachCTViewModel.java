/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author huong
 */
public class SachCTViewModel {

    private String maSach;
    private String tenSach;
    private String img;
    private List<String> tacGia;
    private Integer soLuong;
    private String nhaXuatBan;
    private List<String> theLoai;
    private Integer nxb;
    private BigDecimal giaNhap;

    public SachCTViewModel() {
    }

    public SachCTViewModel(String maSach, String tenSach, String img, List<String> tacGia, Integer soLuong, String nhaXuatBan, List<String> theLoai, Integer nxb, BigDecimal giaNhap) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.img = img;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
        this.theLoai = theLoai;
        this.nxb = nxb;
        this.giaNhap = giaNhap;
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

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }
    
    
}

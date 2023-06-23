/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Apc
 */
public class PhieuNhap {
    private String id;
    private String idSachCT;
    private String ma;
    private Date ngay;
    private Boolean tinhtrang;
    private Integer sl;
    private BigDecimal giaNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(String id, String ma, String idSachCT, Date ngay, Boolean tinhtrang, Integer sl, BigDecimal giaNhap) {
        this.id = id;
        this.ma = ma;
        this.idSachCT = idSachCT;
        this.ngay = ngay;
        this.tinhtrang = tinhtrang;
        this.sl = sl;
        this.giaNhap = giaNhap;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getIdSachCT() {
        return idSachCT;
    }

    public void setIdSachCT(String idSachCT) {
        this.idSachCT = idSachCT;
    }

    
}

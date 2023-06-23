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
public class PhieuMuon {
    private String id;
    private String ma;
    private Date ngaymuon;
    private Date ngayTra;
    private DocGia docGia;
    private Integer tinhTrang;

    public PhieuMuon(String id, String ma, Date ngaymuon, Date ngayTra, Integer tinhTrang, DocGia docGia) {
        this.id = id;
        this.ma = ma;
        this.ngaymuon = ngaymuon;
        this.ngayTra = ngayTra;
        this.docGia = docGia;
        this.tinhTrang = tinhTrang;
    }


    public PhieuMuon() {
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

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public DocGia getDocGia() {
        return docGia;
    }

    public void setDocGia(DocGia docGia) {
        this.docGia = docGia;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
    
}

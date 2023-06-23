/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Admin
 */
public class CuonSach {
    private String id;
    private Integer ma;
    private SachCT sachct;
    private Float tinhTrang;
    private Boolean TrangThai;

    public CuonSach() {
    }

    public CuonSach(String id, int ma, SachCT sachct, float tinhTrang, boolean TrangThai) {
        this.id = id;
        this.ma = ma;
        this.sachct = sachct;
        this.tinhTrang = tinhTrang;
        this.TrangThai = TrangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public SachCT getSachct() {
        return sachct;
    }

    public void setSachct(SachCT sachct) {
        this.sachct = sachct;
    }

    public Float getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Float tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    
}

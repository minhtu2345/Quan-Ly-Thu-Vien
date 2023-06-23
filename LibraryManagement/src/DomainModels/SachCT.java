/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author Apc
 */
public class SachCT {
    private String id;
    private Integer namxb;
    private String img;
    private BigDecimal giaIn;
    private String seri;
    private Sach sach;

    public SachCT() {
    }

    public SachCT(String id, Integer namxb, String img, BigDecimal giaIn, String seri, Sach sach) {
        this.id = id;
        this.namxb = namxb;
        this.img = img;
        this.giaIn = giaIn;
        this.seri = seri;
        this.sach = sach;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNamxb() {
        return namxb;
    }

    public void setNamxb(Integer namxb) {
        this.namxb = namxb;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getGiaIn() {
        return giaIn;
    }

    public void setGiaIn(BigDecimal giaIn) {
        this.giaIn = giaIn;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

}

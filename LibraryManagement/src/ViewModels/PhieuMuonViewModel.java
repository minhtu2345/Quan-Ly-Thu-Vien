/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.CuonSach;
import DomainModels.DocGia;
import DomainModels.PhieuMuon;
import DomainModels.Sach;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuMuonViewModel {
    private PhieuMuon pm;
    private List<Sach> sach;
    private List<CuonSach> cuonSach;
    private DocGia docGia;

    public PhieuMuonViewModel() {
    }

    public PhieuMuonViewModel(PhieuMuon pm, List<Sach> sach, List<CuonSach> cuonSach, DocGia docGia) {
        this.pm = pm;
        this.sach = sach;
        this.cuonSach = cuonSach;
        this.docGia = docGia;
    }

    public PhieuMuon getPm() {
        return pm;
    }

    public void setPm(PhieuMuon pm) {
        this.pm = pm;
    }

    public List<Sach> getSach() {
        return sach;
    }

    public void setSach(List<Sach> sach) {
        this.sach = sach;
    }

    public List<CuonSach> getCuonSach() {
        return cuonSach;
    }

    public void setCuonSach(List<CuonSach> cuonSach) {
        this.cuonSach = cuonSach;
    }

    public DocGia getDocGia() {
        return docGia;
    }

    public void setDocGia(DocGia docGia) {
        this.docGia = docGia;
    }
    
    
}

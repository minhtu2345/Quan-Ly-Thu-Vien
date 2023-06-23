/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author huong
 */
public class NXBCT {
    private NhaXuatBan nxb;
    private Sach sach;

    public NXBCT() {
    }

    
    
    public NXBCT(NhaXuatBan nxb, Sach sach) {
        this.nxb = nxb;
        this.sach = sach;
    }

    public NhaXuatBan getNxb() {
        return nxb;
    }

    public void setNxb(NhaXuatBan nxb) {
        this.nxb = nxb;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }
    
    
}

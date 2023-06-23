/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author huong
 */
public class TacGiaCT {

    private TacGia tacgia;
    private Sach sach;

    public TacGiaCT() {
    }

    public TacGiaCT(TacGia tacgia, Sach sach) {
        this.tacgia = tacgia;
        this.sach = sach;
    }

    public TacGia getTacgia() {
        return tacgia;
    }

    public void setTacgia(TacGia tacgia) {
        this.tacgia = tacgia;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.DocGia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IDocGiaRepository {
    public DocGia insert(DocGia docgia);
    public DocGia delete(String ma);
    public DocGia update(DocGia docgia);
    public List<DocGia> getAll();
    public DocGia getByMa(String ma);
    public DocGia getByID(String ID);
    public List<DocGia> getBySearch(String tuKhoa);
}

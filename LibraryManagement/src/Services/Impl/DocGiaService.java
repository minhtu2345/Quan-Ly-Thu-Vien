/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.DocGia;
import Repositories.Impl.DocGiaRepository;
import Services.IDocGiaService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DocGiaService implements IDocGiaService{
    final DocGiaRepository repo;

    public DocGiaService() {
        this.repo = new DocGiaRepository();
    }
    
    
    @Override
    public DocGia insert(DocGia docGia) {
        return repo.insert(docGia);
    }

    @Override
    public DocGia delete(String ma) {
        return repo.delete(ma);
    }

    @Override
    public DocGia update(DocGia docgia) {
        return repo.update(docgia);
    }

    @Override
    public List<DocGia> getAll() {
        return repo.getAll();
    }

    @Override
    public DocGia getByMa(String ma) {
        return repo.getByMa(ma);
    }

    @Override
    public List<DocGia> getBySearch(String tuKhoa) {
        return repo.getBySearch(tuKhoa);
    }

    @Override
    public DocGia getByID(String ID) {
        return repo.getByID(ID);
    }
    
}

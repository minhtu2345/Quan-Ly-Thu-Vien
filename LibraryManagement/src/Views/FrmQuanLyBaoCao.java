/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.LoiVP;
import DomainModels.ViPham;
import Services.BaoCaoServices;
import Services.Impl.BaoCaoServicesImpl;
import Services.Impl.ViPhamService;
import Utilities.SetSize;
import ViewModels.BaoCaoDSViewModels;
import ViewModels.BaoCaoPMViewModels;
import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class FrmQuanLyBaoCao extends javax.swing.JPanel {

    final SetSize setsize = new SetSize();
    final  private BaoCaoServices baoCaoServices = new BaoCaoServicesImpl();
    final private  ViPhamService ViPhamService = new ViPhamService();

    /**
     * Creates new form FrmQuanLyBaoCao
     */
    public FrmQuanLyBaoCao() {
        initComponents();
        this.setTable();
        this.seticon();
        this.loadtable();
        this.loadListLoi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        _lstLoi = new javax.swing.JPanel();
        txtTenLoi = new javax.swing.JTextField();
        btnThemLoi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBaoCao = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        btnXoaLoi = new javax.swing.JButton();
        btnSuaLoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnThemBC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaPM = new javax.swing.JTextField();
        btnXem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTenDG = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNgayMuon = new javax.swing.JLabel();
        cbxSach = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        lblNgayViet = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHinhPhat = new javax.swing.JTextField();
        btnSuabc = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(125, 180, 125));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(125, 200, 150));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(780, 450));

        _lstLoi.setBackground(new java.awt.Color(255, 255, 255));
        _lstLoi.setAutoscrolls(true);
        _lstLoi.setMaximumSize(new java.awt.Dimension(300, 518));
        _lstLoi.setPreferredSize(new java.awt.Dimension(300, 518));
        _lstLoi.setRequestFocusEnabled(false);
        _lstLoi.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        jScrollPane1.setViewportView(_lstLoi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 74, 300, 200));
        jPanel1.add(txtTenLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, -1));

        btnThemLoi.setBackground(new java.awt.Color(125, 200, 150));
        btnThemLoi.setText("Lỗi mới");
        btnThemLoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemLoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnThemLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 78, -1));

        jScrollPane3.setBackground(new java.awt.Color(125, 180, 125));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách báo cáo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tblBaoCao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblBaoCao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phiếu mượn", "Mã độc giả", "Ngày viết"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBaoCao.setGridColor(new java.awt.Color(125, 180, 125));
        tblBaoCao.setSelectionBackground(new java.awt.Color(125, 200, 150));
        tblBaoCao.setShowGrid(false);
        tblBaoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBaoCaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBaoCao);
        if (tblBaoCao.getColumnModel().getColumnCount() > 0) {
            tblBaoCao.getColumnModel().getColumn(0).setResizable(false);
            tblBaoCao.getColumnModel().getColumn(1).setResizable(false);
            tblBaoCao.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 322, 290, 210));
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 170, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mã độc giả");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));

        btnSearch.setPreferredSize(new java.awt.Dimension(20, 20));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        btnXoaLoi.setBackground(new java.awt.Color(125, 200, 150));
        btnXoaLoi.setText("Xóa lỗi");
        btnXoaLoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        btnSuaLoi.setBackground(new java.awt.Color(125, 200, 150));
        btnSuaLoi.setText("Sửa  lỗi");
        btnSuaLoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuaLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 80, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Báo cáo lỗi");

        btnThemBC.setBackground(new java.awt.Color(125, 200, 150));
        btnThemBC.setText("Thêm báo cáo");
        btnThemBC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBCActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã phiếu mượn:");

        btnXem.setBackground(new java.awt.Color(125, 200, 150));
        btnXem.setText("Xem");
        btnXem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Phiếu mượn");

        jLabel4.setText("Độc giả:");

        jLabel5.setText("Sách:");

        lblTenDG.setText("Nguyễn Công Thuần");

        jLabel8.setText("Ngày mượn:");

        lblNgayMuon.setText("20/10/2022, 16:55");

        cbxSach.setBackground(new java.awt.Color(125, 200, 150));
        cbxSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sách 1", "sách 2" }));
        cbxSach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(111, 111, 111))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSach, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTenDG))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel7.setText("Mô tả:");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel10.setText("Ngày viết:");

        lblNgayViet.setText("30/10/2022, 16:55");

        jLabel13.setText("Hình phạt");

        btnSuabc.setBackground(new java.awt.Color(125, 200, 150));
        btnSuabc.setText("Sửa báo cáo");
        btnSuabc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuabc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuabcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHinhPhat))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNgayViet, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtMaPM, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnXem))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(45, 45, 45))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnThemBC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuabc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtHinhPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayViet)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemBC)
                    .addComponent(btnSuabc))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemLoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoiActionPerformed
        // TODO add your handling code here:
        ViPhamService.Them(new LoiVP(null, txtTenLoi.getText()));
        JOptionPane.showMessageDialog(this, "Them thành công!");
        this.loadListLoi();
    }//GEN-LAST:event_btnThemLoiActionPerformed
    public ViPham GetText() {
        ViPham vp = new ViPham();
        vp.setMaPM(txtMaPM.getText());
        vp.setMoTa(txtMoTa.getText());
        vp.setHinhPhat(txtHinhPhat.getText());
        // vp.setNgayVP(lblNgayViet.getDate());
        //lblNgayViet.setText(date + "");
        return vp;

    }

    private void loadListLoi(){
        _lstLoi.removeAll();
        List<LoiVP> _lst = ViPhamService.getAll();
        for (LoiVP loiVP : _lst) {
            FrmLoiKhung loi = new FrmLoiKhung();
            loi.setTen(loiVP.getTen());
            _lstLoi.add(loi);
        }
        _lstLoi.revalidate();
        _lstLoi.repaint();
    }
    //Load dữ liệu lên khung phiếu mượn
    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        setPMView();
    }//GEN-LAST:event_btnXemActionPerformed

    public void clearForm() {
        txtMaPM.setText("");
        txtHinhPhat.setText("");
        txtMoTa.setText("");
        //txtNV.setDateFormatString("");
        lblNgayViet.setText("");
        cbxSach.setSelectedItem("");
        lblTenDG.setText("");
        lblNgayMuon.setText("");
        txtTimKiem.setText("");
    }
    private void btnThemBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBCActionPerformed
        ViPham vp = GetText();
        ViPham addnewest = baoCaoServices.Them(vp);
        for (FrmLoiKhung frmLoiKhung : getLoiKhungSelected()) {
            LoiVP loiVP = ViPhamService.getByTen(frmLoiKhung.getTen());
            baoCaoServices.insertLoiVpCT(addnewest.getIdVP(), loiVP.getId());
        }
        loadtable();
        clearForm();
    }//GEN-LAST:event_btnThemBCActionPerformed

    private void setPMView() {
        String ma = txtMaPM.getText();
        BaoCaoPMViewModels baoCaoPMViewModels = baoCaoServices.getPhieuMuonByMa(ma).get(0);
        lblTenDG.setText(baoCaoPMViewModels.getTenDG());
        //cbxSach.addItem(baoCaoPMViewModels.getTenSach());
        this.fillcbc();
        lblNgayMuon.setText(baoCaoPMViewModels.getNgayMuon() + "");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        lblNgayViet.setText(date + "");
    }
    private void tblBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBaoCaoMouseClicked
        // TODO add your handling code here:
        int row = tblBaoCao.getSelectedRow();
        String ma = (String) tblBaoCao.getValueAt(row, 0);
        List<ViPham> dsviViPhams = baoCaoServices.LoadtableViPhams(ma);
        //System.out.println(dsviViPhams.size());
        ViPham vp = dsviViPhams.get(0);
        txtMaPM.setText(vp.getMaPM());
        txtMoTa.setText(vp.getMoTa());
        txtHinhPhat.setText(vp.getHinhPhat());
        lblNgayViet.setText(vp.getNgayVP() + "");
        this.setPMView();

    }//GEN-LAST:event_tblBaoCaoMouseClicked

    private void btnSuabcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuabcActionPerformed
        ViPham vp = GetText();
        String ma = txtMaPM.getText();
        baoCaoServices.Sua(ma, vp);
        loadtable();
        clearForm();
    }//GEN-LAST:event_btnSuabcActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
//        List<BaoCaoDSViewModels> vp = timBaoCaoDSViewModelses;
        loadtableByMaDG(txtTimKiem.getText());

//        System.out.println(vp);
//        clearForm();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnXoaLoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoiActionPerformed
        // TODO add your handling code here:
        for (FrmLoiKhung frmLoiKhung : getLoiKhungSelected()) {
            LoiVP loi = ViPhamService.getByTen(frmLoiKhung.getTen());
            ViPhamService.Xoa(loi.getId());
        }
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        this.loadListLoi();
    }//GEN-LAST:event_btnXoaLoiActionPerformed

    private List<FrmLoiKhung> getLoiKhung(){
        _lstLoi.revalidate();
        _lstLoi.repaint();
        List<FrmLoiKhung> _lst = new ArrayList<>();
        for (int i = 0; i < _lstLoi.getComponentCount(); i++) {
            _lst.add((FrmLoiKhung) _lstLoi.getComponent(i));
        }
        return _lst;
    }
    
    private List<FrmLoiKhung> getLoiKhungSelected(){
        List<FrmLoiKhung> _lst = new ArrayList<>();
        for (FrmLoiKhung frmLoiKhung : getLoiKhung()) {
            if(frmLoiKhung.check()){
                _lst.add(frmLoiKhung);
            }
        }
        return _lst;
    }
    private void btnSuaLoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoiActionPerformed
        // TODO add your handling code here:
        List<FrmLoiKhung> _lst = getLoiKhung();
        if(_lst.size()>1){
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ sửa một lỗi!");
            return;
        }
        String loiSua = txtTenLoi.getText();
        LoiVP loiVP = ViPhamService.getByTen(_lst.get(0).getTen());
        ViPhamService.Sua(loiSua, loiVP);
        JOptionPane.showMessageDialog(this, "Sửa thành công!");
    }//GEN-LAST:event_btnSuaLoiActionPerformed

    // hàm load cbx 
    private void fillcbc() {
        cbxSach.removeAllItems();
        for (BaoCaoPMViewModels baoCaoPMViewModels : baoCaoServices.getPhieuMuonByMa(txtMaPM.getText())) {
            cbxSach.addItem(baoCaoPMViewModels.getTenSach());
        }
    }

    // load table danh sách báo cáo 
    void loadtable() {
        List<BaoCaoDSViewModels> dsbaoCaoViewModels = baoCaoServices.LoadTableBaoCao();
        DefaultTableModel _DefaultTableModel = (DefaultTableModel) tblBaoCao.getModel();
        _DefaultTableModel.setRowCount(0);
        dsbaoCaoViewModels.forEach(Item -> {
            _DefaultTableModel.addRow(new Object[]{
                Item.getMaPM(), Item.getMaDG(),
                Item.getNgayViet()
            });
        });
        //tblBaoCao.setModel(_DefaultTableModel);
    }

    void loadtableByMaDG(String ma) {
//        List<BaoCaoDSViewModels> dsbaoCaoViewModels = baoCaoServices.LoadTableBaoCao();
        DefaultTableModel _DefaultTableModel = (DefaultTableModel) tblBaoCao.getModel();
        _DefaultTableModel.setRowCount(0);
        baoCaoServices.getByMaDG(ma).forEach(Item -> {
            _DefaultTableModel.addRow(new Object[]{
                Item.getMaPM(), Item.getMaDG(),
                Item.getNgayViet()
            });
        });
        //tblBaoCao.setModel(_DefaultTableModel);
    }

    private void setTable() {
        JTableHeader header = tblBaoCao.getTableHeader();
        header.setBackground(new Color(125, 200, 150));
    }

    private void seticon() {
        URL urlSearch = getClass().getResource("/Images/search.png");
        btnSearch.setIcon(setsize.setSizeAnh(urlSearch, 20, 20));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel _lstLoi;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JButton btnSuaLoi;
    private javax.swing.JButton btnSuabc;
    private javax.swing.JButton btnThemBC;
    private javax.swing.JButton btnThemLoi;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoaLoi;
    private javax.swing.JComboBox<String> cbxSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNgayMuon;
    private javax.swing.JLabel lblNgayViet;
    private javax.swing.JLabel lblTenDG;
    private javax.swing.JTable tblBaoCao;
    private javax.swing.JTextField txtHinhPhat;
    private javax.swing.JTextField txtMaPM;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenLoi;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

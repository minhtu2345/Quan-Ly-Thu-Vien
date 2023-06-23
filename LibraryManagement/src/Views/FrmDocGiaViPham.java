/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import ViewModels.DocGiaViPhamViewModel;
import java.net.URL;
import javax.swing.ImageIcon;


/**
 *
 * @author Admin
 */
public class FrmDocGiaViPham extends javax.swing.JPanel {

    /**
     * Creates new form FrmDocGiaViPham
     */
    public FrmDocGiaViPham() {
        initComponents();
        taaMoTa.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        img_docGia = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        btnGiaiQuyet = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHinhPhat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taaMoTa = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxListLoi = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(176, 212, 184));
        jPanel1.setMinimumSize(new java.awt.Dimension(350, 110));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 232));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout img_docGiaLayout = new javax.swing.GroupLayout(img_docGia);
        img_docGia.setLayout(img_docGiaLayout);
        img_docGiaLayout.setHorizontalGroup(
            img_docGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        img_docGiaLayout.setVerticalGroup(
            img_docGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        );

        jPanel1.add(img_docGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        lblTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTen.setText("Nguyễn Công Thuần");
        jPanel1.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btnGiaiQuyet.setBackground(new java.awt.Color(234, 231, 214));
        btnGiaiQuyet.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        btnGiaiQuyet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGiaiQuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGiaiQuyetMouseClicked(evt);
            }
        });

        jLabel6.setText("Giải quyết");
        btnGiaiQuyet.add(jLabel6);

        jPanel1.add(btnGiaiQuyet, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 100, -1));

        jLabel2.setText("Mô tả");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 50, -1));

        jLabel4.setText("Hình phạt");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        lblHinhPhat.setText("jLabel5");
        jPanel1.add(lblHinhPhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 170, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        taaMoTa.setColumns(20);
        taaMoTa.setRows(5);
        jScrollPane1.setViewportView(taaMoTa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 56, 170, 70));

        jLabel3.setText("ID Vi pham");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        lblID.setText("jLabel7");
        jPanel1.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, -1));

        jLabel1.setText("Lỗi vi phạm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 80, -1));

        cbxListLoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxListLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGiaiQuyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGiaiQuyetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGiaiQuyetMouseClicked

    public void setDisplay(DocGiaViPhamViewModel docgia){
        lblID.setText(docgia.getId());
        lblTen.setText(docgia.getTenDocGia());
        taaMoTa.setText(docgia.getMoTa());
        ImageIcon imgSet = new ImageIcon(docgia.getImg());
        img.setIcon(imgSet);
        lblHinhPhat.setText(docgia.getHinhPhat());
        cbxListLoi.removeAllItems();
        for (String string : docgia.getLstLoi()) {
            cbxListLoi.addItem(string);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnGiaiQuyet;
    private javax.swing.JComboBox<String> cbxListLoi;
    private javax.swing.JLabel img;
    private javax.swing.JPanel img_docGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhPhat;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTen;
    private javax.swing.JTextArea taaMoTa;
    // End of variables declaration//GEN-END:variables
}

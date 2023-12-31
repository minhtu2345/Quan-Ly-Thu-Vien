/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.CuonSach;
import DomainModels.Sach;
import DomainModels.SachCT;
import Services.Impl.SachCTService;
import Utilities.ScanBarcode;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class FrmScanBC extends javax.swing.JFrame implements Runnable, ThreadFactory{
        private Executor executor = Executors.newSingleThreadScheduledExecutor((ThreadFactory) this);
        final SachCTService SERVICE_SACHCT = new SachCTService();
        final ScanBarcode scan = new ScanBarcode();
        public static int where = -1;
        public static String SERI = "";
    /**
     * Creates new form FrmScanBC
     */
    public FrmScanBC() {
        this.setUndecorated(true);
        initComponents();
        scan.initWebCam(pnScan, executor, this);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        pnScan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnLaySeri = new javax.swing.JButton();
        lblBarcode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnScan.setBackground(new java.awt.Color(255, 255, 255));
        pnScan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnScan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 310));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Barcode");

        btnLaySeri.setText("Lấy seri");
        btnLaySeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaySeriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(lblBarcode))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(btnLaySeri)
                .addGap(232, 232, 232))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLaySeri)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 550, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaySeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaySeriActionPerformed
        // TODO add your handling code here:
        ScanBarcode.webcam.close();
            switch (where) {
                case 0 -> FrmPhieuNhap.lblSeri.setText(lblBarcode.getText());
                case 1 -> {
                    CuonSach cs = FrmQuanLyMuonTra.SERVICE_CS.getByID(lblBarcode.getText()).get(0);
                    Sach sach = FrmQuanLyMuonTra.SERVICE_SACH.getByID(cs.getSachct().getSach().getId());
                    FrmQuanLyMuonTra.setSoQuyen(sach, cs);
                }
                case 2 -> {
                    FrmQuanLyKhoSach frm = new FrmQuanLyKhoSach();
                    String seri = lblBarcode.getText();
                    SachCT sachct = SERVICE_SACHCT.getByBarcode(seri);
                    frm.setViewSach(sachct.getSach().getMa());
                    JPanel panel = FrmQuanLyKhoSach.pnSachView;
                    FrmPhieuNhap frmPN = new FrmPhieuNhap();
                    frmPN.setSachDaCo(panel);
                    frmPN.setVisible(true);
                    SERI = seri;
                }
            }
        this.dispose();
    }//GEN-LAST:event_btnLaySeriActionPerformed

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (ScanBarcode.webcam.isOpen()) {
                if ((image = ScanBarcode.webcam.getImage()) == null) {
                    continue;
                }
            }
            
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }
            if (result != null) {
                String seri = result.getText();
                lblBarcode.setText(seri);
            }
        } while (true);
    }


    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My thread");
        t.setDaemon(true);
        return t;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnLaySeri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField lblBarcode;
    private javax.swing.JPanel pnScan;
    // End of variables declaration//GEN-END:variables
}

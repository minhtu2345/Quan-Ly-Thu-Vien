/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.CuonSach;
import DomainModels.NhaXuatBan;
import DomainModels.PhieuNhap;
import DomainModels.Sach;
import DomainModels.SachCT;
import DomainModels.TacGia;
import DomainModels.TheLoaiSach;
import Services.Impl.CuonSachService;
import Services.Impl.KhoSachServices;
import Services.Impl.NhaCCService;
import Services.Impl.NhaXuatBanService;
import Services.Impl.PhieuNhapService;
import Services.Impl.PhieuNhapViewModelService;
import Services.Impl.SachCTService;
import Services.Impl.SachService;
import Services.Impl.TacGiaService;
import Services.Impl.TheLoaiService;
import Services.KhoSachService;
import Utilities.SetSize;
import ViewModels.SachCTViewModel;
import static Views.FrmPhieuNhap.icon;
import static Views.FrmPhieuNhap.suaAnh;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmSach extends javax.swing.JFrame {

    final SetSize setsize = new SetSize();
    private KhoSachService ksSV = new KhoSachServices();
    final PhieuNhapService SERVICE = new PhieuNhapService();
    final SachService SERVICE_SACH = new SachService();
    final SachCTService SERVICE_SACHCT = new SachCTService();
    final TheLoaiService SERVICE_TLS = new TheLoaiService();
    final TacGiaService SERVICE_TG = new TacGiaService();
    final NhaXuatBanService SERVICE_NXB = new NhaXuatBanService();
    final static NhaCCService SERVICE_NCC = new NhaCCService();
    final static PhieuNhapService SERVICE_PN = new PhieuNhapService();
    final PhieuNhapViewModelService SERVICE_VIEW = new PhieuNhapViewModelService();
    final static CuonSachService SERVICE_CS = new CuonSachService();
    private Set<Integer> _lstTblSelected = new HashSet<>() ;
    public static  List<TacGia> _lstTacGia = new ArrayList<>();
    public  List<Integer> _lstThayThe = new ArrayList<>();
    public static Sach sach;
    public static SachCT sachCT;
    /**
     * Creates new form FrmSach
     */
    public FrmSach() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.seticon();
        fillCBBNXB();
        fillChkTL();
        FrmQuanLyKhoSach.setTable(tblSachTrongKho);
    }

    public void setDisplay(SachCTViewModel sct) {
        lblMaSach.setText(sct.getMaSach());
        txtTenSach.setText(sct.getTenSach());
        String hoten = "";
        for (String string : sct.getTacGia()) {
            hoten += string + "-";
        }
        for (String string : sct.getTheLoai()) {
            for (int j = 0; j < boxTheLoai.getComponentCount(); j++) {
                JCheckBox chk = (JCheckBox) boxTheLoai.getComponent(j);
                if (chk.getText().equals(string)) {
                    chk.setSelected(true);
                }
            }
        }
        cbxNhaXuatBan.setSelectedItem(sct.getNhaXuatBan());
        hoten = hoten.substring(0, hoten.length() - 1);
        lblTacGia.setText(hoten);
        txtSoLuongNhap.setText(String.valueOf(sct.getSoLuong()));
        txtDonGia.setText(String.valueOf(sct.getGiaNhap()));
        txtNamXuatBan.setText(String.valueOf(sct.getNxb()));
        URL url = getClass().getResource(sct.getImg());
        lblAnh.setIcon(setsize.setSizeAnh(url, 116, 159));
        SachCT SachCT = SERVICE_SACHCT.getByIDSach(SERVICE_SACH.getByMa(lblMaSach.getText()).getId());
        lblSeri.setText(SachCT.getSeri());
        this.loadTable(SERVICE_CS.getByIDSachCT(SachCT.getId()));
        sach = SERVICE_SACH.getByMa(lblMaSach.getText());
        sachCT = SERVICE_SACHCT.getByIDSach(sach.getId());
    }

    public static void fillCBBNXB() {
        NhaXuatBanService nxb = new NhaXuatBanService();
        List<NhaXuatBan> list = nxb.getAll();
        cbxNhaXuatBan.removeAllItems();
        for (NhaXuatBan nhaXuatBan : list) {
            cbxNhaXuatBan.addItem(nhaXuatBan.getTen()+"-"+nhaXuatBan.getDiaChi());
        }
    }

    public static void fillChkTL() {
        TheLoaiService service = new TheLoaiService();
        List<TheLoaiSach> _lst = service.getAll();
        boxTheLoai.removeAll();
        for (TheLoaiSach theLoaiSach : _lst) {
            JCheckBox chk = new JCheckBox(theLoaiSach.getTen());
            chk.setBackground(Color.white);
            boxTheLoai.add(chk);
        }
    }
    public static void loadTable(List<CuonSach> _lst){
        DefaultTableModel model = (DefaultTableModel) tblSachTrongKho.getModel();
        model.setRowCount(0);
        for (CuonSach cuonSach : _lst) {
            Object rowData[] = {
                cuonSach.getMa()+"", cuonSach.getTinhTrang(), !cuonSach.getTrangThai()?"Đang được mượn":"Có sẵn"
            };
            model.addRow(rowData);
        }
        tblSachTrongKho.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        txtSoLuongNhap = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtNamXuatBan = new javax.swing.JTextField();
        btnHoanThanh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        imgSach = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        btnTaiAnh = new javax.swing.JButton();
        lblMaSach = new javax.swing.JLabel();
        cbxNhaXuatBan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        boxTheLoai = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        lblSeri = new javax.swing.JLabel();
        IconBarcode = new javax.swing.JLabel();
        btnTacGia = new javax.swing.JButton();
        lblTacGia = new javax.swing.JLabel();
        btnQLTT = new javax.swing.JButton();
        btnXoa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSachTrongKho = new javax.swing.JTable();
        cbxsapXepTrangThai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnThayThe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(590, 400));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Thông tin sách");

        jLabel7.setText("Mã sách");

        jLabel8.setText("Tên sách");

        jLabel9.setText("Tác giả");

        lblSoLuong.setText("Số lượng tồn");

        jLabel11.setText("Nhà xuất bản");

        jLabel12.setText("Thể loại");

        jLabel13.setText("Năm xuất bản");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        btnHoanThanh.setBackground(new java.awt.Color(125, 200, 150));
        btnHoanThanh.setText("Hoàn thành");
        btnHoanThanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        jLabel15.setText("Đơn giá");

        javax.swing.GroupLayout imgSachLayout = new javax.swing.GroupLayout(imgSach);
        imgSach.setLayout(imgSachLayout);
        imgSachLayout.setHorizontalGroup(
            imgSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        imgSachLayout.setVerticalGroup(
            imgSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );

        btnTaiAnh.setBackground(new java.awt.Color(125, 200, 150));
        btnTaiAnh.setText("Tải ảnh");
        btnTaiAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaiAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiAnhActionPerformed(evt);
            }
        });

        lblMaSach.setText("Is auto");

        cbxNhaXuatBan.setBackground(new java.awt.Color(125, 200, 150));
        cbxNhaXuatBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNhaXuatBan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        boxTheLoai.setBackground(new java.awt.Color(255, 255, 255));
        boxTheLoai.setMaximumSize(new java.awt.Dimension(185, 900));
        boxTheLoai.setMinimumSize(new java.awt.Dimension(185, 30));
        boxTheLoai.setPreferredSize(new java.awt.Dimension(185, 100));
        boxTheLoai.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Tâm lý");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        boxTheLoai.add(jCheckBox1);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Khoa học-viễn tưởng");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        boxTheLoai.add(jCheckBox2);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Tình cảm");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        boxTheLoai.add(jCheckBox3);

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Kinh doanh - kinh tế");
        boxTheLoai.add(jCheckBox4);

        jScrollPane1.setViewportView(boxTheLoai);

        lblSeri.setText("Is seri");

        IconBarcode.setText("jLabel17");
        IconBarcode.setPreferredSize(new java.awt.Dimension(24, 24));
        IconBarcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconBarcodeMouseClicked(evt);
            }
        });

        btnTacGia.setBackground(new java.awt.Color(125, 200, 150));
        btnTacGia.setText("Chọn");
        btnTacGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTacGiaActionPerformed(evt);
            }
        });

        lblTacGia.setText("-----");

        btnQLTT.setBackground(new java.awt.Color(125, 200, 150));
        btnQLTT.setText("Quản lý thông tin");
        btnQLTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLTTActionPerformed(evt);
            }
        });

        btnXoa.setText("jLabel3");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(20, 20));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(imgSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnTaiAnh)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IconBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnTacGia)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbxNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(lblMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnQLTT)))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(btnHoanThanh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblMaSach)
                            .addComponent(btnQLTT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(btnTacGia)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoLuong)
                            .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbxNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imgSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnTaiAnh)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IconBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHoanThanh)
                .addGap(59, 59, 59))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 400));

        btnClose.setText("a");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setPreferredSize(new java.awt.Dimension(20, 20));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SÁCH TRONG KHO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setAutoscrolls(true);

        tblSachTrongKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cuốn số", "Tình Trạng", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSachTrongKho.setGridColor(new java.awt.Color(255, 255, 255));
        tblSachTrongKho.setSelectionBackground(new java.awt.Color(125, 200, 150));
        tblSachTrongKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachTrongKhoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSachTrongKho);
        if (tblSachTrongKho.getColumnModel().getColumnCount() > 0) {
            tblSachTrongKho.getColumnModel().getColumn(0).setResizable(false);
            tblSachTrongKho.getColumnModel().getColumn(1).setResizable(false);
            tblSachTrongKho.getColumnModel().getColumn(2).setResizable(false);
        }

        cbxsapXepTrangThai.setBackground(new java.awt.Color(125, 200, 150));
        cbxsapXepTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<=100", "<=90", "<=70", "<=50", "<=30" }));
        cbxsapXepTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxsapXepTrangThaiItemStateChanged(evt);
            }
        });

        jLabel1.setText("Trạng thái");

        btnThayThe.setBackground(new java.awt.Color(125, 200, 150));
        btnThayThe.setText("Thay thế");
        btnThayThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayTheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxsapXepTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThayThe)
                        .addContainerGap(73, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxsapXepTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnThayThe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 330, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        Sach sachnew = SERVICE_SACH.getByMa(lblMaSach.getText());
        sachnew.setTen(txtTenSach.getText());
        SERVICE_SACH.update(sachnew);
        List<TheLoaiSach> _lstTLS = getListTheLoai();
        SERVICE_TLS.deleteTheLoaiCT(sachnew.getId());
        for (TheLoaiSach theLoaiSach : _lstTLS) {
            SERVICE_TLS.insertTLCT(sachnew.getId(), theLoaiSach.getId());
        }
        if(_lstTacGia!=null && !_lstTacGia.isEmpty()){
            SERVICE_TG.deleteTacGiaCT(sachnew);
            for (TacGia tacGia : _lstTacGia) {
                SERVICE_TG.insertTGCT( sachnew.getId(), tacGia.getId());
            }
        }
        SachCT sachctnew = SERVICE_SACHCT.getByIDSach(sachnew.getId());
        sachctnew.setNamxb(Integer.parseInt(txtNamXuatBan.getText()));
        sachctnew.setSeri(lblSeri.getText());
        SERVICE_SACHCT.update(sachctnew);
        if(suaAnh==1){
            sachctnew.setImg(icon);
        }
        String nxbData = (String) cbxNhaXuatBan.getSelectedItem();
        int indexNXB = nxbData.indexOf("-");
        String tenNXB = nxbData.substring(0, indexNXB);
        String diaChiNXB = nxbData.substring(indexNXB+1);
        NhaXuatBan nxb = SERVICE_NXB.getByNameNDiaChi(tenNXB, diaChiNXB);
        SERVICE_NXB.deleteNXBCT(sachctnew.getId());
        SERVICE_NXB.insertNXBCT(nxb.getId(), sachctnew.getId());
        List<CuonSach> _lstcs= SERVICE_CS.getByIDSachCT(sachctnew.getId());
        int sl = Integer.parseInt(txtSoLuongNhap.getText());
        if(sl<_lstcs.size()){
        List<CuonSach> _lstCSMuon = SERVICE_CS.getSachDuocMuon(sachCT.getId());
        if(!_lstCSMuon.isEmpty()){
            JOptionPane.showMessageDialog(this, "Cuốn sách đang được mượn!\n Không thể xóa!");
            return;
        }
            for (int i = sl; i < _lstcs.size(); i++) {
                SERVICE_CS.delete(SERVICE_CS.getByMaAndID(sachctnew.getId(), i+1+"").getId(), this);
            }
        }else if(sl>_lstcs.size()){
            JOptionPane.showMessageDialog(this, "Vui lòng viết phiếu nhập nếu muốn thêm số lượng!");
            return;
        }
        if(!_lstTblSelected.isEmpty()){
            for (Integer integer : _lstTblSelected) {
                CuonSach cs = SERVICE_CS.getByIDSachCT(sachctnew.getId()).get(0);
                Integer ma = Integer.parseInt((String) tblSachTrongKho.getValueAt(integer, 0));
                Float tinhTrang = Float.valueOf(tblSachTrongKho.getValueAt(integer, 1)+"");
                cs.setMa(ma);
                cs.setTinhTrang(tinhTrang);
                SERVICE_CS.update(cs);
            }
        }
        if(FrmSachCanThay.where==1){
            FrmSachCanThay frmSCThay = new FrmSachCanThay();
            frmSCThay.loadTable();
            FrmSachCanThay.where=0;
            frmSCThay.setVisible(true);
        }
        this.dispose();
        FrmChinh.setFrmChinh(new FrmQuanLyKhoSach());
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private List<TheLoaiSach> getListTheLoai(){
        List<JCheckBox> _lst = new ArrayList<>();
        List<TheLoaiSach> _lstTLS = new ArrayList<>();
        for (int j = 0; j < boxTheLoai.getComponentCount(); j++) {
            _lst.add((JCheckBox) boxTheLoai.getComponent(j));
        }
        for (JCheckBox jCheckBox : _lst) {
            if(jCheckBox.isSelected()){
                String ten = jCheckBox.getText();
                TheLoaiSach tls = SERVICE_TLS.getByName(ten);
                _lstTLS.add(tls);
            }
        }
        return _lstTLS;
    }
        
    private void IconBarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconBarcodeMouseClicked
        // TODO add your handling code here:
        FrmScanBC.where=0;
        FrmScanBC scan = new FrmScanBC();
        scan.setVisible(true);
    }//GEN-LAST:event_IconBarcodeMouseClicked

    private void tblSachTrongKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachTrongKhoMouseClicked
        // TODO add your handling code here:
        _lstThayThe = new ArrayList<>();
        int row = tblSachTrongKho.getSelectedRow();
        int[] rows = tblSachTrongKho.getSelectedRows();
        for (int s : rows) {
            _lstThayThe.add(s);
        }
        if(row+1>Integer.parseInt(txtSoLuongNhap.getText())){
            JOptionPane.showMessageDialog(this, "Cuốn sách không còn tồn tại do đã sửa số lượng");
            return;
        }
        _lstTblSelected.add(row);
    }//GEN-LAST:event_tblSachTrongKhoMouseClicked

    private void btnTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTacGiaActionPerformed
        // TODO add your handling code here:
        new FrmChonTacGia().setVisible(true);
    }//GEN-LAST:event_btnTacGiaActionPerformed

    private void btnTaiAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiAnhActionPerformed
        // TODO add your handling code here:
        suaAnh=1;
        JFileChooser choose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        choose.showDialog(this, "Confirm");
        File file = choose.getSelectedFile();
        icon = file.getAbsolutePath();
        int index = icon.lastIndexOf("\\");
        icon ="/Images/imgSach/"+ icon.substring(index+1);
        URL img = getClass().getResource(icon);
        lblAnh.setIcon(setsize.setSizeAnh(img, 133, 162));
    }//GEN-LAST:event_btnTaiAnhActionPerformed

    private void btnQLTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLTTActionPerformed
        // TODO add your handling code here:
        new FrmQuanLyTTSachNhap().setVisible(true);
    }//GEN-LAST:event_btnQLTTActionPerformed

    private void cbxsapXepTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxsapXepTrangThaiItemStateChanged
        // TODO add your handling code here:
        String select = (String) cbxsapXepTrangThai.getSelectedItem();
        select = select.substring(2);
        SachCT sachct = SERVICE_SACHCT.getByIDSach(sach.getId());
        this.loadTable(SERVICE_CS.getByTinhTrangNID(select, sachct.getId()));
    }//GEN-LAST:event_cbxsapXepTrangThaiItemStateChanged

    private void btnThayTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayTheActionPerformed
        // TODO add your handling code here:
        //Code chức năng thay thế cuốn sách
        int check =JOptionPane.showConfirmDialog(this, "Thay thế bằng phiếu nhập?");
        if(check==0){
            int countSL = _lstThayThe.size();
            if(countSL==0){
                new FrmKTThayThe().setVisible(true);
            }else{
                if(!FrmKTThayThe.check){
                    if(!_lstThayThe.isEmpty()){
                        for (Integer integer : _lstThayThe) {
                            CuonSach cs = SERVICE_CS.getByIDSachCT(sachCT.getId()).get(0);
                            Integer ma = Integer.parseInt((String) tblSachTrongKho.getValueAt(integer, 0));
                            String tt = tblSachTrongKho.getValueAt(integer, 1)+"";
                            Float tinhTrang = Float.valueOf(tt);
                            cs.setMa(ma);
                            if(tinhTrang>=70){
                                countSL--;
                            }else{
                                cs.setTinhTrang(100f);
                                SERVICE_CS.update(cs);
                            }
                        }
                        insertPN(countSL, this);
                        JOptionPane.showMessageDialog(this, "Đã thay thế những sách được chọn");
                    }
                    this.loadTable(SERVICE_CS.getByIDSachCT(sachCT.getId()));
                }
            }
        }
    }//GEN-LAST:event_btnThayTheActionPerformed

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Chắc chắn muốn xóa?");
        if(i==0){
            List<CuonSach> _lstCSMuon = SERVICE_CS.getSachDuocMuon(sachCT.getId());
            if(!_lstCSMuon.isEmpty()){
                JOptionPane.showMessageDialog(this, "Cuốn sách đang được mượn!\n Không thể xóa!");
                return;
            }
            List<CuonSach> _lstCS = SERVICE_CS.getByIDSachCT(sachCT.getId());
            for (CuonSach cuonSach : _lstCS) {
                SERVICE_CS.delete(cuonSach.getId(), this);
            }
            SERVICE_SACHCT.delete(sachCT);
            SERVICE_SACH.delete(sach, this);
            this.dispose();
            FrmChinh.setFrmChinh(new FrmQuanLyKhoSach());
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void seticon() {
        URL urldong = getClass().getResource("/Images/cross-small.png");
        URL urlBarcode = getClass().getResource("/Images/barcode-read.png");
        URL urlDelete = getClass().getResource("/Images/delete.png");
        IconBarcode.setIcon(setsize.setSizeAnh(urlBarcode, 24, 28));
        btnXoa.setIcon(setsize.setSizeAnh(urlDelete, 20, 20));
        btnClose.setIcon(setsize.setSizeAnh(urldong, 20, 20));
    }

    public static int thayTheAll50(int countSL, Component c){
        for (int i = 0; i < tblSachTrongKho.getRowCount(); i++) {
            CuonSach cs = SERVICE_CS.getByIDSachCT(sachCT.getId()).get(0);
            Integer ma = Integer.parseInt((String) tblSachTrongKho.getValueAt(i, 0));
            String tt = tblSachTrongKho.getValueAt(i, 1)+"";
            Float tinhTrang = Float.valueOf(tt);
            cs.setMa(ma);
            if(tinhTrang>50){
                countSL--;
            }else{
                cs.setTinhTrang(100f);
                SERVICE_CS.update(cs);
            }
        }
        insertPN(countSL, c);
        return countSL;
    }
    
    public static void insertPN(int countSL, Component c){
        if(countSL==0){
            JOptionPane.showMessageDialog(c, "Không có cuốn sách nào cần thay thế!");
            return;
        }
        FrmPhieuNhap frmPN = new FrmPhieuNhap();
        BigDecimal gia = BigDecimal.valueOf(Double.valueOf(txtDonGia.getText()));
        List<PhieuNhap> _lst = SERVICE_PN.getByidSachCT(sachCT.getId());
        PhieuNhap PN1 = _lst.get(0);
        PhieuNhap PN = new PhieuNhap(null, frmPN.roleMaPhieuNhap(), sachCT.getId(), frmPN.setNgayNhap(), true, countSL, gia);
        PN = SERVICE_PN.insert(PN);
        String idNCC = SERVICE_PN.getIDNCCBYIDpn(PN1.getId());
        SERVICE_PN.InsertNCCCT(PN.getId(), idNCC);
        
    }
    public void setEdit() {
        txtDonGia.setEditable(false);
        txtNamXuatBan.setEditable(false);
        txtSoLuongNhap.setEditable(false);
        cbxNhaXuatBan.setEditor(cbxNhaXuatBan.getEditor());
        txtTenSach.setEditable(false);
        jPanel3.remove(btnHoanThanh);
        jPanel3.remove(btnTaiAnh);
        jPanel3.remove(btnQLTT);
        jPanel3.remove(IconBarcode);
        jPanel3.remove(btnTacGia);
        tblSachTrongKho.setEnabled(false);
        jPanel3.revalidate();
        jPanel3.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconBarcode;
    public static javax.swing.JPanel boxTheLoai;
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnQLTT;
    private javax.swing.JButton btnTacGia;
    private javax.swing.JButton btnTaiAnh;
    private javax.swing.JButton btnThayThe;
    private javax.swing.JLabel btnXoa;
    public static javax.swing.JComboBox<String> cbxNhaXuatBan;
    private javax.swing.JComboBox<String> cbxsapXepTrangThai;
    private javax.swing.JPanel imgSach;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblMaSach;
    public static javax.swing.JLabel lblSeri;
    private javax.swing.JLabel lblSoLuong;
    public static javax.swing.JLabel lblTacGia;
    public static javax.swing.JTable tblSachTrongKho;
    public static javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}

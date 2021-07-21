/*h
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.HoaDon;
import OBJ.KhachHang;
import OBJ.SanPham;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Admin
 */
public class frmBanHang extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel ;
    ArrayList<HoaDon> listGioHang = new ArrayList<>();
    NumberFormat formatter = new DecimalFormat("###,###");
    KhachHang kh = new KhachHang() ;
    SanPham sp = new SanPham() ;
    int index ;
    
    /**
     * Creates new form frmBanHang
     */
    public frmBanHang() {

        
        initComponents();
//        frmKhachHang frmKH = new frmKhachHang() ;
//        frmKH.loadFile();
        getDataKH(loadKH()) ;
        getDataSP(loadSP()) ;
//        lbl_maNhanVien.setText(frmDangNhap.nameLogin);
        btn_thanhToan.setEnabled(false);
        jPanel1.setBackground(new Color(245,245,247,150));
        tbl_hoaDon.setBackground(new Color(245,245,247,150));
        tbl_sanPham.setBackground(new Color(245,245,247,150));
        btn_thanhToan.setBackground(new Color(245,245,247,150));
        btn_thoat.setBackground(new Color(245,245,247,150));

//        getDataNV(loadNV());
//        lbl_maNhanVien.setText(frmLogin.nameLogin) ;
//        btn_thanhToan.setEnabled(false) ;

    }
    public ArrayList<KhachHang> loadKH(){
        frmKhachHang frm_KH = new frmKhachHang() ;
        frm_KH.loadFile();
        return frm_KH.listKH ;
    }
    
    public ArrayList<SanPham> loadSP(){
        frmSanPham frm_SP = new frmSanPham() ;
        frm_SP.loadFile();
        return frm_SP.listSP ;
    }
    
    
    private void getDataSP(ArrayList<SanPham> ListSP){
        defaultTableModel = new DefaultTableModel() ;
        defaultTableModel.addColumn("Product ID");
        defaultTableModel.addColumn("Product Name");
        defaultTableModel.addColumn("Unit");
        defaultTableModel.addColumn("Producer");
        defaultTableModel.addColumn("Selling Price");
        defaultTableModel.addColumn("Entry Price");
//        defaultTableModel.addColumn("Nhóm");
        defaultTableModel.addColumn("Amount");

        for (SanPham obj : ListSP) {
            Vector vector = new Vector();
            vector.add(obj.getMaSanPham());
            vector.add(obj.getTenSP());
            vector.add(obj.getDonVi());
            vector.add(obj.getTenNSX());
            vector.add(obj.getGiaBan());
            vector.add(obj.getGiaNhap());
//            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
            vector.add(obj.getSoLuong());
            defaultTableModel.addRow(vector);
        }
        tbl_san_pham.setModel(defaultTableModel) ;
//        tbl_sanPham.setModel(defaultTableModel);
    
    }
    
    private void getDataKH(ArrayList<KhachHang> listKH) {
        
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Customer ID");
        defaultTableModel.addColumn("Customer Name");
        defaultTableModel.addColumn("Phone Number");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Address");
        defaultTableModel.addColumn("Sex");
        
//        defaultTableModel.addColumn("Nhóm");
        defaultTableModel.addColumn("Activity");

        for (KhachHang obj : listKH) {
            Vector vector = new Vector();
            vector.add(obj.getMaKhachHang());
            vector.add(obj.getHoTen());
            vector.add(obj.getSdt());
            vector.add(obj.getEmail());
            vector.add(obj.getDiaChi());
            vector.add(obj.getGioiTinh());
//            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
            vector.add(obj.getTrangThai() == 1 ? "Activity" : "Locked");
            defaultTableModel.addRow(vector);
        }
        tbl_khach_hang.setModel(defaultTableModel);
    }
    
//    private void getDataNV(ArrayList<NhanVien> listNV) {
//        
//        defaultTableModel = new DefaultTableModel();
//        defaultTableModel.addColumn("Mã NV");
//        defaultTableModel.addColumn("Họ tên NV");
//        defaultTableModel.addColumn("SĐT");
//        defaultTableModel.addColumn("Email");
//        defaultTableModel.addColumn("Mật Khẩu");
//        defaultTableModel.addColumn("Nhóm");
//        defaultTableModel.addColumn("Giới tính");
//        defaultTableModel.addColumn("Trạng Thái");
//
//        for (NhanVien obj : listNV) {
//            Vector vector = new Vector();
//            vector.add(obj.getMaNhanVien());
//            vector.add(obj.getHoTen());
//            vector.add(obj.getSoDienThoai());
//            vector.add(obj.getEmail());
//            vector.add(obj.getMatKhau());
//            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
//            vector.add(obj.getGioiTinh());
//            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
//            defaultTableModel.addRow(vector);
//        }
//        tbl_nhanVien1.setModel(defaultTableModel);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khach_hang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tbl_sanPham = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        btn_timKiem1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_san_pham = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_soLuongSP = new javax.swing.JTextField();
        btn_themSP = new javax.swing.JButton();
        tbl_hoaDon = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_gioHang = new javax.swing.JTable();
        btn_xoaGioHang = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_maKH = new javax.swing.JLabel();
        lbl_sdtKH = new javax.swing.JLabel();
        lbl_diaChiKH = new javax.swing.JLabel();
        lbl_tenKH = new javax.swing.JLabel();
        lbl_emailKH = new javax.swing.JLabel();
        lbl_tongTien = new javax.swing.JLabel();
        btn_thanhToan = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_maNhanVien = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 247));

        btn_timKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\magnifying-glass-icon.png")); // NOI18N
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        tbl_khach_hang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_khach_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khach_hangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khach_hang);

        jLabel1.setText("CUSTOMER");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_timKiem)
                .addGap(99, 99, 99))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(btn_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 73, 640, -1));

        tbl_sanPham.setBackground(new java.awt.Color(245, 245, 247));

        btn_timKiem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\magnifying-glass-icon.png")); // NOI18N
        btn_timKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiem1ActionPerformed(evt);
            }
        });

        jLabel2.setText("PRODUCT");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));

        tbl_san_pham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_san_pham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_san_phamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_san_pham);

        jLabel3.setText("Amount");

        btn_themSP.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Add.png")); // NOI18N
        btn_themSP.setText("Add to Cart");
        btn_themSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tbl_sanPhamLayout = new javax.swing.GroupLayout(tbl_sanPham);
        tbl_sanPham.setLayout(tbl_sanPhamLayout);
        tbl_sanPhamLayout.setHorizontalGroup(
            tbl_sanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl_sanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(267, 267, 267))
            .addComponent(jScrollPane2)
            .addGroup(tbl_sanPhamLayout.createSequentialGroup()
                .addGroup(tbl_sanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbl_sanPhamLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timKiem1))
                    .addGroup(tbl_sanPhamLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_soLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_themSP)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        tbl_sanPhamLayout.setVerticalGroup(
            tbl_sanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl_sanPhamLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(tbl_sanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField2)
                    .addComponent(btn_timKiem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(tbl_sanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_soLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themSP))
                .addGap(30, 30, 30))
        );

        add(tbl_sanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 405, 640, -1));

        tbl_hoaDon.setBackground(new java.awt.Color(245, 245, 247));

        jLabel4.setText("BILL");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel5.setText("Customer ID");

        jLabel6.setText("Phone Number");

        jLabel7.setText("Address");

        jLabel8.setText("Customer Name");

        jLabel9.setText("Email");

        jLabel10.setText("GIỎ HÀNG");

        tbl_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_gioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_gioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_gioHang);

        btn_xoaGioHang.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\eraser.png")); // NOI18N
        btn_xoaGioHang.setText("Remove From Cart");
        btn_xoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaGioHangActionPerformed(evt);
            }
        });

        jLabel11.setText("Total");

        jLabel12.setText("(VNĐ)");

        lbl_maKH.setText("................");

        lbl_sdtKH.setText("................");

        lbl_diaChiKH.setText("................");

        lbl_tenKH.setText("...................");

        lbl_emailKH.setText("...................");

        lbl_tongTien.setText(".........");

        javax.swing.GroupLayout tbl_hoaDonLayout = new javax.swing.GroupLayout(tbl_hoaDon);
        tbl_hoaDon.setLayout(tbl_hoaDonLayout);
        tbl_hoaDonLayout.setHorizontalGroup(
            tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_hoaDonLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_diaChiKH)
                    .addComponent(lbl_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_emailKH)
                    .addComponent(lbl_tenKH))
                .addGap(128, 128, 128))
            .addGroup(tbl_hoaDonLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl_hoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl_hoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(40, 40, 40)
                        .addComponent(lbl_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl_hoaDonLayout.createSequentialGroup()
                        .addComponent(btn_xoaGioHang)
                        .addGap(44, 44, 44))))
        );
        tbl_hoaDonLayout.setVerticalGroup(
            tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_hoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(lbl_maKH)
                    .addComponent(lbl_tenKH))
                .addGap(42, 42, 42)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(lbl_sdtKH)
                    .addComponent(lbl_emailKH))
                .addGap(41, 41, 41)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_diaChiKH))
                .addGap(47, 47, 47)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btn_xoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(tbl_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(lbl_tongTien))
                .addContainerGap())
        );

        add(tbl_hoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 73, -1, -1));

        btn_thanhToan.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\money-icon.png")); // NOI18N
        btn_thanhToan.setText("Payment");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });
        add(btn_thanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(947, 645, -1, 51));

        btn_thoat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Thoat.png")); // NOI18N
        btn_thoat.setText("Exit");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1132, 645, 115, 51));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel13.setText("BILL");

        jLabel20.setText("Staff");

        lbl_maNhanVien.setText("......");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(627, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(449, 449, 449)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(lbl_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20)
                    .addComponent(lbl_maNhanVien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 9, 1250, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clay-banks-E2HgkL3LaFE-unsplash.jpg"))); // NOI18N
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1280, 740));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
//        String tuKhoa = txt_search.getText() ;
//        if (tuKhoa.equals("")) {
//            getData(listKH);
//        }else{
//            ArrayList<KhachHang> ListResult = new ArrayList<>();
//            for (int i = 0; i < listKH.size(); i++) {
//                if (listKH.get(i).getMaKhachHang().contains(tuKhoa) || listKH.get(i).getSdt().contains(tuKhoa) || listKH.get(i).getEmail().contains(tuKhoa)) {
//                    ListResult.add(listKH.get(i));
//                }
//            }
//            getData(ListResult);
//        }
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_timKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timKiem1ActionPerformed

    private void tbl_khach_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khach_hangMouseClicked
        int row = tbl_khach_hang.getSelectedRow() ;
        String maKhachHang = tbl_khach_hang.getValueAt(row,0).toString();
        ArrayList<KhachHang> listKH = loadKH();
        for (int i = 0; i < listKH.size(); i++) {
            if (maKhachHang.equals(listKH.get(i).getMaKhachHang())) {
                kh = listKH.get(i);
                index = i;
                break ;
            }   
        }
        lbl_maKH.setText(kh.getMaKhachHang());
        lbl_tenKH.setText(kh.getHoTen());
        lbl_sdtKH.setText(kh.getSdt());
        lbl_diaChiKH.setText(kh.getDiaChi());
        lbl_emailKH.setText(kh.getEmail());
    }//GEN-LAST:event_tbl_khach_hangMouseClicked

    private void tbl_san_phamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_san_phamMouseClicked
        int row = tbl_san_pham.getSelectedRow() ;
        String maKhachHang = tbl_san_pham.getValueAt(row, 0).toString();
        ArrayList<SanPham> listSP = loadSP() ;
        for (int i = 0; i < listSP.size(); i++) {
            if (maKhachHang.equals(listSP.get(i).getMaSanPham())) {
                sp = listSP.get(i) ;
                index = i;
                break ;
            }
        }
        txt_soLuongSP.setText("1") ;
    }//GEN-LAST:event_tbl_san_phamMouseClicked
        double tongTien ;
    private void btn_themSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSPActionPerformed
        int soLuongMua = Integer.parseInt(txt_soLuongSP.getText());
        if (soLuongMua<=0) {
            JOptionPane.showMessageDialog(this,"Number of products must be > 0!");
        }else if (soLuongMua + soLuongSPTrongListGioHang(sp.getMaSanPham()) > Integer.parseInt(sp.getSoLuong())){
            JOptionPane.showMessageDialog(this,"Product Quantity is larger than the Quantity in stock!");
        }else{
            HoaDon hd = new HoaDon() ;
            hd.setMaSanPham(sp.getMaSanPham());
            hd.setSoLuongMua(soLuongMua);
            hd.setDonGia(Double.parseDouble(sp.getGiaBan()));
            hd.setThanhTien(soLuongMua*Double.parseDouble(sp.getGiaBan()));
            if (checkSPExistGioHang(hd.getMaSanPham(),listGioHang)) {
                HoaDon hoaDon = listGioHang.get(indexMaSPTrungTrongGioHang) ;
                hoaDon.setSoLuongMua(Integer.parseInt(txt_soLuongSP.getText())+ hoaDon.getSoLuongMua());
                hoaDon.setThanhTien(hoaDon.getDonGia()*hoaDon.getSoLuongMua());
                listGioHang.set(indexMaSPTrungTrongGioHang, hoaDon);
            }else{
                listGioHang.add(hd) ;
            }
            loadGioHang(listGioHang) ;
            JOptionPane.showMessageDialog(this,"Add to Cart Successfully !");
            tongTien = 0;
            for (int i = 0; i < listGioHang.size(); i++) {
                tongTien += listGioHang.get(i).getThanhTien();
            }
            lbl_tongTien.setText(formatter.format(tongTien));
        }
    }//GEN-LAST:event_btn_themSPActionPerformed
    String maSanPham ;
    private void tbl_gioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_gioHangMouseClicked
        int row = tbl_gioHang.getSelectedRow() ;
        maSanPham = tbl_gioHang.getValueAt(row, 0).toString();
    }//GEN-LAST:event_tbl_gioHangMouseClicked

    private void btn_xoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaGioHangActionPerformed
        double tienGiam ;
        for (int i = 0; i < listGioHang.size(); i++) {
            if (maSanPham.equals(listGioHang.get(i).getMaSanPham())) {
                tienGiam = listGioHang.get(i).getThanhTien();
                listGioHang.remove(i) ;
                tongTien = tongTien - tienGiam ;
                lbl_tongTien.setText(String.valueOf(tongTien));
            }
        }
        loadGioHang(listGioHang);
    }//GEN-LAST:event_btn_xoaGioHangActionPerformed
    
    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        if (kh.getMaKhachHang() == null || kh.getMaKhachHang().equals("")) {
            JOptionPane.showMessageDialog(this,"Please Select the Product First!");
            return ;
        }else{
            Date date = new Date() ;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss") ;
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy") ;
            String maHoaDon = kh.getMaKhachHang() + "-" + sdf.format(date) ;
            for (int i = 0; i < listGioHang.size(); i++) {
                HoaDon hd = listGioHang.get(i) ;
                hd.setMaHoaDon(maHoaDon) ;
                hd.setMaKhachHang(kh.getMaKhachHang());
                hd.setMaNhanVien(frmDangNhap.maDN) ;
                hd.setNgayBan(sdf2.format(date));
                listGioHang.set(i, hd) ;
            }
            
            if (hieu<0) {
                    JOptionPane.showMessageDialog(this,"Quantity Error");
                    return ;
                }
            
            JTextField txtSoTien = new JTextField(10);
            
            JPanel myPanel = new JPanel() ;
            myPanel.add(Box.createHorizontalStrut(10));
            myPanel.add(new JLabel("Money given by customer: ")) ;
            myPanel.add(txtSoTien);
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Amount paid by customer: ", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                double soTienKhachDua = Double.parseDouble(txtSoTien.getText());
                if (soTienKhachDua< tongTien) {
                    JOptionPane.showMessageDialog(this,"The Money given by the Customer is not enough !");
                    return ;
                }else if (soTienKhachDua > tongTien) {
                    JOptionPane.showMessageDialog(this,"Excess cash: "+(soTienKhachDua - tongTien));
                }
                saveFile();
                JOptionPane.showMessageDialog(this,"Payment Successfully !");
                frmSanPham frmSP = new frmSanPham() ;
                frmSP.loadFile();
                for (int i = 0; i < listGioHang.size(); i++) {
                    updateSoLuong(listGioHang.get(i).getMaSanPham(), listGioHang.get(i).getSoLuongMua(),frmSP.listSP);
                }
                frmSP.saveFile();
                listGioHang = new ArrayList<>();
                sendmail(sp.getTenSP(), tongTien, kh.getEmail());
                reset();
            }
        }
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        try {
       //Code
       System.exit(0);
}
catch (Exception ex) {
       //Log the exception
}
finally {
       System.exit(1);
}
    }//GEN-LAST:event_btn_thoatActionPerformed
    int hieu ;
    public void updateSoLuong(String maSanPham, int soLuongMua, ArrayList<SanPham> listSanPham){
        for (int i = 0; i < listSanPham.size(); i++) {
            if (maSanPham.equals(listSanPham.get(i).getMaSanPham())) {
                SanPham sp = listSanPham.get(i) ;
                 hieu = Integer.parseInt(sp.getSoLuong())-soLuongMua;
                String hieu1 = String.valueOf(hieu) ;
//                if (hieu<0) {
//                    JOptionPane.showMessageDialog(this,"So luong loi");
//                    return ;
//                }
                sp.setSoLuong(hieu1);
//                sp.setSoLuong(sp.getSoLuong()-soLuongMua);
                listSanPham.set(i,sp);
            }
        }
    }
    
    public void reset(){
        getDataKH(loadKH());
        getDataSP(loadSP());
        loadGioHang(listGioHang);
        lbl_maKH.setText("...");
        lbl_tenKH.setText("...");
        lbl_sdtKH.setText("...");
        lbl_diaChiKH.setText("...");
        lbl_emailKH.setText("...");
        tongTien = 0 ;
        lbl_tongTien.setText("...");
    }
    
    public void saveFile(){
        try {
            BufferedWriter bw = null ;
            FileWriter fw = null ;
            String data = "" ;
            for (int i = 0; i < listGioHang.size(); i++) {
                String row = "" ;
                row = row + listGioHang.get(i).getMaHoaDon() + "\t" ;
                row = row + listGioHang.get(i).getMaNhanVien()+ "\t" ;
                row = row + listGioHang.get(i).getMaKhachHang()+ "\t" ;
                row = row + listGioHang.get(i).getMaSanPham()+ "\t" ;
                row = row + listGioHang.get(i).getSoLuongMua()+ "\t" ;
                row = row + listGioHang.get(i).getDonGia()+ "\t" ;
                row = row + listGioHang.get(i).getThanhTien()+ "\t" ;
                row = row + listGioHang.get(i).getNgayBan()+ "\n" ;
                data +=row ;
            }
            fw = new FileWriter("hoadon.txt",true) ;
            bw = new BufferedWriter(fw) ;
            bw.write(data);
            bw.close();
        } catch (Exception ex) {
            //
        }
    }
    
    int indexMaSPTrungTrongGioHang ;
    
    public boolean checkSPExistGioHang (String maSanPham, ArrayList<HoaDon> listHD){
        for (int i = 0; i < listHD.size(); i++) {
            if (maSanPham.equals(listHD.get(i).getMaSanPham())) {
                indexMaSPTrungTrongGioHang = i ;
                return true ;
            }
        }
        return false ;
    }
    
    public void loadGioHang(ArrayList<HoaDon> listHD){
        defaultTableModel = new DefaultTableModel() ;
        defaultTableModel.addColumn("Product ID");
        defaultTableModel.addColumn("Product Name");
        defaultTableModel.addColumn("Unit");
        defaultTableModel.addColumn("Quantity");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("Total");
        for (HoaDon obj : listHD) {
            SanPham sp = new frmBanHang().getSPByCode(obj.getMaSanPham());
            Vector vector = new Vector() ;
            vector.add(obj.getMaSanPham());
            vector.add(sp.getTenSP());
            vector.add(sp.getDonVi());
            vector.add(formatter.format(obj.getSoLuongMua()));
            vector.add(formatter.format(obj.getDonGia()));
            vector.add(formatter.format(obj.getThanhTien()));
            defaultTableModel.addRow(vector);
        }
        tbl_gioHang.setModel(defaultTableModel);
        if (listHD.size()>0) {
            btn_thanhToan.setEnabled(true);
        }else{
            btn_thanhToan.setEnabled(false);
        }
    }
    
    public int soLuongSPTrongListGioHang(String maSanPham){
        for (int i = 0; i < listGioHang.size(); i++) {
            if (maSanPham.equals(listGioHang.get(i).getMaSanPham())) {
                return listGioHang.get(i).getSoLuongMua() ;
            }
        }
        return 0;
    }
    
    public void sendmail(String tenSanPhamString, Double tien, String emailKH) {
        try {
            Email email = new SimpleEmail();

            // Cấu hình thông tin Email Server
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("khanhmaidangcap@gmail.com", "bokhanh271298")); //Nhớ nhập đúng với tài khoản thật nhé :))

            // Với gmail cái này là bắt buộc.
            email.setSSLOnConnect(true);

            // Người gửi
            email.setFrom("khanhtrau19@gmail.com", "Sales Manager System");

            // Tiêu đề
            email.setSubject("THANK YOU FOR BUYING"); //Tiêu đề khi gửi email

            // Nội dung email
//            String covert = String.valueOf(rand);
            email.setMsg("Thank you for buying "+tenSanPhamString+" at the price "+tien); //Nội dung email bạn muốn gửi.
            // Người nhận
            email.addTo(kh.getEmail()); //Đia chỉ email người nhận
            email.send(); //Thực hiện gửi.
            System.err.println("Send Email Successfully! Please Check your Email");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Email sending failed !");
        }
    }
    
    public SanPham getSPByCode(String maSanPham){
        ArrayList<SanPham> listSP = loadSP();
        for (int i = 0; i < listSP.size(); i++) {
            if (maSanPham.equals(listSP.get(i).getMaSanPham())) {
                return listSP.get(i) ;
            }
        }
        return null ;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.JButton btn_themSP;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_timKiem1;
    private javax.swing.JButton btn_xoaGioHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_diaChiKH;
    private javax.swing.JLabel lbl_emailKH;
    private javax.swing.JLabel lbl_maKH;
    private javax.swing.JLabel lbl_maNhanVien;
    private javax.swing.JLabel lbl_sdtKH;
    private javax.swing.JLabel lbl_tenKH;
    private javax.swing.JLabel lbl_tongTien;
    private javax.swing.JTable tbl_gioHang;
    private javax.swing.JPanel tbl_hoaDon;
    private javax.swing.JTable tbl_khach_hang;
    private javax.swing.JPanel tbl_sanPham;
    private javax.swing.JTable tbl_san_pham;
    private javax.swing.JTextField txt_soLuongSP;
    // End of variables declaration//GEN-END:variables
}

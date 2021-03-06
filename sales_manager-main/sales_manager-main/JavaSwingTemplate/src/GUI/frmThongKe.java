/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.HoaDon;
import OBJ.KhachHang;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class frmThongKe extends javax.swing.JPanel {
    DefaultTableModel defaultTableModel = new DefaultTableModel() ;
    ArrayList<HoaDon> listHoaDon = new ArrayList<>();
    NumberFormat formatter = new DecimalFormat("###,###") ;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.0-MM-yyyy") ;
    frmDangNhap dn = new frmDangNhap();
    
    
    /**
     * Creates new form frmThongKe
     */
    public frmThongKe() {
        initComponents();
        loadFile();
        getData(listHoaDon) ;
        
        jPanel1.setBackground(new Color(245,245,247,200));
        jPanel2.setBackground(new Color(245,245,247,200));

    }
    
    public void loadFile(){
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listHoaDon = new ArrayList<>(); //lưu ý
            fr = new FileReader("hoadon.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    HoaDon hd = new HoaDon();
                    hd.setMaKhachHang(arr[0]);
                    hd.setMaNhanVien(arr[1]);
                    hd.setMaKhachHang(arr[2]);
                    hd.setMaSanPham(arr[3]);
                    hd.setSoLuongMua(Integer.parseInt(arr[4]));
//                    nv.setNhom(Integer.parseInt(arr[5]));
                    hd.setDonGia(Double.parseDouble(arr[5]));
                    hd.setThanhTien(Double.parseDouble(arr[6]));
                    hd.setNgayBan(arr[7]);
                    listHoaDon.add(hd);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getData(ArrayList<HoaDon> listHoaDon){
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Bill ID");
        defaultTableModel.addColumn("Staff ID");
        defaultTableModel.addColumn("Customer ID");
        defaultTableModel.addColumn("Product ID");
        defaultTableModel.addColumn("Amount");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("Total");
        defaultTableModel.addColumn("Sale Date");
        
//        defaultTableModel.addColumn("Nhóm");
//        defaultTableModel.addColumn("Trạng Thái");

        for (HoaDon hd : listHoaDon) {
            Vector vector = new Vector();
            vector.add(hd.getMaKhachHang());
            vector.add(hd.getMaNhanVien());
            vector.add(hd.getMaKhachHang());
            
            vector.add(hd.getMaSanPham());
            vector.add(formatter.format(hd.getSoLuongMua())) ;
            vector.add(formatter.format(hd.getDonGia())) ;
            vector.add(formatter.format(hd.getThanhTien())) ;
            vector.add(hd.getNgayBan()) ;
//            vector.add(obj.getDiaChi());
//            vector.add(obj.getGioiTinh());
////            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
//            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        tbl_thongKe.setModel(defaultTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_maNhanVien = new javax.swing.JTextField();
        jDate = new com.toedter.calendar.JDateChooser();
        btn_thongKe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongKe = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 247));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Day/Month/Year");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel3.setText("Staff ID");

        btn_thongKe.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        btn_thongKe.setText("Statistic");
        btn_thongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1017, 1017, 1017)
                        .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        tbl_thongKe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_thongKe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1280, 96));

        jPanel2.setBackground(new java.awt.Color(245, 245, 247));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("STATISTICS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 26, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carlos-muza-hpjSkU2UYSU-unsplash.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 1280, 730));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeActionPerformed
        Date date = jDate.getDate() ;
        String date_str = sdf.format(date) ;
        
        String maNhanVien = txt_maNhanVien.getText() ;
        ArrayList<HoaDon> listHoaDon_TimKiem = new ArrayList<>() ;
        for (int i = 0; i < listHoaDon.size(); i++) {
            if (listHoaDon.get(i).getNgayBan().contains(date_str)||listHoaDon.get(i).getMaNhanVien().contains(maNhanVien)) {
                listHoaDon_TimKiem.add(listHoaDon.get(i));
            }
        }
        getData(listHoaDon_TimKiem);
    }//GEN-LAST:event_btn_thongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_thongKe;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_thongKe;
    private javax.swing.JTextField txt_maNhanVien;
    // End of variables declaration//GEN-END:variables
}

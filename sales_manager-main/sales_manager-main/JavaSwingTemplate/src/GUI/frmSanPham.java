/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



//import OBJ.KhachHang;
import OBJ.SanPham ;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class frmSanPham extends javax.swing.JPanel {

    /**
     * Creates new form frmSanPham
     */
    public frmSanPham() {
        initComponents();
        loadFile();
        getData(listSP);
        jPanel5.setBackground(new Color(245,245,247,150));
        jPanel2.setBackground(new Color(245,245,247,150));

    }
    
    private DefaultTableModel defaultTableModel;
    SanPham sp = new SanPham();
    ArrayList<SanPham> listSP = new ArrayList<>();
    
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listSP = new ArrayList<>(); //lưu ý
            fr = new FileReader("sanpham.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    SanPham sp = new SanPham();
                    sp.setMaSanPham(arr[0]);
                    sp.setTenSP(arr[1]);
                    sp.setDonVi(arr[2]);
                    sp.setTenNSX(arr[3]);
                    sp.setGiaBan(arr[4]);
//                    nv.setNhom(Integer.parseInt(arr[5]));
                    sp.setGiaNhap(arr[5]);
                    sp.setSoLuong(arr[6]);
                    listSP.add(sp);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
    
    private void getData(ArrayList<SanPham> listSP) {
        
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Product ID");
        defaultTableModel.addColumn("Product Name");
        defaultTableModel.addColumn("Unit");
        defaultTableModel.addColumn("Producer");
        defaultTableModel.addColumn("Selling Price");
        defaultTableModel.addColumn("Entry Price");
//        defaultTableModel.addColumn("Nhóm");
        defaultTableModel.addColumn("Amount");

        for (SanPham obj : listSP) {
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
        tbl_sanpham.setModel(defaultTableModel);
    }
    
    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listSP.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listSP.get(i).getMaSanPham()+ "\t";
                row = row + listSP.get(i).getTenSP()+ "\t";
                row = row + listSP.get(i).getDonVi()+ "\t";
                row = row + listSP.get(i).getTenNSX()+ "\t";
//                row = row + listKH.get(i).getMatKhau() + "\t";
                row = row + listSP.get(i).getGiaBan()+ "\t";
                row = row + listSP.get(i).getGiaNhap()+ "\t";
                row = row + listSP.get(i).getSoLuong()+ "\n";
                data += row;
            }
            fw = new FileWriter("sanpham.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    public void reset(){
        txt_maSP.setText("");
        txt_tenSP.setText("");
        txt_donVi.setText("");
        txt_tenNSX.setText("");
        txt_giaBan.setText("");
        txt_giaNhap.setText("");
        txt_soLuong.setText("");
        btn_them.setEnabled(true);
        btn_sua.setEnabled(true);
        btn_xoa.setEnabled(true);
        btn_thoat.setEnabled(true);
        txt_maSP.setEnabled(true);
        getData(listSP);
    }
    
    public boolean ktMaSP(String maSanPham){
        boolean masanpham = false ;
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getMaSanPham().contains(maSanPham)) {
                masanpham = true ;
                break ;
            }
        }
        return masanpham ;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        txt_giaBan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_donVi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tenNSX = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_maSP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_tenSP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_timKiem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_sanpham);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1280, 80));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\clipboard-icon.png")); // NOI18N
        jLabel5.setText("Amount");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Add.png")); // NOI18N
        jLabel4.setText("Entry Price");

        txt_giaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaNhapActionPerformed(evt);
            }
        });

        txt_giaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaBanActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\money-icon.png")); // NOI18N
        jLabel7.setText("Selling Price");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\calculator-icon.png")); // NOI18N
        jLabel3.setText("Unit");

        txt_donVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_donViActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\contacts-icon.png")); // NOI18N
        jLabel6.setText("Producer");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\booklet-icon.png")); // NOI18N
        jLabel2.setText("Product ID");

        txt_maSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maSPActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\document-icon.png")); // NOI18N
        jLabel1.setText("Product Name");

        txt_tenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel9))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(23, 23, 23)
                                .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_donVi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(48, 48, 48)
                            .addComponent(txt_tenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_donVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 730, 380));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_timKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\rocket-icon.png")); // NOI18N
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btn_timKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 42, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\arrow-down-icon.png")); // NOI18N
        jLabel8.setText("Search");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 11, -1, -1));
        jPanel2.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 42, 187, 33));

        btn_them.setBackground(new java.awt.Color(255, 255, 255));
        btn_them.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\pencil-icon.png")); // NOI18N
        btn_them.setText("Add");
        btn_them.setAutoscrolls(true);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel2.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 93, 110, 68));

        btn_xoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\stop-icon.png")); // NOI18N
        btn_xoa.setText("Remove");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 93, 110, 68));

        btn_thoat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\running-icon.png")); // NOI18N
        btn_thoat.setText("Exit");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        jPanel2.add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 189, 110, 68));

        btn_sua.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Sua.png")); // NOI18N
        btn_sua.setText("Edit");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 189, 110, 68));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, 340, 290));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/revolt-164_6wVEHfI-unsplash.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1290, 720));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_donViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_donViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_donViActionPerformed

    private void txt_maSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maSPActionPerformed

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

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(this,"Are you sure want to Remove ?","Remove",2);
        if (confirm == JOptionPane.YES_OPTION) {
            if(listSP.remove(sp)){
            saveFile();
            getData(listSP);
                JOptionPane.showMessageDialog(this,"Remove Successfully "+sp.getTenSP());
            }else{
                JOptionPane.showMessageDialog(this,"Remove Failed !");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String maSanPham = txt_maSP.getText() ;
        String tenSP = txt_tenSP.getText() ;
        String donVi = txt_donVi.getText() ;
        String tenNSX = txt_tenNSX.getText() ;
        String giaBan = txt_giaBan.getText() ;
        String giaNhap = txt_giaNhap.getText() ;
        String soLuong = txt_soLuong.getText() ;
        
        
        if (maSanPham.equals("")) {
            JOptionPane.showMessageDialog(this,"Product ID must not Empty !");
            return ;
        }
        else if (ktMaSP(maSanPham)==true) {
            JOptionPane.showMessageDialog(this,"Product ID is already exists !");
            return ;
        }
        else if(tenSP.equals("")) {
            JOptionPane.showMessageDialog(this,"Product Name must not Empty !");
            return ;
        }
        else if(donVi.equals("")) {
            JOptionPane.showMessageDialog(this,"Unit must not Empty !");
            return ;
        }
        else if(tenNSX.equals("")) {
            JOptionPane.showMessageDialog(this,"Producer must not Empty !");
            return ;
        }
        else if(giaNhap.equals("")) {
            JOptionPane.showMessageDialog(this,"Entry Price must not Empty !");
            return ;
        }
        else if(giaBan.equals("")) {
            JOptionPane.showMessageDialog(this,"Selling Price must not Empty !");
            return ;
        }
        else if(soLuong.equals("")) {
            JOptionPane.showMessageDialog(this,"Amount must not Empty !");
            return ;
        }
        else if (Double.parseDouble(soLuong)<=0) {
            JOptionPane.showMessageDialog(this,"Amount > 0 !");
            return ;
        }
        else if (Double.parseDouble(giaNhap) <=0) {
            JOptionPane.showMessageDialog(this,"Entry Price > 0 !");
            return ;
        }
        else if (Double.parseDouble(giaBan) <=0) {
            JOptionPane.showMessageDialog(this,"Selling Price > 0 !");
            return ;
        }
        else{
        SanPham sp = new SanPham() ;
        sp.setMaSanPham(maSanPham);
        sp.setTenSP(tenSP);
        sp.setDonVi(donVi);
        sp.setTenNSX(tenNSX);
        sp.setGiaBan(giaBan);
        sp.setGiaNhap(giaNhap);
        sp.setSoLuong(soLuong);
        
        
        listSP.add(sp);
        saveFile();
        getData(listSP);
        JOptionPane.showMessageDialog(this,"Add Product Successfully !");
        reset();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
//        String maSanPham = txt_maSP.getText() ;
        String tenSP = txt_tenSP.getText() ;
        String donVi = txt_donVi.getText() ;
        String tenNSX = txt_tenNSX.getText() ;
        String giaBan = txt_giaBan.getText() ;
        String giaNhap = txt_giaNhap.getText() ;
        String soLuong = txt_soLuong.getText() ;
        
        
//        if (maSanPham.equals("")) {
//            JOptionPane.showMessageDialog(this,"Mã sản phẩm không được để trống !");
//            return ;
//        }
//        else if (ktMaSP(maSanPham)==true) {
//            JOptionPane.showMessageDialog(this,"Mã san pham đã tồn tại !");
//            return ;
//        }
        if(tenSP.equals("")) {
            JOptionPane.showMessageDialog(this,"Product ID must not Empty !");
            return ;
        }
        else if(donVi.equals("")) {
            JOptionPane.showMessageDialog(this,"Unit must not Empty !");
            return ;
        }
        else if(tenNSX.equals("")) {
            JOptionPane.showMessageDialog(this,"Producer must not Empty !");
            return ;
        }
        else if(giaNhap.equals("")) {
            JOptionPane.showMessageDialog(this,"Entry Price must not Empty !");
            return ;
        }
        else if(giaBan.equals("")) {
            JOptionPane.showMessageDialog(this,"Selling Price must not Empty !");
            return ;
        }
        else if(soLuong.equals("")) {
            JOptionPane.showMessageDialog(this,"Amount must not Empty !");
            return ;
        }
        else if (Double.parseDouble(soLuong)<=0) {
            JOptionPane.showMessageDialog(this,"Amount > 0 !");
            return ;
        }
        else if (Double.parseDouble(giaNhap) <=0) {
            JOptionPane.showMessageDialog(this,"Entry Price > 0 !");
            return ;
        }
        else if (Double.parseDouble(giaBan) <=0) {
            JOptionPane.showMessageDialog(this,"Selling Price > 0 !");
            return ;
        }
        else{
//        SanPham sp = new SanPham() ;
//        sp.setMaSanPham(maSanPham);
        sp.setTenSP(tenSP);
        sp.setDonVi(donVi);
        sp.setTenNSX(tenNSX);
        sp.setGiaBan(giaBan);
        sp.setGiaNhap(giaNhap);
        sp.setSoLuong(soLuong);
        
        
        listSP.set(index,sp);
        saveFile();
        getData(listSP);
        JOptionPane.showMessageDialog(this,"Edit Successfully !");
        reset();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_giaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaBanActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        String tuKhoa = txt_search.getText() ;
        if (tuKhoa.equals("")) {
            getData(listSP);
        }else{
            ArrayList<SanPham> ListResult = new ArrayList<>();
            for (int i = 0; i < listSP.size(); i++) {
                if (listSP.get(i).getMaSanPham().contains(tuKhoa)) {
                    ListResult.add(listSP.get(i));
                }
            }
            getData(ListResult);
        }

    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void txt_giaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaNhapActionPerformed
    int index ;
    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked
        int row = tbl_sanpham.getSelectedRow(); 
        String maSanPham = tbl_sanpham.getValueAt(row, 0).toString() ;
        for (int i = 0; i < listSP.size(); i++) {
            if (maSanPham.equalsIgnoreCase(listSP.get(i).getMaSanPham())) {
                sp = listSP.get(i) ;
                index = i ;
                break ;
            }
        }
        txt_maSP.setText(sp.getMaSanPham());
        txt_maSP.setEnabled(false);
        txt_tenSP.setText(sp.getTenSP());
        txt_donVi.setText(sp.getDonVi());
        txt_tenNSX.setText(sp.getTenNSX());
        txt_giaNhap.setText(sp.getGiaNhap());
        txt_giaBan.setText(sp.getGiaBan());
        txt_soLuong.setText(sp.getSoLuong());
//        txt_matkhau.setText(nv.getMatKhau());
//        txt_matkhau.setEnabled(false);
//        if (kh.getGioiTinh().equals("Nam")) {
//            txt_gioiTinh.setSelectedItem("Nam");
//        }else if(kh.getGioiTinh().equals("Nữ")){
//            txt_gioiTinh.setSelectedItem("Nữ");
//        }
//        if (nv.getNhom() == 1) {
//            txt_nhom.setSelectedItem("Quản Lý");
//        }else {
//            txt_nhom.setSelectedItem("Nhân Viên");
//        }
//        if (kh.getTrangThai()== 1) {
//            txt_trangThai.setSelectedItem("Active");
//        }else {
//            txt_trangThai.setSelectedItem("Deactive");
//        }
        btn_them.setEnabled(false);
                           
    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void txt_tenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_donVi;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_maSP;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenNSX;
    private javax.swing.JTextField txt_tenSP;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;




import OBJ.KhachHang;
import Utils.CheckForm;
import java.awt.Color;


//import OBJ.NhanVien;
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
public class frmKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form frmKhachHang
     */
    public frmKhachHang() {
        initComponents();
        loadFile();
        getData(listKH);
        jPanel3.setBackground(new Color(245,245,247,150));
        jPanel1.setBackground(new Color(245,245,247,150));
    }
    
    private DefaultTableModel defaultTableModel;
    KhachHang kh = new KhachHang();
    ArrayList<KhachHang> listKH = new ArrayList<>();
    
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listKH = new ArrayList<>(); //lưu ý
            fr = new FileReader("khachhang.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    KhachHang kh = new KhachHang();
                    kh.setMaKhachHang(arr[0]);
                    kh.setHoTen(arr[1]);
                    kh.setSdt(arr[2]);
                    kh.setEmail(arr[3]);
                    kh.setDiaChi(arr[4]);
//                    nv.setNhom(Integer.parseInt(arr[5]));
                    kh.setGioiTinh(arr[5]);
                    kh.setTrangThai(Integer.parseInt(arr[6]));
                    listKH.add(kh);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
    
    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listKH.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listKH.get(i).getMaKhachHang()+ "\t";
                row = row + listKH.get(i).getHoTen() + "\t";
                row = row + listKH.get(i).getSdt()+ "\t";
                row = row + listKH.get(i).getEmail() + "\t";
//                row = row + listKH.get(i).getMatKhau() + "\t";
                row = row + listKH.get(i).getDiaChi()+ "\t";
                row = row + listKH.get(i).getGioiTinh() + "\t";
                row = row + listKH.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("khachhang.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    private void getData(ArrayList<KhachHang> listKH) {
        
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Customer");
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
        tbl_khachhang.setModel(defaultTableModel);
    }
    
    public void reset(){
        txt_maKhachHang.setText("");
        txt_hoTen.setText("");
        txt_sdt.setText("");
        txt_email.setText("");
        txt_diaChi.setText("");
        txt_gioiTinh.setSelectedIndex(0);
        txt_trangThai.setSelectedIndex(0);
        btn_them.setEnabled(true);
        btn_sua.setEnabled(true);
        btn_xoa.setEnabled(true);
        btn_thoat.setEnabled(true);
        txt_maKhachHang.setEnabled(true);
        getData(listKH);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khachhang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_maKhachHang = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_diaChi = new javax.swing.JTextField();
        txt_hoTen = new javax.swing.JTextField();
        txt_gioiTinh = new javax.swing.JComboBox<>();
        txt_trangThai = new javax.swing.JComboBox<>();
        lbl_email_error = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_khachhang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khachhang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1280, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\dev-icon.png")); // NOI18N
        jLabel2.setText("Customer ID");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\email.png")); // NOI18N
        jLabel3.setText("Email");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 109, 88, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\smartphone-icon.png")); // NOI18N
        jLabel4.setText("Phone Number");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 184, 120, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\location-icon.png")); // NOI18N
        jLabel5.setText("Address");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 261, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\profile-icon.png")); // NOI18N
        jLabel6.setText("Customer Name");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\gender.png")); // NOI18N
        jLabel1.setText("Sex");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\unlocked-icon.png")); // NOI18N
        jLabel7.setText("Activity");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        txt_maKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maKhachHangActionPerformed(evt);
            }
        });
        txt_maKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_maKhachHangKeyPressed(evt);
            }
        });
        jPanel3.add(txt_maKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 140, -1));

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });
        jPanel3.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 110, 140, -1));

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });
        jPanel3.add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 185, 140, -1));

        txt_diaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diaChiActionPerformed(evt);
            }
        });
        jPanel3.add(txt_diaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 262, 140, -1));

        txt_hoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoTenActionPerformed(evt);
            }
        });
        jPanel3.add(txt_hoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 140, -1));

        txt_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        txt_gioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gioiTinhActionPerformed(evt);
            }
        });
        jPanel3.add(txt_gioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 110, 140, -1));

        txt_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactive" }));
        txt_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_trangThaiActionPerformed(evt);
            }
        });
        jPanel3.add(txt_trangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 185, 140, -1));

        lbl_email_error.setForeground(new java.awt.Color(245, 6, 6));
        jPanel3.add(lbl_email_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 140, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 650, 310));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Search");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 13, -1, -1));

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 47, 186, 30));

        btn_timKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\magnifying-glass-icon.png")); // NOI18N
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 47, -1, -1));

        btn_them.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Add.png")); // NOI18N
        btn_them.setText("Add");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 95, 110, 40));

        btn_xoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\eraser.png")); // NOI18N
        btn_xoa.setText("Remove");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 93, 110, 40));

        btn_sua.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Sua.png")); // NOI18N
        btn_sua.setText("Edit");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 163, 110, 40));

        btn_thoat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Thoat.png")); // NOI18N
        btn_thoat.setText("Exit");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        jPanel1.add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 163, 110, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 340, 230));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/freestocks-VFrcRtEQKL8-unsplash.jpg"))); // NOI18N
        jLabel9.setText("kj");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void txt_hoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoTenActionPerformed

    private void txt_gioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gioiTinhActionPerformed

    private void txt_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_trangThaiActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        String tuKhoa = txt_search.getText() ;
        if (tuKhoa.equals("")) {
            getData(listKH);
        }else{
            ArrayList<KhachHang> ListResult = new ArrayList<>();
            for (int i = 0; i < listKH.size(); i++) {
                if (listKH.get(i).getMaKhachHang().contains(tuKhoa) || listKH.get(i).getSdt().contains(tuKhoa) || listKH.get(i).getEmail().contains(tuKhoa)) {
                    ListResult.add(listKH.get(i));
                }
            }
            getData(ListResult);
        }
    }//GEN-LAST:event_btn_timKiemActionPerformed
    
    public boolean ktMaKH(String maKH){
        boolean makhachhang = false ;
        for (int i = 0; i < listKH.size(); i++) {
            if (listKH.get(i).getMaKhachHang().contains(maKH)) {
                makhachhang = true ;
                break ;
            }
        }
        return makhachhang ;
    }
    
//    public boolean kiemTraMaKhachHang(String maKH) {
//        String dinhDangMaKH = "^[^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
//        boolean ktMaKH = maKH.matches(dinhDangMaKH);
//        return ktMaKH;
////        // String dinhDangEmail nó giống như là format chuẩn cho email mình nhập vào, nếu sai cái
////        // dịnh dạng này thì là lỗi.
////        // Hàm matches dùng để xác định xem chuỗi email của mình có khớp với định dạng mình đã quy 
////        // định trước hay không. hàm này trả về true , false nên mình khởi tạo 1 biến ktEmail rồi gán
////        // cho nó. false thì báo lỗi.
//    }
    
    public boolean kiemTraSDT(String sdt){
        boolean check = false ;
        try {
            if (sdt.startsWith(0+"")==false) {
            check=true ;
        }else if (sdt.length() !=10){
            check=true ;
            }
        } catch (Exception ex) {
            check = true ;
        }
        return check ;
    }
    //
    public boolean kiemTraTen(String hoTen){
        for (int i = 0; i < 10; i++) {
            if (hoTen.contains(i + "")) {
                return true ;
            }
        }
        return false ;
    }
    //
    public boolean kiemTraEmail(String email) {
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        return ktEmail;
        // String dinhDangEmail nó giống như là format chuẩn cho email mình nhập vào, nếu sai cái
        // dịnh dạng này thì là lỗi.
        // Hàm matches dùng để xác định xem chuỗi email của mình có khớp với định dạng mình đã quy 
        // định trước hay không. hàm này trả về true , false nên mình khởi tạo 1 biến ktEmail rồi gán
        // cho nó. false thì báo lỗi.
    }
    
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String maKH = txt_maKhachHang.getText();
        String hoTen = txt_hoTen.getText();
        String sdt = txt_sdt.getText() ;
        String email = txt_email.getText() ;
        String diaChi = txt_diaChi.getText() ;
        String gioiTinh ="";
        if(txt_gioiTinh.getSelectedItem().equals("Male")){
            gioiTinh = "Female" ;   
        } else if(txt_gioiTinh.getSelectedItem().equals("Female")){
            gioiTinh = "Female" ;
        } else {
            gioiTinh = "Else" ;
        }
        int trangThai = 0;
        if (txt_trangThai.getSelectedItem().toString().equals("Active")) {
            trangThai = 1 ;
        }else {
            trangThai = 0 ;
        }
        //
        if (maKH.equals("")) {
            JOptionPane.showMessageDialog(this,"Customer ID must not Empty !");
            return ;
        }
        else if (ktMaKH(maKH)==true) {
            JOptionPane.showMessageDialog(this,"Customer ID is already exist!");
            return ;
        }
        else if(hoTen.equals("")) {
            JOptionPane.showMessageDialog(this,"Customer Name must not Empty !");
            return ;
        }
        else if(kiemTraTen(hoTen)==true){
            JOptionPane.showMessageDialog(this,"Customer Name must not contain digits !");
            return ;
        }
        else if(sdt.equals("")) {
            JOptionPane.showMessageDialog(this,"Phone Number must not Empty !");
            return ;
        }
        else if (kiemTraSDT(txt_sdt.getText()) == true) {
            JOptionPane.showMessageDialog(this,"The Phone Number  is incorrect !");
            return ;
        }
        else if(email.equals("")) {
            JOptionPane.showMessageDialog(this,"Email must not Empty !");
            return ;
        }
        else if (kiemTraEmail(txt_email.getText()) == false) {
            JOptionPane.showMessageDialog(this,"Email invalid !");
            return ;
        }
        else if(diaChi.equals("")) {
            JOptionPane.showMessageDialog(this,"Address must not Empty !");
            return ;
        }
        else{
            KhachHang kh = new KhachHang() ;
            kh.setMaKhachHang(maKH);
            kh.setHoTen(hoTen);
            kh.setSdt(sdt);
            kh.setEmail(email);
            kh.setDiaChi(diaChi);
            kh.setGioiTinh(gioiTinh);
            kh.setTrangThai(trangThai);

            listKH.add(kh);
            saveFile();
            getData(listKH);
            JOptionPane.showMessageDialog(this,"Add Customer Successfully !");
            reset() ;
        }
        
        
    }//GEN-LAST:event_btn_themActionPerformed

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

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
//        String maKH = txt_maKhachHang.getText();
        String hoTen = txt_hoTen.getText();
        String sdt = txt_sdt.getText() ;
        String email = txt_email.getText() ;
        String diaChi = txt_diaChi.getText() ;
        String gioiTinh ="";
        if(txt_gioiTinh.getSelectedItem().equals("Male")){
            gioiTinh = "Male" ;   
        } else if(txt_gioiTinh.getSelectedItem().equals("Female")){
            gioiTinh = "Female" ;
        } 
        int trangThai = 0;
        if (txt_trangThai.getSelectedItem().toString().equals("Active")) {
            trangThai = 1 ;
        }else {
            trangThai = 0 ;
        }
        //
//        if (maKH.equals("")) {
//            JOptionPane.showMessageDialog(this,"Mã khách hàng không được để trống !");
//            return ;
//        }
//        else if (ktMaKH(maKH)==true) {
//            JOptionPane.showMessageDialog(this,"Mã khách hàng đã tồn tại !");
//            return ;
//        }
        if(hoTen.equals("")) {
            JOptionPane.showMessageDialog(this,"Customer Name must not Empty !");
            return ;
        }
        else if(kiemTraTen(hoTen)==true){
            JOptionPane.showMessageDialog(this,"Customer Name must not contain digits !");
            return ;
        }
        else if(sdt.equals("")) {
            JOptionPane.showMessageDialog(this,"Phone Number must not Empty !");
            return ;
        }
        else if (kiemTraSDT(txt_sdt.getText()) == true) {
            JOptionPane.showMessageDialog(this,"Phone Number Invalid !");
            return ;
        }
        else if(email.equals("")) {
            JOptionPane.showMessageDialog(this,"Email must not Empty !");
            return ;
        }
        else if (kiemTraEmail(txt_email.getText()) == false) {
            JOptionPane.showMessageDialog(this,"Email Invalid !");
            return ;
        }
        else if(diaChi.equals("")) {
            JOptionPane.showMessageDialog(this,"Address must not Empty !");
            return ;
        }
        else{
//            KhachHang kh = new KhachHang() ;
//            kh.setMaKhachHang(maKH);
            kh.setHoTen(hoTen);
            kh.setSdt(sdt);
            kh.setEmail(email);
            kh.setDiaChi(diaChi);
            kh.setGioiTinh(gioiTinh);
            kh.setTrangThai(trangThai);

            listKH.set(index, kh);
            saveFile();
            getData(listKH);
            JOptionPane.showMessageDialog(this,"Edit Customer Successfully !");
            reset() ;
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(this,"Are you sure want to delete? ?","Delete",2);
        if (confirm == JOptionPane.YES_OPTION) {
            if(listKH.remove(kh)){
            saveFile();
            getData(listKH);
                JOptionPane.showMessageDialog(this,"Delete Successfully "+kh.getHoTen());
            }else{
                JOptionPane.showMessageDialog(this,"Delele Error !");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_maKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maKhachHangActionPerformed

    private void txt_maKhachHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_maKhachHangKeyPressed
//        String maKH = txt_maKhachHang.getText();
//        if(kiemTraMaKhachHang(maKH) == false){
//            lbl_maKH_error.setText("Mã khách hàng chưa đúng định dạng");
//        }else{
//            lbl_maKH_error.setText("");
//        }            
    }//GEN-LAST:event_txt_maKhachHangKeyPressed

    private void txt_diaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diaChiActionPerformed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        String email = txt_email.getText() ;
        if (kiemTraEmail(email) == false) {
            lbl_email_error.setText("Email Invalid");
        }else{
            lbl_email_error.setText("");
        }
    }//GEN-LAST:event_txt_emailKeyPressed
    int index ;
    private void tbl_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khachhangMouseClicked
        int row = tbl_khachhang.getSelectedRow(); 
        String maKhachHang = tbl_khachhang.getValueAt(row, 0).toString() ;
        for (int i = 0; i < listKH.size(); i++) {
            if (maKhachHang.equalsIgnoreCase(listKH.get(i).getMaKhachHang())) {
                kh = listKH.get(i) ;
                index = i ;
                break ;
            }
        }
        txt_maKhachHang.setText(kh.getMaKhachHang());
        txt_maKhachHang.setEnabled(false);
        txt_hoTen.setText(kh.getHoTen());
        txt_email.setText(kh.getEmail());
        txt_sdt.setText(kh.getSdt());
        txt_diaChi.setText(kh.getDiaChi());
//        txt_matkhau.setText(nv.getMatKhau());
//        txt_matkhau.setEnabled(false);
        if (kh.getGioiTinh().equals("Male")) {
            txt_gioiTinh.setSelectedItem("Male");
        }else if(kh.getGioiTinh().equals("Female")){
            txt_gioiTinh.setSelectedItem("Female");
        }
//        if (nv.getNhom() == 1) {
//            txt_nhom.setSelectedItem("Quản Lý");
//        }else {
//            txt_nhom.setSelectedItem("Nhân Viên");
//        }
        if (kh.getTrangThai()== 1) {
            txt_trangThai.setSelectedItem("Active");
        }else {
            txt_trangThai.setSelectedItem("Deactive");
        }
        btn_them.setEnabled(false);
    }//GEN-LAST:event_tbl_khachhangMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_email_error;
    private javax.swing.JTable tbl_khachhang;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JComboBox<String> txt_gioiTinh;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maKhachHang;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    private javax.swing.JComboBox<String> txt_trangThai;
    // End of variables declaration//GEN-END:variables
}

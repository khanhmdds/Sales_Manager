/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.NhanVien;
import com.sun.deploy.uitoolkit.impl.fx.ui.FXUIFactory;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class frmNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form frmNhanVien
     */
    public frmNhanVien() {
        initComponents();
        loadFile();
        getData(listNV);
        jPanel2.setBackground(new Color(245,245,247,120));
        jPanel3.setBackground(new Color(245,245,247,120));
        
        
    }
    
    private DefaultTableModel defaultTableModel;
    NhanVien nv = new NhanVien();
    ArrayList<NhanVien> listNV = new ArrayList<>();
    
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listNV = new ArrayList<>(); //lưu ý
            fr = new FileReader("nhanvien.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(arr[0]);
                    nv.setHoTen(arr[1]);
                    nv.setSoDienThoai(arr[2]);
                    nv.setEmail(arr[3]);
                    nv.setMatKhau(arr[4]);
                    nv.setNhom(Integer.parseInt(arr[5]));
                    nv.setGioiTinh(arr[6]);
                    nv.setTrangThai(Integer.parseInt(arr[7]));
                    listNV.add(nv);
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
            for (int i = 0; i < listNV.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listNV.get(i).getMaNhanVien() + "\t";
                row = row + listNV.get(i).getHoTen() + "\t";
                row = row + listNV.get(i).getSoDienThoai() + "\t";
                row = row + listNV.get(i).getEmail() + "\t";
                row = row + listNV.get(i).getMatKhau() + "\t";
                row = row + listNV.get(i).getNhom() + "\t";
                row = row + listNV.get(i).getGioiTinh() + "\t";
                row = row + listNV.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("nhanvien.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    private void getData(ArrayList<NhanVien> listNV) {
        
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Staff ID");
        defaultTableModel.addColumn("Staff Name");
        defaultTableModel.addColumn("Phone Number");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Password");
        defaultTableModel.addColumn("Group");
        defaultTableModel.addColumn("Sex");
        defaultTableModel.addColumn("Activity");

        for (NhanVien obj : listNV) {
            Vector vector = new Vector();
            vector.add(obj.getMaNhanVien());
            vector.add(obj.getHoTen());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getEmail());
            vector.add(obj.getMatKhau());
            vector.add(obj.getNhom() == 1 ? "Manager" : "Employee");
            vector.add(obj.getGioiTinh());
            vector.add(obj.getTrangThai() == 1 ? "Activity" : "Locked");
            defaultTableModel.addRow(vector);
        }
        tbl_nhanvien.setModel(defaultTableModel);
    }
    //
    public static String md5(String str) {
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
}
    //
    public void reset(){
        txt_manhanvien.setText("");
        txt_hoten.setText("");
        txt_sdt.setText("");
        txt_email.setText("");
        txt_matkhau.setText("");
        txt_gioitinh.setSelectedIndex(0);
        txt_trangthai.setSelectedIndex(0);
        txt_nhom.setSelectedIndex(0);
        btn_them.setEnabled(true);
        btn_sua.setEnabled(true);
        btn_xoa.setEnabled(true);
        btn_thoat.setEnabled(true);
        txt_manhanvien.setEnabled(true);
        txt_matkhau.setEnabled(true);
        getData(listNV);
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
    //
    
    public boolean ktMaNV(String maNhanVien){
        boolean manhanvien = false ;
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getMaNhanVien().contains(maNhanVien)) {
                manhanvien = true ;
                break ;
            }
        }
        return manhanvien ;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_manhanvien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nhom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        txt_gioitinh = new javax.swing.JComboBox<>();
        txt_matkhau = new javax.swing.JPasswordField();
        txt_sdt = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_trangthai = new javax.swing.JComboBox<>();
        lbl_email_error = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_timKiem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_nhanvien.setBackground(new java.awt.Color(245, 245, 247));
        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_nhanvien);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1280, 80));

        jPanel2.setBackground(new java.awt.Color(245, 245, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\maNV.png")); // NOI18N
        jLabel1.setText("Staff ID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 36, -1, -1));

        txt_manhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_manhanvienActionPerformed(evt);
            }
        });
        jPanel2.add(txt_manhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 37, 140, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\nhomNV.png")); // NOI18N
        jLabel2.setText("Group");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 111, -1, -1));

        txt_nhom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Employee" }));
        jPanel2.add(txt_nhom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 112, 140, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\sdt.png")); // NOI18N
        jLabel3.setText("Phone Number");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 182, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\matKhau.png")); // NOI18N
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 254, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\hoTen.png")); // NOI18N
        jLabel5.setText("Staff Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 36, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\gender.png")); // NOI18N
        jLabel6.setText("Sex");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 111, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\email.png")); // NOI18N
        jLabel7.setText("Email");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 182, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\trangThai.png")); // NOI18N
        jLabel8.setText("Activity");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 254, -1, -1));
        jPanel2.add(txt_hoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 37, 140, -1));

        txt_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Femal" }));
        txt_gioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gioitinhActionPerformed(evt);
            }
        });
        jPanel2.add(txt_gioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 112, 140, -1));
        jPanel2.add(txt_matkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 255, 140, -1));
        jPanel2.add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 183, 140, -1));

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 183, 140, -1));

        txt_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactive" }));
        jPanel2.add(txt_trangthai, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 255, 140, -1));

        lbl_email_error.setBackground(new java.awt.Color(253, 7, 9));
        lbl_email_error.setForeground(new java.awt.Color(255, 6, 8));
        jPanel2.add(lbl_email_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 213, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 610, 320));

        jPanel3.setBackground(new java.awt.Color(245, 245, 247));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_timKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\timKiem.png")); // NOI18N
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });
        jPanel3.add(btn_timKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 42, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\arrow-down-icon.png")); // NOI18N
        jLabel9.setText("Search");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 11, -1, -1));
        jPanel3.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 42, 187, 33));

        btn_them.setBackground(new java.awt.Color(255, 255, 255));
        btn_them.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\pencil-icon.png")); // NOI18N
        btn_them.setText("Add");
        btn_them.setAutoscrolls(true);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel3.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 93, 120, 68));

        btn_xoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\stop-icon.png")); // NOI18N
        btn_xoa.setText("Remove");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel3.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 93, 110, 68));

        btn_thoat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\running-icon.png")); // NOI18N
        btn_thoat.setText("Exit");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        jPanel3.add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 189, 110, 68));

        btn_sua.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\IconJava\\Sua.png")); // NOI18N
        btn_sua.setText("Edit");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel3.add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 189, 120, 68));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 350, 290));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/duonguyen-RlakZ84ex2g-unsplash.jpg"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_manhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_manhanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_manhanvienActionPerformed

    private void txt_gioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gioitinhActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        String tuKhoa = txt_search.getText() ;
        if (tuKhoa.equals("")) {
            getData(listNV);
        }else{
            ArrayList<NhanVien> ListResult = new ArrayList<>();
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getMaNhanVien().contains(tuKhoa) || listNV.get(i).getSoDienThoai().contains(tuKhoa) || listNV.get(i).getEmail().contains(tuKhoa)){
                    ListResult.add(listNV.get(i));
                }
            }
            getData(ListResult);
        }
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String maNhanVien = txt_manhanvien.getText() ;
        String hoTen = txt_hoten.getText() ;
        String email = txt_email.getText() ;
        String soDienThoai = txt_sdt.getText() ;
        String matKhau = txt_matkhau.getText() ;
        String gioiTinh = "";
        if (txt_gioitinh.getSelectedItem().equals("Male")) {
            gioiTinh = "Male";
        }else if (txt_gioitinh.getSelectedItem().equals("Female")){
            gioiTinh = "Female" ;
        }
        int nhom =0 ;
        if (txt_nhom.getSelectedItem().toString().equals("Manager")) {
            nhom = 1 ;
        }else {
            nhom = 0 ;
        }
        int trangThai = 0;
        if (txt_trangthai.getSelectedItem().toString().equals("Active")) {
            trangThai = 1;
        }else {
            trangThai = 0 ;
        }
        //////////////////////////////////////////////////
        if (maNhanVien.equals("")) {
            JOptionPane.showMessageDialog(this,"Staff ID must not Empty !");
            return ;
        }
        else if (ktMaNV(maNhanVien)== true) {
            JOptionPane.showMessageDialog(this,"Staff ID is already exists !");
            return ;
        }
        else if(hoTen.equals("")) {
            JOptionPane.showMessageDialog(this,"Staff Name must not Empty !");
            return ;
        }
        else if(kiemTraTen(hoTen)==true){
            JOptionPane.showMessageDialog(this,"Staff Name must not contain digits !");
            return ;
        }
        else if(soDienThoai.equals("")) {
            JOptionPane.showMessageDialog(this,"Phone Number must not Empty !");
            return ;
        }
        else if (kiemTraSDT(txt_sdt.getText()) == true) {
            JOptionPane.showMessageDialog(this,"Phone Number is Incorrect !");
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
        else if(matKhau.equals("")) {
            JOptionPane.showMessageDialog(this,"Password must not Empty !");
            return ;
        }
        
        else{
            NhanVien nv = new NhanVien();
            nv.setMaNhanVien(maNhanVien);
            nv.setEmail(email);
            nv.setGioiTinh(gioiTinh);
            nv.setHoTen(hoTen);
            nv.setSoDienThoai(soDienThoai);
            nv.setNhom(nhom);
            nv.setTrangThai(trangThai);
            nv.setMatKhau(md5(matKhau));
            listNV.add(nv);
            saveFile();
            getData(listNV);
            JOptionPane.showMessageDialog(this,"Add Staff Successfully !");
            reset();
        }
        
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(this,"Are you sure want to remove?","Remove",2);
        if (confirm == JOptionPane.YES_OPTION) {
            if(listNV.remove(nv)){
            saveFile();
            getData(listNV);
                JOptionPane.showMessageDialog(this,"Remove Successfully "+nv.getHoTen());
            }else{
                JOptionPane.showMessageDialog(this,"Remove Failed !");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

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
//        String maNhanVien = txt_manhanvien.getText() ;
        String hoTen = txt_hoten.getText() ;
        String email = txt_email.getText() ;
        String soDienThoai = txt_sdt.getText() ;
        String matKhau = txt_matkhau.getText() ;
        String gioiTinh = "";
        if (txt_gioitinh.getSelectedItem().equals("Male")) {
            gioiTinh = "Male";
        }else if (txt_gioitinh.getSelectedItem().equals("Female")){
            gioiTinh = "Female" ;
        }
        int nhom =0 ;
        if (txt_nhom.getSelectedItem().toString().equals("Manager")) {
            nhom = 1 ;
        }else {
            nhom = 0 ;
        }
        int trangThai = 0;
        if (txt_trangthai.getSelectedItem().toString().equals("Active")) {
            trangThai = 1;
        }else {
            trangThai = 0 ;
        }
        //////////////////////////////////////////////////
//        if (maNhanVien.equals("")) {
//            JOptionPane.showMessageDialog(this,"Mã nhân viên không được để trống !");
//            return ;
//        }
//        else if (ktMaNV(maNhanVien)== true) {
//            JOptionPane.showMessageDialog(this,"Mã nhân viên đã tồn tại !");
//            return ;
//        }
        if(hoTen.equals("")) {
            JOptionPane.showMessageDialog(this,"Staff Name must not Empty !");
            return ;
        }
        else if(kiemTraTen(hoTen)==true){
            JOptionPane.showMessageDialog(this,"Staff Name must not contain digits !");
            return ;
        }
        else if(soDienThoai.equals("")) {
            JOptionPane.showMessageDialog(this,"Phone Number must not Empty !");
            return ;
        }
        else if (kiemTraSDT(txt_sdt.getText()) == true) {
            JOptionPane.showMessageDialog(this,"Phone Number is Incorrect !");
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
        else if(matKhau.equals("")) {
            JOptionPane.showMessageDialog(this,"Password must not Empty !");
            return ;
        }
        
        else{
//            NhanVien nv = new NhanVien();
//            nv.setMaNhanVien(nv.getMaNhanVien());// get ma nhan vien
            nv.setEmail(email);
            nv.setGioiTinh(gioiTinh);
            nv.setHoTen(hoTen);
            nv.setSoDienThoai(soDienThoai);
            nv.setNhom(nhom);
            nv.setTrangThai(trangThai);
            nv.setMatKhau(md5(matKhau));
            listNV.set(index, nv);
            saveFile();
            getData(listNV);
            JOptionPane.showMessageDialog(this,"Edit Successfully !");
            reset();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        String email = txt_email.getText() ;
        if (kiemTraEmail(email) == false) {
            lbl_email_error.setText("Email Invalid");
        }else{
            lbl_email_error.setText("");
        }
    }//GEN-LAST:event_txt_emailKeyPressed
    int index ;
    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        int row = tbl_nhanvien.getSelectedRow(); 
        String maNhanVien = tbl_nhanvien.getValueAt(row, 0).toString() ;
        for (int i = 0; i < listNV.size(); i++) {
            if (maNhanVien.equalsIgnoreCase(listNV.get(i).getMaNhanVien())) {
                nv = listNV.get(i) ;
                index = i ;
                break ;
            }
        }
        txt_manhanvien.setText(nv.getMaNhanVien());
        txt_manhanvien.setEnabled(false);
        txt_hoten.setText(nv.getHoTen());
        txt_email.setText(nv.getEmail());
        txt_sdt.setText(nv.getSoDienThoai());
        txt_matkhau.setText(nv.getMatKhau());
        txt_matkhau.setEnabled(false);
        if (nv.getGioiTinh().equals("Male")) {
            txt_gioitinh.setSelectedItem("Male");
        }else if(nv.getGioiTinh().equals("Female")){
            txt_gioitinh.setSelectedItem("Female");
        }
        if (nv.getNhom() == 1) {
            txt_nhom.setSelectedItem("Manager");
        }else {
            txt_nhom.setSelectedItem("Employee");
        }
        if (nv.getTrangThai()== 1) {
            txt_trangthai.setSelectedItem("Active");
        }else {
            txt_trangthai.setSelectedItem("Deactive");
        }
        btn_them.setEnabled(false);
        
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

        

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_email_error;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txt_email;
    private javax.swing.JComboBox<String> txt_gioitinh;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_manhanvien;
    private javax.swing.JPasswordField txt_matkhau;
    private javax.swing.JComboBox<String> txt_nhom;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    private javax.swing.JComboBox<String> txt_trangthai;
    // End of variables declaration//GEN-END:variables
}

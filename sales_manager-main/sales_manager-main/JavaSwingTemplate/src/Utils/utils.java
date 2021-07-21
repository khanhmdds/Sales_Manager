/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Admin
 */
public class utils {
//    public boolean kiemTraMaKhachHang(String maKH) {
//        String dinhDangMaKH = "^[^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
//        boolean ktMaKH = maKH.matches(dinhDangMaKH);
//        return ktMaKH;
//        // String dinhDangEmail nó giống như là format chuẩn cho email mình nhập vào, nếu sai cái
//        // dịnh dạng này thì là lỗi.
//        // Hàm matches dùng để xác định xem chuỗi email của mình có khớp với định dạng mình đã quy 
//        // định trước hay không. hàm này trả về true , false nên mình khởi tạo 1 biến ktEmail rồi gán
//        // cho nó. false thì báo lỗi.
//    }
    
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
}

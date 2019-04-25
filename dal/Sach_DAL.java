/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.DatSach_DTO;
import dto.Sach_DTO;
import dto.TaiKhoan_DTO;
import java.util.ArrayList;

/*
    cái file Sach_DAL này là để kết nối tới database
 */
public class Sach_DAL {

    private Sach_DAL() {
    }
    
    /*
        hàm trả về danh sách chứa các quyển sách có trong database sach
    
        Mô tả:
    
    */
    public static ArrayList<Sach_DTO> getDatabase_Sach () {
        
        return null;
    }
    
    
    /*
        hàm trả về danh sách chứa các quyển sách có trong database sachdaxoa
    
        Mô tả:
    
    */
    public static ArrayList<Sach_DTO> getDatabase_SachDaXoa () {
        
        return null;
    }
    
    
    /*
        hàm trả về danh sách chứa các quyển sách có trong database datsach
    
        Mô tả:
    
    */
    public static ArrayList<DatSach_DTO> getDatabase_DatSach () {
        
        return null;
    }
    
    
    /*
        hàm trả về danh sách chứa các tài khoản có trong database taikhoan
    
        Mô tả:
    
    */
    public static ArrayList<TaiKhoan_DTO> getDatabase_TaiKhoan () {
        
        return null;
    }
    
    
    /*
        Thêm quyển sách vào trong database
    
        Mô tả:
    
    */
    public static Boolean insertSach (Sach_DTO sach, String table) {
        
        return true;
    }
    
    
    /*
        Xóa quyển sách vào trong database
    
        Mô tả:
    
    */
    public static Boolean deleteSach (String maSach, String table) {
        
        return true;
    }
    
    
    /*
        thay đổi giá trị của quyển sách trong database sach
    
        Mô tả:
    
    */
    public static Boolean updateSach (Sach_DTO sach) {
        
        return true;
    }
    
    
    /*
        thêm 1 thông tin đặt sách vào trong database datsach
    
        Mô tả:
    
    */
    public static Boolean insertDatSach (DatSach_DTO datsach) {
        
        return true;
    }
    
    
    /*
        xóa 1 thông tin đặt sách vào trong database datsach
    
        Mô tả:
    
    */
    public static Boolean deleteDatSach (String maSach) {
        
        return true;
    }
}

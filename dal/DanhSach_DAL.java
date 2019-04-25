/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.DatSach_DTO;
import dto.Sach_DTO;
import dto.TaiKhoan_DTO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DanhSach_DAL {
    final static ArrayList<Sach_DTO> DS_SACH_DTOs = Sach_DAL.getDatabase_Sach();
    final static ArrayList<Sach_DTO> DS_SACHDAXOA_DTOs = Sach_DAL.getDatabase_SachDaXoa();
    final static ArrayList<DatSach_DTO> DS_DATSACH_DTOs = Sach_DAL.getDatabase_DatSach();
    final static ArrayList<TaiKhoan_DTO> DS_TAIKHOAN_DTOs = Sach_DAL.getDatabase_TaiKhoan();

    // không cho khởi tạo
    private DanhSach_DAL() {
    }
    
    
    /*
        kiểm tra dữ liệu của 1 quyển sách có hợp lệ hay không
        
        Mô tả: tách các phần 
                chuẩn chuỗi
                chuẩn mã
                kiểm tra mã
                kiểm tra số lượng và giá thành
                kiểm tra ngày
    ra làm các hàm khác nhau để
    tiện cho việc sử dụng lại
    
    */
    /* 
        hàm chuẩn chuỗi: hàm sẽ chuẩn hóa 1 chuỗi thành 1 chuỗi chuẩn
        Chuỗi chuẩn là chuỗi không có các khoảng trắng dư thừa, lý tự đầu tiên của mổi
        từ phải viết hoa các ký tự còn lại thì viết thường
    */
    private static String chuanChuoi (String chuoi) {
        
        return "";
    }
    
    /*
        Chuẩn mã Sách: hàm sẽ đưa 3 ký tự đầu tiên của mã sách thành in hoa và không có
        các khoảng trắng dư thừa ở đầu chuỗi và cuối chuỗi
    */
    private static String chuanMaSach (String maSach) {
        
        return "";
    }
    
    /*
        kiểm tra mã sách: hàm sẽ kiểm tra mã sách xem mã sách có hợp lệ hay không
        hợp lệ khi 3 ký tự đầu tiên là JAV và phải in hoa, phải đúng 10 ký tự
    */
    private static Boolean kiemTraMaSach(String maSach) {
        
        return true;            // đúng thì trả về true
    }
    
    /*
        kiểm tra mã đã tồn tại: nếu mã tồn tại trong danh sách sách và danh sách đã xóa
    */
    private static boolean kiemTraMaTonTai(String maSach) {
        
        return false;           // chưa tồn tại maSach thì trả về false
    }
    
    /*
        kiểm tra số lượng hoặc giá thành: hàm sẽ kiểm tra xem số lượng hoặc giá 
        thành có hợp lệ hay không
        hợp lệ khi: không âm
    */
    private static Boolean kiemTraInt(int so) {
        
        return true;            // đúng thì trả về true
    }
    
    /*
        kiểm tra ngày xem có hợp lệ hay không
        hợp lệ khi: ngày phải đúng theo chuẩn ngày quốc tế DD/mm/yyyy tức là
            không có ngày âm, tháng 2 phải 28 ngày v.v.....
            ngày nhập vào không được hơn ngày hiện tại
    */
    private static Boolean kiemTraDate(Date ngay) {
        
        return true;                // đúng thì trả về true
    }
    
    /*
        kiểm tra dữ liệu của 1 quyển sách có hợp lệ hay không
        
        Mô tả:
    
    */
    private static Boolean kiemTraTTSach(Sach_DTO sach) {
        
        return true;                // đúng thì trả về true
    }
    
    
    /*
        Thêm 1 quyển sách vào trong danh sách dsSach
    
        Mô tả:
    
    */
    public static Boolean themSach(Sach_DTO sach) {
        
        return true;                    // đúng thì trả về true
    }
    
    
    /*
        xóa 1 quyển sách trong danh sách dsSach
        Lưu ý: không được xóa trực tiếp bên trong vòng lặp
    
        Mô tả:
    
    */
    public static Boolean xoaSach(Sach_DTO sach) {
        
        return true;                    // đúng thì trả về true
    }
    
    
    /*
        sửa 1 quyển sách trong danh sách dsSach
    
        Mô tả:
    
    */
    public static Boolean suaSach(Sach_DTO sach) {
        
        return true;                    // đúng thì trả về true
    }
    
    
    /*
        kiểm tra số điện thoại
    */
    private static Boolean kiemTraSDT(String sdt) {
        
        return true;
    }
    
    /*
        kiểm tra thông tin đặt sách
        Mô tả:
    */
    private static Boolean kiemTraTTDatSach(DatSach_DTO datSach) {
        
        return true;
    }
    
    
    /*
        Thêm 1 thông tin đặt sách vào trong danh sách DS_DATSACH_DTOs
    
        Mô tả:
    
    */
    public static Boolean themDatSach(DatSach_DTO datSach) {
        
        return true;                    // đúng thì trả về true
    }
    
    
    /*
        xóa 1 thông tin đặt sách vào trong danh sách DS_DATSACH_DTOs
        Lưu ý: không được xóa trực tiếp bên trong vòng lặp
    
        Mô tả:
    
    */
    public static Boolean xoaDatSach(DatSach_DTO datSach) {
        
        return true;                    // đúng thì trả về true
    }
}

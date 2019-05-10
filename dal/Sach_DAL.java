/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.DatSach_DTO;
import dto.Sach_DTO;
import dto.TaiKhoan_DTO;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import until.DatabaseUntil;

/*
    cái file Sach_DAL này là để kết nối tới database
 */
public class Sach_DAL {

    private Sach_DAL() {
    }
    
    /*
        hàm trả về danh sách chứa các quyển sách có trong database sach
    
        Mô tả: Hàm lấy dữ liệu từ table sach trên database bỏ vào ArrayList<Sach_DTO> theo thứ
        tự cột trên phpAdmin hiển thị  
    
    */
    public static ArrayList<Sach_DTO> getDatabase_Sach () {
        ArrayList<Sach_DTO> S_DTO = new ArrayList<>();
        String sql = "SELECT * FROM  sach";
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Sach_DTO sach_DTO = new Sach_DTO();
            sach_DTO.setMaSach(rs.getString(1));
            sach_DTO.setTenSach(rs.getString(2));
            sach_DTO.setTheLoai(rs.getString(3));
            sach_DTO.setTacGia(rs.getString(4));
            sach_DTO.setNhaXuatBan(rs.getString(5));
            sach_DTO.setNgayXuatBan(rs.getDate(6));
            sach_DTO.setSoLuong(rs.getInt(7));
            sach_DTO.setGiaThanh(rs.getInt(8));
            S_DTO.add(sach_DTO);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return S_DTO;
    }
    
    
    /*
        hàm trả về danh sách chứa các quyển sách có trong database sachdaxoa
    
        Mô tả:Hàm lấy dữ liệu trong table sachdaxoa trên database bỏ vào ArrayList<Sach_DTO> 
                theo thứ tự cột trên phpAdmin hiển thị
    
    */
    public static ArrayList<Sach_DTO> getDatabase_SachDaXoa () {
        ArrayList<Sach_DTO> list_sach = new ArrayList<>();
        String sql ="SELECT * FROM sachdaxoa";
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               Sach_DTO sach_DTO = new Sach_DTO();
                sach_DTO.setMaSach(rs.getString(1));
                sach_DTO.setTenSach(rs.getString(2));
                sach_DTO.setTheLoai(rs.getString(3));
                sach_DTO.setTacGia(rs.getString(4));
                sach_DTO.setNhaXuatBan(rs.getString(5));
                sach_DTO.setNgayXuatBan(rs.getDate(6));
                sach_DTO.setSoLuong(rs.getInt(7));
                sach_DTO.setGiaThanh(rs.getInt(8));
                list_sach.add(sach_DTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_sach;
    }
    
    
    /*
        hàm trả về danh sách chứa các quyển sách có trong database datsach
    
        Mô tả:Hàm lấy dữ liệu từ table datsach trên database bỏ vào ArrayList<DatSach_DTO> theo thứ
        tự cột trên phpAdmin hiển thị
    
    */
    public static ArrayList<DatSach_DTO> getDatabase_DatSach () {
        ArrayList<DatSach_DTO> list_datsach = new ArrayList<>();
        String sql ="SELECT * FROM datsach";
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DatSach_DTO datsach_DTO = new DatSach_DTO();
                datsach_DTO.setHoTen(rs.getString(1));
                datsach_DTO.setSdt(rs.getString(2));
                datsach_DTO.setEmail(rs.getString(3));
                datsach_DTO.setMaSach(rs.getString(4));
                datsach_DTO.setTenSach(rs.getString(5));
                datsach_DTO.setSoLuong(rs.getInt(6));
                list_datsach.add(datsach_DTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_datsach;
    }
    
    
    /*
        hàm trả về danh sách chứa các tài khoản có trong database taikhoan
    
        Mô tả:
    
    */
    public static ArrayList<TaiKhoan_DTO> getDatabase_TaiKhoan () {
        ArrayList<TaiKhoan_DTO> list_taikhoan = new ArrayList<>();
        String sql ="SELECT * FROM taikhoan";
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaiKhoan_DTO tk_DTO = new TaiKhoan_DTO();
                tk_DTO.setiD(rs.getInt(1));
                tk_DTO.setUserName(rs.getString(2));
                tk_DTO.setPassWord(rs.getString(3));
                list_taikhoan.add(tk_DTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_taikhoan;
    }
    
    
    /*
        Thêm quyển sách vào trong database
    
        Mô tả:thêm 1 quyển sách vào database sach
    
    */
    public static Boolean insertSach (Sach_DTO sach, String table) {
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareCall("INSERT INTO sach(MaSach , TenSach , TheLoai , TacGia , NhaXuatBan , NgayXuatBan , SoLuong , GiaThanh)" +
                    "VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, sach.getMaSach());
            ps.setString(2, sach.getTenSach());
            ps.setString(3, sach.getTheLoai());
            ps.setString(4, sach.getTacGia());
            ps.setString(5, sach.getNhaXuatBan());
            ps.setDate(6, new Date(sach.getNgayXuatBan().getTime()));
            ps.setInt(7, sach.getSoLuong());
            ps.setInt(8, sach.getGiaThanh());
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    
    /*
        Xóa quyển sách vào trong database
    
        Mô tả:Truyền vào một cái maSach sao đó chạy câu truy vấn 
              nếu trùng mã sách thì xóa dữ liệu cuả table sach của hàng đó trên đatabase
    
    */
    public static Boolean deleteSach (String maSach, String table) {
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM "+ table + " WHERE MaSach = ?");
            ps.setString(1, maSach);
            return ps.executeUpdate() >0;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    
    /*
        thay đổi giá trị của quyển sách trong database sach
    
        Mô tả: Cập nhật lại toàn bộ  dữ liệu (trừ mã sách) của một quyển sách nếu có cung mã sách với câu truy vấn 
    
    */
    public static Boolean updateSach (Sach_DTO sach) {
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE sach SET TenSach = ? , TheLoai = ? , TacGia = ? , NhaXuatBan = ? , NgayXuatBan = ? , SoLuong = ? , GiaThanh = ? WHERE MaSach = ?");
            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getTheLoai());
            ps.setString(3, sach.getTacGia());
            ps.setString(4, sach.getNhaXuatBan());
            ps.setDate(5, new Date(sach.getNgayXuatBan().getTime()));
            ps.setInt(6, sach.getSoLuong());
            ps.setInt(7, sach.getGiaThanh());
            ps.setString(8, sach.getMaSach());
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    
    /*
        thêm 1 thông tin đặt sách vào trong database datsach
    
        Mô tả:thêm 1 khách hàng vào database đặt sách
    
    */
    public static Boolean insertDatSach (DatSach_DTO datsach) {
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO datsach(hoten , sdt , email , masach , tensach , soluong)"  +
                                                        " VALUES(?,?,?,?,?,?)");
            ps.setString(1, datsach.getHoTen());
            ps.setString(2, datsach.getSdt());
            ps.setString(3, datsach.getEmail());
            ps.setString(4, datsach.getMaSach());
            ps.setString(5, datsach.getTenSach());
            ps.setInt(6, datsach.getSoLuong());
            return  ps.executeUpdate()>0;
                    } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    
    /*
        xóa 1 thông tin đặt sách vào trong database datsach
    
        Mô tả:Truyền vào một cái maSach sao đó chạy câu truy vấn 
              nếu trùng mã sách thì xóa dữ liệu cuả table datsach của hàng đó trên đatabase
    
    */
    public static Boolean deleteDatSach (String maSach) {
        Connection conn = DatabaseUntil.connection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM sach Where MaSach = ?");
            ps.setString(1, maSach);
            return  ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}

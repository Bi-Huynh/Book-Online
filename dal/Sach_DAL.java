/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.DatSach_DTO;
import dto.Sach_DTO;
import dto.TaiKhoan_DTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import until.DatabaseUntil;

/*
    cái file Sach_DAL này là để kết nối tới database
 */
public class Sach_DAL {

    private static Connection con = null;
    private static PreparedStatement pstm = null;
    private static ResultSet rs = null;

    private Sach_DAL() {
    }

    private static PreparedStatement getPrepareStatement(String sql) throws SQLException {
        PreparedStatement pstms = null;

        con = DatabaseUntil.connection();
        pstms = con.prepareStatement(sql);

        return pstms;
    }

    /*
        hàm trả về danh sách chứa các quyển sách có trong database sach
    
        Mô tả:
    
     */
    public static ArrayList<Sach_DTO> getDatabase_Sach() {
        ArrayList<Sach_DTO> dsSach = new ArrayList<>();

        String sql = "select * from sach";

        try {
            pstm = getPrepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Sach_DTO sach = new Sach_DTO(
                        rs.getString("MaSach"),
                        rs.getString("TenSach"),
                        rs.getString("TheLoai"),
                        rs.getString("TacGia"),
                        rs.getString("NhaXuatBan"),
                        rs.getDate("NgayXuatBan"),
                        rs.getInt("SoLuong"),
                        rs.getInt("GiaThanh")
                );
                dsSach.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
            DatabaseUntil.close(rs);
        }

        return dsSach;
    }

    /*
        hàm trả về danh sách chứa các quyển sách có trong database sachdaxoa
    
        Mô tả:
    
     */
    public static ArrayList<Sach_DTO> getDatabase_SachDaXoa() {
        ArrayList<Sach_DTO> dsSach = new ArrayList<>();

        String sql = "select * from sachdaxoa";

        try {
            pstm = getPrepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Sach_DTO sach = new Sach_DTO(
                        rs.getString("MaSach"),
                        rs.getString("TenSach"),
                        rs.getString("TheLoai"),
                        rs.getString("TacGia"),
                        rs.getString("NhaXuatBan"),
                        rs.getDate("NgayXuatBan"),
                        rs.getInt("SoLuong"),
                        rs.getInt("GiaThanh")
                );
                dsSach.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
            DatabaseUntil.close(rs);
        }

        return dsSach;
    }

    /*
        hàm trả về danh sách chứa các quyển sách có trong database datsach
    
        Mô tả:
    
     */
    public static ArrayList<DatSach_DTO> getDatabase_DatSach() {
        ArrayList<DatSach_DTO> dsDatSach = new ArrayList<>();

        String sql = "select * from datsach";

        try {
            pstm = getPrepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                DatSach_DTO datsach = new DatSach_DTO(
                        rs.getString("HoTen"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getString("MaSach"),
                        rs.getString("TenSach"),
                        rs.getInt("SoLuong")
                );
                dsDatSach.add(datsach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
            DatabaseUntil.close(rs);
        }

        return dsDatSach;
    }

    /*
        hàm trả về danh sách chứa các tài khoản có trong database taikhoan
    
        Mô tả:
    
     */
    public static ArrayList<TaiKhoan_DTO> getDatabase_TaiKhoan() {
        ArrayList<TaiKhoan_DTO> dsTaiKhoan = new ArrayList<>();

        String sql = "select * from taikhoan";

        try {
            pstm = getPrepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TaiKhoan_DTO taikhoan = new TaiKhoan_DTO(
                        rs.getInt("ID"),
                        rs.getString("UserName"),
                        rs.getString("PassWord")
                );
                dsTaiKhoan.add(taikhoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
            DatabaseUntil.close(rs);
        }

        return dsTaiKhoan;
    }

    /*
        Thêm quyển sách vào trong database
    
        Mô tả:
    
     */
    public static Boolean insertSach(Sach_DTO sach, String table) {
        String sql = "insert into " + table + " values(?,?,?,?,?,?,?,?)";

        try {
            pstm = getPrepareStatement(sql);

            pstm.setString(1, sach.getMaSach());
            pstm.setString(2, sach.getTenSach());
            pstm.setString(3, sach.getTheLoai());
            pstm.setString(4, sach.getTacGia());
            pstm.setString(5, sach.getNhaXuatBan());
            pstm.setDate(6, (Date)sach.getNgayXuatBan());
            pstm.setInt(7, sach.getSoLuong());
            pstm.setInt(8, sach.getGiaThanh());

            if (pstm.executeUpdate() == 0) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
        }
        return true;
    }

    /*
        Xóa quyển sách vào trong database
    
        Mô tả:
    
     */
    public static Boolean deleteSach(String maSach, String table) {
        String sql = "delete from " + table + " where MaSach = ?";

        try {
            pstm = getPrepareStatement(sql);

            pstm.setString(1, maSach);

            if (pstm.executeUpdate() == 0) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
        }
        return true;
    }

    /*
        thay đổi giá trị của quyển sách trong database sach
    
        Mô tả:
    
     */
    public static Boolean updateSach(Sach_DTO sach) {
        String sql = "update sach set"
                + " TenSach = ?, TheLoai = ?,"
                + " TacGia = ?, NhaXuatBan = ?,"
                + " NgayXuatBan = ?, SoLuong = ?,"
                + " GiaThanh = ? where MaSach = ?";

        try {
            pstm = getPrepareStatement(sql);

            pstm.setString(1, sach.getTenSach());
            pstm.setString(2, sach.getTheLoai());
            pstm.setString(3, sach.getTacGia());
            pstm.setString(4, sach.getNhaXuatBan());
            pstm.setDate(5, (Date)sach.getNgayXuatBan());
            pstm.setInt(6, sach.getSoLuong());
            pstm.setInt(7, sach.getGiaThanh());
            pstm.setString(8, sach.getMaSach());

            if (pstm.executeUpdate() == 0) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
        }
        return true;
    }

    /*
        thêm 1 thông tin đặt sách vào trong database datsach
    
        Mô tả:
    
     */
    public static Boolean insertDatSach(DatSach_DTO datsach) {
        String sql = "insert into datsach values(?,?,?,?,?,?)";

        try {
            pstm = getPrepareStatement(sql);

            pstm.setString(1, datsach.getHoTen());
            pstm.setString(2, datsach.getSdt());
            pstm.setString(3, datsach.getEmail());
            pstm.setString(4, datsach.getMaSach());
            pstm.setString(5, datsach.getTenSach());
            pstm.setInt(6, datsach.getSoLuong());

            if (pstm.executeUpdate() == 0) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
        }
        return true;
    }

    /*
        xóa 1 thông tin đặt sách vào trong database datsach
    
        Mô tả:
    
     */
    public static Boolean deleteDatSach(String maSach) {
        String sql = "delete from datsach where MaSach = ?";

        try {
            pstm = getPrepareStatement(sql);

            pstm.setString(1, maSach);

            if (pstm.executeUpdate() == 0) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
        }
        return true;
    }
    
    public static Boolean deleteAllDatSach () {
        String sql = "delete from datsach";
        try {
            pstm = getPrepareStatement(sql);
            
            if (pstm.executeUpdate() == 0) {
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
        }
        
        return true;
    }
    
    public static Boolean deleteSachDaXoa() {
        String sql = "delete from sachdaxoa";
        
        try {
            pstm = getPrepareStatement(sql);
            
            if (pstm.executeUpdate() == 0) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseUntil.close(con);
            DatabaseUntil.close(pstm);
        }
        
        return true;
    }
}

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
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DanhSach_DAL {

    private final static ArrayList<Sach_DTO> getDS_SACH_DTOs = Sach_DAL.getDatabase_Sach();
    private final static ArrayList<Sach_DTO> DS_SACHDAXOA_DTOs = Sach_DAL.getDatabase_SachDaXoa();
    private final static ArrayList<DatSach_DTO> DS_DATSACH_DTOs = Sach_DAL.getDatabase_DatSach();
    private final static ArrayList<TaiKhoan_DTO> DS_TAIKHOAN_DTOs = Sach_DAL.getDatabase_TaiKhoan();

    public static ArrayList<Sach_DTO> getGetDS_SACH_DTOs() {
        return getDS_SACH_DTOs;
    }

    public static ArrayList<Sach_DTO> getDS_SACHDAXOA_DTOs() {
        return DS_SACHDAXOA_DTOs;
    }

    public static ArrayList<DatSach_DTO> getDS_DATSACH_DTOs() {
        return DS_DATSACH_DTOs;
    }

    public static ArrayList<TaiKhoan_DTO> getDS_TAIKHOAN_DTOs() {
        return DS_TAIKHOAN_DTOs;
    }
    
    

    // không cho khởi tạo
    private DanhSach_DAL() {
    }

    /*
        hàm kiểm tra thông tin tài khoàn đưa vào có hợp lệ hay không
        Mô tả:
        
     */
    public static Boolean kiemTraTaiKhoan(String userName, String passWord) {
        for (TaiKhoan_DTO tk : DS_TAIKHOAN_DTOs) {
            if (tk.getUserName().equals(userName) && tk.getPassWord().equals(passWord)) {
                return true;
            }
        }
        return false;
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
    private static String chuanChuoi(String chuoi) {
        String result = "";

        chuoi = chuoi.toLowerCase();        // chuyển toàn bộ về ký tự thường
        String[] arr = chuoi.split(" ");    // cắt mỗi chữ ra và đưa nó vào mảng String
        for (String temp : arr) {
            if (!temp.equals("") && !temp.equals(null)) {       // nếu chuỗi rỗng hoặc null thì bỏ qua
                /* 
                    đưa ký tự đầu tiên của mỗi temp thành ký tự in hoa
                    rồi cộng các ký tự còn lại vào 
                 */
                result += String.valueOf(temp.charAt(0)).toUpperCase()
                        + temp.substring(1) + " ";
            }
        }

        return result.trim();       // trim: nó sẽ loại bỏ các khoảng trống dư thừa ở đầu và cuối chuỗi
    }

    /*
        Chuẩn mã Sách
        
        Mô tả: hàm sẽ đưa 3 ký tự đầu tiên của mã sách thành in hoa
     */
    private static String chuanMaSach(String maSach) {
        String result = "";

        /*
            đưa 3 ký tự đầu tiên trong mã sách thành in hoa rồi cộng thêm chuỗi đằng sau vào
         */
        result += String.valueOf(maSach.substring(0, 3)).toUpperCase()
                + maSach.substring(3);

        return result.trim();
    }

    /*
        kiểm tra mã sách: hàm sẽ kiểm tra mã sách xem mã sách có hợp lệ hay không
        hợp lệ khi 3 ký tự đầu tiên là JAV và phải in hoa, phải đúng 10 ký tự
        hợp lệ khi mã sách này không tồn tại trong danh sách sách và danh sách
        sách đã xóa
     */
    private static Boolean kiemTraMaSach(String maSach) {
        // đúng thì trả về true
        return !(!maSach.substring(0, 3).equals("JAV") || maSach.length() != 10);
    }

    /*
        kiểm tra mã đã tồn tại: nếu mã tồn tại trong danh sách sách và danh sách đã xóa
     */
    private static Boolean kiemTraMaTonTai(String maSach) {
        for (Sach_DTO sach : getDS_SACH_DTOs) {
            if (sach.getMaSach().equals(maSach)) {
                return true;
            }
        }
        for (Sach_DTO sach : DS_SACHDAXOA_DTOs) {
            if (sach.getMaSach().equals(maSach)) {
                return true;
            }
        }
        return false;
    }

    /*
        kiểm tra số lượng hoặc giá thành: hàm sẽ kiểm tra xem số lượng hoặc giá 
        thành có hợp lệ hay không
        hợp lệ khi: không âm
     */
    private static Boolean kiemTraInt(int so) {
        if (so < 0) {
            return false;
        }
        return true;            // đúng thì trả về true
    }

    /*
        kiểm tra ngày xem có hợp lệ hay không
        hợp lệ khi: ngày phải đúng theo chuẩn ngày quốc tế DD/mm/yyyy tức là
            không có ngày âm, tháng 2 phải 28 ngày v.v.....
            ngày nhập vào không được hơn ngày hiện tại
     */
    private static Boolean kiemTraDate(Date ngay) {
        // không cần phải kiểm tra ngày có hợp lệ hay không vì ngày được nhập trên
        // giao diện đã theo ngày chuẩn rồi nên không cần phải kiểm tra, chỉ kiểm
        // tra ngày nhập vào có lớn hơn ngày hiện tại hay không thôi

        Date datenow = new Date(System.currentTimeMillis());
        if (datenow.compareTo(ngay) < 0) {      // ngày hiện tại bé hơn ngày nhập váo
            return false;
        }
        return true;                // đúng thì trả về true
    }

    /*
        kiểm tra dữ liệu của 1 quyển sách có hợp lệ hay không
        
        Mô tả:
    
     */
    public static Boolean kiemTraTTSach(Sach_DTO sach) {
        String maSach = chuanMaSach(sach.getMaSach());
        String tenSach = chuanChuoi(sach.getTenSach());
        String theLoai = chuanChuoi(sach.getTheLoai());
        String tacGia = chuanChuoi(sach.getTacGia());
        String nhaXB = chuanChuoi(sach.getNhaXuatBan());
        Date ngayXB = sach.getNgayXuatBan();
        int soLuong = sach.getSoLuong();
        int giaThanh = sach.getGiaThanh();

        if (!kiemTraMaSach(maSach)
                || !kiemTraDate(ngayXB)
                || !kiemTraInt(soLuong)
                || !kiemTraInt(giaThanh)) {
            return false;
        }

        return true;
    }

    /*
        Thêm 1 quyển sách vào trong danh sách getDS_SACH_DTOs
    
        Mô tả:
        kiểm tra thông tin sách đưa vào có đúng hay không
        đúng thì chuyển mã sách của sách đưa vào sang dạng chuẩn của mã
        rồi đem mã đó đi kiểm tra trong danh sach sách xem mã đó đã có chưa
        nếu chưa có thì chuyển toàn bộ giá trị đưa vô sang dạng chuẩn rồi đưa nó
        vào 1 quyển sách, sau đó thêm quyển sách đó vào trong danh sách sách
        rồi thêm vào trong database sach luôn
     */
    public static Boolean themSach(Sach_DTO sach) {

        if (!kiemTraTTSach(sach)) {
            return false;
        }
        String maSach = chuanMaSach(sach.getMaSach());
        if (!kiemTraMaTonTai(maSach)) {
            return false;
        }

        Sach_DTO sachChuan = new Sach_DTO(
                maSach,
                chuanChuoi(sach.getTenSach()),
                chuanChuoi(sach.getTheLoai()),
                chuanChuoi(sach.getTacGia()),
                chuanChuoi(sach.getNhaXuatBan()),
                sach.getNgayXuatBan(),
                sach.getSoLuong(),
                sach.getGiaThanh()
        );

        getDS_SACH_DTOs.add(sachChuan);
        Sach_DAL.insertSach(sachChuan, "sach");
        return true;
    }

    /*
        xóa 1 quyển sách trong danh sách dsSach
    
        Mô tả: đưa mã sách được đưa vào thành dạng chuẩn, sau đó duyệt danh sách
        lấy ra quyển sách có cùng mã, thêm quyển sách đó vô danh sách đã xóa và
        database sachdaxoa, sau đó ta mới xóa sách đó trong database sach và xóa
        trong danh sách sách
    
     */
    public static Boolean xoaSach(String maSach) {
        String ma = chuanMaSach(maSach);
        Sach_DTO sach = null;
        boolean flag = false;
        for (Sach_DTO s : getDS_SACH_DTOs) {
            if (s.getMaSach().equals(ma)) {
                sach = s;
                flag = true;
                break;
            }
        }
        if (!flag) {        // không tìm thấy sách có mã đã nhập
            return false;
        }
        DS_SACHDAXOA_DTOs.add(sach);
        Sach_DAL.insertSach(sach, "sachdaxoa");
        Sach_DAL.deleteSach(ma, "sach");
        getDS_SACH_DTOs.remove(sach);
        return true;                    // đúng thì trả về true
    }

    /*
        sửa 1 quyển sách trong danh sách dsSach
    
        Mô tả: kiểm tra xem thông tin sách đưa vào có hợp lệ hay không
        vì mã sách không thể sửa nên không cần phải kiểm tra mã sách có tồn tại
        trong danh sách hay chưa, duyệt danh sách và tìm quyển sách có mã sách
        giống với quyển sách được sửa thông tin và gán lại giá trị cho quyển sách
        đó
    
     */
    public static Boolean suaSach(Sach_DTO sach) {
        if (!kiemTraTTSach(sach)) {
            return false;
        }

        for (Sach_DTO s : getDS_SACH_DTOs) {
            if (s.getMaSach().equals(sach.getMaSach())) {
                s.setTenSach(chuanChuoi(sach.getTenSach()));
                s.setTheLoai(chuanChuoi(sach.getTheLoai()));
                s.setTacGia(chuanChuoi(sach.getTacGia()));
                s.setNhaXuatBan(chuanChuoi(sach.getNhaXuatBan()));
                s.setNgayXuatBan(sach.getNgayXuatBan());
                s.setSoLuong(sach.getSoLuong());
                s.setGiaThanh(sach.getGiaThanh());
                break;
            }
        }
        Sach_DAL.updateSach(sach);
        return true;                    // đúng thì trả về true
    }

    /*
        kiểm tra số điện thoại: số điện thoại phải là 10 số và các ký tự phải là số
     */
    private static Boolean kiemTraSDT(String sdt) {
        if (sdt.length() != 10) {
            return false;
        }
        try {
            int sdtInt = Integer.parseInt(sdt);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /*
        kiểm tra thông tin đặt sách: kiểm tra các thông tin đưa vào có hợp lệ với
        hay không như mã sách, số điện thoại có hợp lệ hay không, số lượng có âm
        hay không
     */
    private static Boolean kiemTraTTDatSach(DatSach_DTO datSach) {

        if (!kiemTraSDT(datSach.getSdt())) {
            return false;
        }
        if (!kiemTraMaSach(chuanMaSach(datSach.getMaSach()))) {
            return false;
        }
        if (!kiemTraInt(datSach.getSoLuong())) {
            return false;
        }
        return true;
    }

    /*
        Thêm 1 thông tin đặt sách vào trong danh sách DS_DATSACH_DTOs
        Mô tả: kiểm tra thông tin thêm vào có hợp lệ hay không, 
    
     */
    public static Boolean themDatSach(DatSach_DTO datSach) {
        if (!kiemTraTTDatSach(datSach)) {
            return false;
        }

        DatSach_DTO datSach_DTO = new DatSach_DTO(
                chuanChuoi(datSach.getHoTen()),
                datSach.getSdt(),
                chuanChuoi(datSach.getEmail()),
                chuanMaSach(datSach.getMaSach()),
                chuanChuoi(datSach.getTenSach()),
                datSach.getSoLuong()
        );

        DS_DATSACH_DTOs.add(datSach_DTO);
        Sach_DAL.insertDatSach(datSach_DTO);
        return true;                    // đúng thì trả về true
    }

    /*
        xóa 1 thông tin đặt sách vào trong danh sách DS_DATSACH_DTOs
    
        Mô tả:
    
     */
    public static Boolean xoaDatSach(DatSach_DTO datSach) {
        if (!kiemTraTTDatSach(datSach)) {
            return false;
        }
        DS_DATSACH_DTOs.remove(datSach);
        Sach_DAL.deleteDatSach(datSach.getMaSach());
        return true;                    // đúng thì trả về true
    }

    /*
        xóa toàn bộ danh sách đặt sách
     */
    public static void xoaAll_DatSach() {
        DS_DATSACH_DTOs.clear();
        if (!Sach_DAL.deleteAllDatSach()) {
            JOptionPane.showMessageDialog(null, "Xóa không thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }
    }
    
    /*
        xóa 1 thông tin đặt sách vào trong danh sách DS_DATSACH_DTOs
    
        Mô tả:
    
     */
    public static Boolean xoaSachDaXoa(Sach_DTO sach) {
        
        DS_DATSACH_DTOs.remove(sach);
        Sach_DAL.deleteSach(sach.getMaSach(), "sachdaxoa");
        return true;                    // đúng thì trả về true
    }

    /*
        xóa toàn bộ danh sách đặt sách
     */
    public static void xoaAll_SachDaXoa() {
        DS_DATSACH_DTOs.clear();
        if (!Sach_DAL.deleteSachDaXoa()) {
            JOptionPane.showMessageDialog(null, "Xóa không thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }
    }

    /*
        Đức viết: hàm bổ trợ cho việc tìm kiếm
    
        hàm trả về 1 quyển sách có dựa vào mã sách
        Mô tả: hàm sẽ chuẩn hóa lại mã sách cho đúng chuẩn rồi đem đi so sách với
        các quyển sách nếu trùng mã thì trả quyển sách đó về, nếu không có mã nào
        trùng thì sẽ trả về null
     */
    public static Sach_DTO getSach_MaSach(String maSach) {
        Sach_DTO sach = null;
        String maString = chuanMaSach(maSach);
        Boolean flag = false;

        for (Sach_DTO s : getDS_SACH_DTOs) {
            if (s.getMaSach().equals(maString)) {
                sach = s;
                flag = true;
                break;
            }
        }

        if (flag == false) {
            return null;
        }

        return sach;
    }

    /*
        Đức viết: hàm bổ trợ cho việc tìm kiếm
    
        hàm trả về 1 quyển sách có dựa vào tên sách
        Mô tả: hàm sẽ chuẩn hóa lại tên sách cho đúng chuẩn rồi đem đi so sách với
        các quyển sách nếu trùng tên sách thì trả quyển sách đó về, nếu không có
        quyển nào thì trả về null
     */
    public static Sach_DTO getSach_TenSach(String tenSach) {
        Sach_DTO sach = null;
        tenSach = chuanChuoi(tenSach);

        for (Sach_DTO s : getDS_SACH_DTOs) {
            if (s.getTenSach().equals(tenSach)) {
                // nếu sách được gán bằng null thì chứng tỏ là không có sách
                sach = getSach_MaSach(s.getMaSach());
            }
        }
        return sach;
    }

    /*
        Đức viết: hàm bổ trợ cho việc tìm kiếm
    
        hàm trả về 1 quyển sách có dựa vào tên sách
        Mô tả: hàm sẽ chuẩn hóa lại tên sách cho đúng chuẩn rồi đem đi so sách với
        các quyển sách nếu trùng tên sách thì trả quyển sách đó về, nếu không có
        quyển nào thì trả về null
     */
    public static Sach_DTO getSach_TacGia(String tacGia) {
        Sach_DTO sach = null;
        tacGia = chuanChuoi(tacGia);

        for (Sach_DTO s : getDS_SACH_DTOs) {
            if (s.getTacGia().equals(tacGia)) {
                // nếu sách được gán bằng null thì chứng tỏ là không có sách
                sach = getSach_MaSach(s.getMaSach());
            }
        }
        return sach;
    }
}

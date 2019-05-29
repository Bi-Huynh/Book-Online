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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class DanhSach_DAL {
    private final static ArrayList<Sach_DTO> DS_SACH_DTOs = Sach_DAL.getDatabase_Sach();
    private final static ArrayList<Sach_DTO> DS_SACHDAXOA_DTOs = Sach_DAL.getDatabase_SachDaXoa();
    private final static ArrayList<DatSach_DTO> DS_DATSACH_DTOs = Sach_DAL.getDatabase_DatSach();
    private final static ArrayList<TaiKhoan_DTO> DS_TAIKHOAN_DTOs = Sach_DAL.getDatabase_TaiKhoan();

    public static ArrayList<Sach_DTO> getDS_SACH_DTOs() {
        return DS_SACH_DTOs;
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
    public static Boolean kiemTraTaiKhoan (String userName, String passWord) {
        
        
        
        for(TaiKhoan_DTO tk :DS_TAIKHOAN_DTOs)//duyệt danh sách tài khoản
        {
            if(tk.getUserName().equals(userName)&&tk.getPassWord().equals(passWord))//so sánh tài khoản và mật khẩu
            {
                return true;//->true tài khoản hợp lệ có thể đăng nhập vào hệ thống
            }
        }
        return false;//->false tài khoản không hợp lệ
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
        
        chuoi=chuoi.trim();//hàm hỗ trợ xóa bỏ đi các khoảng trắng dư thừa
        while (chuoi.contains("  ")) chuoi = chuoi.replaceAll("  "," ");//cách 1
        //s.replaceAll(s1,s2) : phương thức thay thế tất cả chuỗi s1 thành s2 trong s.
        //nhưng chỉ duyệt chuỗi s 1 lần. Vì vậy ta cần kết hợp cả vòng while để có thể thay thế tất cả.
        //chuoi = chuoi.replaceAll("\\s+", " ");//cách 2
        String temp[] = chuoi.split(" ");//split tách xâu thành mãng các từ
        chuoi = ""; // khởi tại chuỗi băng rỗng
        for (int i = 0; i < temp.length; i++) {
            chuoi += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) // ? ^-^
                chuoi += " ";
        }
        return chuoi;
    }
    
    /*
        Chuẩn mã Sách: hàm sẽ đưa 3 ký tự đầu tiên của mã sách thành in hoa và không có
        các khoảng trắng dư thừa ở đầu chuỗi và cuối chuỗi
    */
    private static String chuanMaSach (String maSach) {
        maSach=maSach.trim();//hàm hỗ trợ xóa bỏ đi các khoảng trắng dư thừa
        while (maSach.contains("  ")) maSach = maSach.replaceAll("  "," ");//cách 1
        //s.replaceAll(s1,s2) : phương thức thay thế tất cả chuỗi s1 thành s2 trong s.
        //nhưng chỉ duyệt chuỗi s 1 lần. Vì vậy ta cần kết hợp cả vòng while để có thể thay thế tất cả.
        //chuoi = chuoi.replaceAll("\\s+", " ");//cách 2
        String temp[] = maSach.split(" ");//split tách xâu thành mãng các từ
        maSach = ""; // khởi tại chuỗi băng rỗng
        int j=0;
        for (String temp1 : temp) {
            if (j<3) {
                maSach += temp1.toUpperCase(); //in Hoa 3 chữ cái đầu lên
                j=j+1;
            } else {
                maSach += temp1.substring(1); //cộng nối theo những kí tự tiếp theo
            }
        }
        return maSach;//trả về 1 chuỗi ABCxxxxxxx
    }
    
    /*
        kiểm tra mã sách: hàm sẽ kiểm tra mã sách xem mã sách có hợp lệ hay không
        hợp lệ khi 3 ký tự đầu tiên là JAV và phải in hoa, phải đúng 10 ký tự
    */
    private static Boolean kiemTraMaSach(String maSach) {
        if(maSach.length()<10||maSach.length()>10)
        {
            return false;
        }
        else if(maSach.length()==10)//mã sách chính xác bằng 10 ký tự
        {
            String temp[] = maSach.split(" ");//cắt chuỗi ra thành mảng
            if(!temp[0].equals('J')||temp[1].equals('A')||temp[2].equals('V'));//nếu nó khác thì trả về false
            {
                return false;
            }
        }
        return true;            // đúng thì trả về true
    }
    
    /*
        kiểm tra mã đã tồn tại: nếu mã tồn tại trong danh sách sách và danh sách đã xóa
    */
    private static boolean kiemTraMaTonTai(String maSach) {
        for(Sach_DTO sach1 :DS_SACH_DTOs)//duyệt từng cuốn sách trong danh sách sách
        {
            for(Sach_DTO sach2:DS_SACHDAXOA_DTOs)//duyệt sách trong danh sách sách đã xóa
                if(sach1.getMaSach().equals(maSach)||sach2.getMaSach().equals(maSach))//so sánh mã sách trong các danh sách với mã sách truyền vào
                {
                    return true;//sách đã tồn tại trong danh sách
                }
        }
        return false;            // chưa có mã sách trong danh sách có thể thêm 
        
    }
    //ha
    /*
        kiểm tra số lượng hoặc giá thành: hàm sẽ kiểm tra xem ố lượng hoặc giá 
        thành có hợp lệ hay khôngs
        hợp lệ khi: không âm
    */
    private static Boolean kiemTraInt(int so) {
        Sach_DTO sach=new Sach_DTO();
        for(int i=0;i<DS_SACH_DTOs.size();i++)
        {
            if(sach.getGiaThanh()<=0||sach.getSoLuong()<=0)//kiểm tra xem số lượng hay giá sản phẩm có bị âm (<0) hay không
            {
                return true;//tìm ra dc sách có số lượng hoặc giá thành <0
            }
        }
        return false;           //không có sách nào vi pham điều kiện số lượng hoặc giá thành âm
    }
    
    /*
        kiểm tra ngày xem có hợp lệ hay không
        hợp lệ khi: ngày phải đúng theo chuẩn ngày quốc tế DD/mm/yyyy tức là
            không có ngày âm, tháng 2 phải 28 ngày v.v.....
            ngày nhập vào không được hơn ngày hiện tại
    */
    private static boolean kiemTraDate(Date ngay) {
        java.util.Date today=new java.util.Date();  //lay ngày hiện tại
        if(ngay.after(today))//so sánh ngày nhập vào và ngày hiện tại <date1>.after(date2) cái hàm này so sánh ngày 1 trước(bé hơn) ngày 2
        {
                return true;//nếu nó bé hơn là n hợp lệ nên n trả về true
        }
        return false;//còn nó lớn hơn ngày hiện tại là trả về false
    }
    
    
    /*
        kiểm tra dữ liệu của 1 quyển sách có hợp lệ hay không
        
        Mô tả:
    
    */
    private static Boolean kiemTraTTSach(Sach_DTO sach) {
        String ma=sach.getMaSach();
        String ten=sach.getTenSach();
        String theloai=sach.getTheLoai();
        String tacgia=sach.getTacGia();
        String nxb=sach.getNhaXuatBan();
        Date ngay=sach.getNgayXuatBan();
        int gia=sach.getGiaThanh();
        int sl=sach.getSoLuong();
        //sử dụng lại một số hàm hỗ trợ như hàm kiểm tra mã sách hàm kiểm tra thời gian
        if(kiemTraMaSach(ma)==true&&kiemTraDate(ngay)==true&&kiemTraInt(gia)==false&&kiemTraInt(sl)==false&&ten==null&&theloai==null&&nxb==null)
        {
            return true;//tất cả các dư liệu điều có và đã được kiểm tra bởi các hàm
        }
        return false;//có sai sót về 1 cuốn sách bị thiếu dữ liệu
    }
    
    
    /*
        Thêm 1 quyển sách vào trong danh sách dsSach
    
        Mô tả:
    
    */
    public static Boolean themSach(Sach_DTO sach) {
        
        DS_SACH_DTOs.add(sach); //thêm một cuốn sách vào danh sách Sách
        return true;                    // đúng thì trả về true
    }
    
    
    /*
        xóa 1 quyển sách trong danh sách dsSach
        Lưu ý: không được xóa trực tiếp bên trong vòng lặp
    
        Mô tả:
    
    */
    public static Boolean xoaSach( Sach_DTO sach) {
        ;
        boolean remove = DS_SACH_DTOs.remove(sach);//cái này không biết làm đại
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
    private static Boolean kiemTraSDT(String sdt) {//Hàm này copy trên mạng nên k rõ
        Pattern pattern=Pattern.compile("^[0-9]*$");
        Matcher matcher=pattern.matcher(sdt);
        if(!matcher.matches())
        {
            return false;//chuỗi đầu vào không phải là số
        }
        else
        {
            if(sdt.length()==10||sdt.length()==11)//kiểm tra độ dài
            {
                return true;
                //if(sdt.substring(0, 2).equals("09"))//ràng buộc nhập vào đầu số phải là 09
                //{
                //return true;
                //}
                //else 
                // return false;
                //phần này trên mạng hỗ trợ thêm kiểm tra đầu số hợp lệ
            }
            else
            {
                return false;
            }
        }
    }
    
    /*
        kiểm tra thông tin đặt sách
        Mô tả:
    */
    private static Boolean kiemTraTTDatSach(DatSach_DTO datSach) {
        if(datSach.getHoTen()==null||datSach.getEmail()==null||datSach.getMaSach()==null||datSach.getSoLuong()<=0||datSach.getMaSach()==null||datSach.getSdt()==null)
        // câu lênh if trên kiểm tra thông tin đặt sách có bị rổng phần nào không hoặc sai số lượng bị âm thì sẽ trả về flase
        {
            return false;
        }
        return true;// thông tin đặt sách không bị bỏ trống và số lượng lớn hơn 0
    }
    
    
    /*
        Thêm 1 thông tin đặt sách vào trong danh sách DS_DATSACH_DTOs
    
        Mô tả:
    
    */
    public static Boolean themDatSach(DatSach_DTO datSach) {
        boolean add = DS_DATSACH_DTOs.add(datSach);//cái này không biết làm đại
        return true;                    // đúng thì trả về true
    }
    
    
    /*
        xóa 1 thông tin đặt sách vào trong danh sách DS_DATSACH_DTOs
        Lưu ý: không được xóa trực tiếp bên trong vòng lặp
    
        Mô tả:
    
    */
    public static Boolean xoaDatSach(DatSach_DTO datSach) {
        boolean remove = DS_DATSACH_DTOs.remove(datSach); //cái này không biết làm đại
        return true;                    // đúng thì trả về true
    }
    
    /*
        Đức viết: hàm bổ trợ cho việc tìm kiếm
    
        hàm trả về 1 quyển sách có dựa vào mã sách
        Mô tả: hàm sẽ chuẩn hóa lại mã sách cho đúng chuẩn rồi đem đi so sách với
        các quyển sách nếu trùng mã thì trả quyển sách đó về, nếu không có mã nào
        trùng thì sẽ trả về null
    */
    public static Sach_DTO getSach_MaSach (String maSach) {
        Sach_DTO sach = null;
        String maString = chuanMaSach(maSach);
        
        if (!kiemTraMaSach(maSach)) {
            return sach;            // tại đây sách hiện tại là null
        }
        
        Boolean flag = false;
        
        for (Sach_DTO s : DS_SACH_DTOs) {
            if (s.getMaSach().equals(maString)) {
                sach = s;
                flag = true;
                break;
            }
        }
        
        if (flag == false) {
            return sach;            // tại đây sách hiện tại là null
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
    public static Sach_DTO getSach_TenSach (String tenSach) {
        Sach_DTO sach = null;
        tenSach = chuanChuoi(tenSach);
        
        for (Sach_DTO s : DS_SACH_DTOs) {
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
    public static Sach_DTO getSach_TacGia (String tacGia) {
        Sach_DTO sach = null;
        tacGia = chuanChuoi(tacGia);
        
        for (Sach_DTO s : DS_SACH_DTOs) {
            if (s.getTacGia().equals(tacGia)) {
                // nếu sách được gán bằng null thì chứng tỏ là không có sách
                sach = getSach_MaSach(s.getMaSach());
            }
        }
        return sach;
    }
}

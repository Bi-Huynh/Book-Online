/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;





/**
 *
 * @author Admin
 */
public class Sach_DTO implements Comparable<Sach_DTO>{
    private String maSach;
    private String tenSach;
    private String theLoai;
    private String tacGia;
    private String nhaXuatBan;
    private Date ngayXuatBan;
    private int soLuong;
    private int giaThanh;

    public Sach_DTO() {
    }

    public Sach_DTO(String tenSach, String theLoai, String tacGia,
            String nhaXuatBan, Date ngayXuatBan, int soLuong, int giaThanh) {
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.ngayXuatBan = ngayXuatBan;
        this.soLuong = soLuong;
        this.giaThanh = giaThanh;
    }

    public Sach_DTO(String maSach, String tenSach, String theLoai, String tacGia,
            String nhaXuatBan, Date ngayXuatBan, int soLuong, int giaThanh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.ngayXuatBan = ngayXuatBan;
        this.soLuong = soLuong;
        this.giaThanh = giaThanh;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public Date getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(int giaThanh) {
        this.giaThanh = giaThanh;
    }

    @Override
    public int compareTo(Sach_DTO sach) {
        int quantity = ((Sach_DTO) sach).getGiaThanh();     // ????? không hiểu tại sao lại ép hiểu kỳ dị
        
        // sắp xếp tăng
        return this.giaThanh - quantity;
        
        // sắp xếp giảm
        // return quantity - this.giaThanh;
    }

    @Override
    public String toString() {
        return getMaSach() + " - "
                + getTenSach()+ " - "
                + getTacGia() + " - "
                + getTheLoai()+ " - " 
                + getGiaThanh() + " - "
                + getNhaXuatBan() + " - "
                + getNgayXuatBan();
    }
    
    
}

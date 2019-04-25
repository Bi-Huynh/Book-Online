/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class DatSach_DTO {
    private String hoTen;
    private String sdt;
    private String email;
    private String maSach;
    private String tenSach;
    private int soLuong;

    public DatSach_DTO() {
        this.hoTen = "";
        this.sdt = "";
        this.email = "";
        this.maSach = "";
        this.tenSach = "";
        this.soLuong = 0;
    }

    public DatSach_DTO(String hoTen, String sdt, String email, String maSach, String tenSach, int soLuong) {
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.email = email;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}

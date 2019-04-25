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
public class TaiKhoan_DTO {
    private int iD;
    private String userName;
    private String passWord;

    public TaiKhoan_DTO() {
        this.iD = 0;
        this.userName = "";
        this.passWord = "";
    }

    public TaiKhoan_DTO(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public TaiKhoan_DTO(int iD, String userName, String passWord) {
        this.iD = iD;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}

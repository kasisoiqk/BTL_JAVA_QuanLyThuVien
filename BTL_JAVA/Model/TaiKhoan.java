/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Model;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class TaiKhoan implements Serializable{
    private int maTk;
    private String TenDangNhap;
    private String matKhau;
    private String PhanQuyen;

    public TaiKhoan() {
    }

    public TaiKhoan(int maTk, String TenDangNhap, String matKhau, String PhanQuyen) {
        this.maTk = maTk;
        this.TenDangNhap = TenDangNhap;
        this.matKhau = matKhau;
        this.PhanQuyen = PhanQuyen;
    }

    public int getMaTk() {
        return maTk;
    }

    public void setMaTk(int maTk) {
        this.maTk = maTk;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getPhanQuyen() {
        return PhanQuyen;
    }

    public void setPhanQuyen(String PhanQuyen) {
        this.PhanQuyen = PhanQuyen;
    }
    public void Nhap(){
        System.out.println("Nhap ma tai khoan ");
        this.maTk=(new Scanner(System.in)).nextInt();
        System.out.println("Nhap ten dang nhap: ");
        this.TenDangNhap = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap mat khau dang nhap: ");
        this.matKhau = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap loai tai khoan 0.Quan ly ,1.Quan tri ");
        int x = (new Scanner(System.in)).nextInt();
        if (x==0) {
            this.PhanQuyen = "Quan ly";
        }
        else
            this.PhanQuyen = "Quan tri";
    }
    public void Xuat(){
         System.out.format("|%-8d|%-12s|%-12s|%10s",maTk,TenDangNhap,matKhau,PhanQuyen);
    }
}

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
public class TaiKhoan implements Serializable, Comparable<TaiKhoan>{
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
    public void nhap(){
        System.out.print("Nhập tên đăng nhập: ");
        this.TenDangNhap = (new Scanner(System.in)).nextLine();
        System.out.print("Nhập mật khẩu: ");
        this.matKhau = (new Scanner(System.in)).nextLine();
        System.out.print("Nhập loại tài khoản: 0. Thủ thư - 1. Quản trị : ");
        int x = (new Scanner(System.in)).nextInt();
        if (x==0) {
            this.PhanQuyen = "Thu thu";
        }
        else
            this.PhanQuyen = "Quan tri";
    }
    public void xuat(){
         System.out.format("| %-8s | %-20s | %-20s | %-15s |\n","TK"+maTk,TenDangNhap,matKhau,PhanQuyen);
    }
    
    @Override
    public int compareTo(TaiKhoan o) {
        int i = this.getTenDangNhap().compareTo(o.getTenDangNhap());
        if (i > 0) {
            return 1;
        } else if ( i < 0) {
            return -1;            
        }else{
            return 0;
        }
    }
}

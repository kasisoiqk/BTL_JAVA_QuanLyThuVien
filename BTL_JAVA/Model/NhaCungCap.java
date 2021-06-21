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
 * @author BENH VIEN CONG NGHE
 */
public class NhaCungCap implements Serializable{
    private int MaNhaCungCap;
    private String TenNhaCungCap;
    private String DiaChi;
    private String sdtncc;
    private String emailncc;
    public NhaCungCap() {
    }

    public NhaCungCap(int MaNhaCungCap, String TenNhaCungCap, String DiaChi, String sdtncc, String emailncc) {
        this.MaNhaCungCap = MaNhaCungCap;
        this.TenNhaCungCap = TenNhaCungCap;
        this.DiaChi = DiaChi;
        this.sdtncc = sdtncc;
        this.emailncc = emailncc;
    }
    
    public int getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(int MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public void setTenNhaCungCap(String TenNhaCungCap) {
        this.TenNhaCungCap = TenNhaCungCap;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdtncc() {
        return sdtncc;
    }

    public void setSdtncc(String sdtncc) {
        this.sdtncc = sdtncc;
    }

    public String getEmailncc() {
        return emailncc;
    }

    public void setEmailncc(String emailncc) {
        this.emailncc = emailncc;
    }
    public void nhap()
    {
        System.out.println("Nhap ma nha cung cap: ");
        this.MaNhaCungCap = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap ten nha cung cap: ");
        this.TenNhaCungCap = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap dia chi: ");
        this.DiaChi = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap so dien thoai nha cung cap: ");
        this.sdtncc = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap email nha cung cap: ");
        this.emailncc = (new Scanner(System.in)).nextLine();
    }
    public void xuat() {
        System.out.format("| %-8s | %-25s | %-25s | %-20s | %-20s" , 
                MaNhaCungCap, TenNhaCungCap, DiaChi, sdtncc, emailncc);
    }
    public static void main(String[] args) {
        NhaCungCap ncc=new NhaCungCap();
        ncc.nhap();
        ncc.xuat();
    }
}

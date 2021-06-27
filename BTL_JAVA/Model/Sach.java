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
 * @author Laptopkhanhtran.vn
 */
public class Sach implements Serializable{
    private  int maSach;
    private String tenSach;
    private String tacGia;
    private String nhaCungCap;
    private String ngayNhap;
    private int soLuongTong;
    private String theLoai;
    private int giaSach;

    public Sach() {
    }

    public Sach(int maSach, String tenSach, String tacGia, String nhaCungCap, String ngayNhap, int soLuongTong, String theLoai, int giaSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.soLuongTong = soLuongTong;
        this.theLoai = theLoai;
        this.giaSach = giaSach;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuongTong() {
        return soLuongTong;
    }

    public void setSoLuongTong(int soLuongTong) {
        this.soLuongTong = soLuongTong;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(int giaSach) {
        this.giaSach = giaSach;
    }
    public void nhap(){
        System.out.print("Nhập mã sách: ");
        maSach=new Scanner(System.in).nextInt();
        System.out.print("Nhập tên sách: ");
        tenSach=new Scanner(System.in).nextLine();
        System.out.print("Nhập tên tác giả: ");
        tacGia=new Scanner(System.in).nextLine();
        System.out.print("Nhập tên nhà cung cấp: ");
        nhaCungCap=new Scanner(System.in).nextLine();
        System.out.print("Nhập thể loại: ");
        theLoai=new Scanner(System.in).nextLine();
        System.out.print("Nhập ngày nhập sách: ");
        ngayNhap=new Scanner(System.in).nextLine();
        System.out.print("Nhập số lượng tổng: ");
        soLuongTong=new Scanner(System.in).nextInt();
        System.out.print("Nhập giá sách: ");
        giaSach=new Scanner(System.in).nextInt();
        
    }
    public void xuat(){
         System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |\n", 
                 "S" + maSach, tenSach, tacGia, nhaCungCap, theLoai, ngayNhap, soLuongTong, 
                 giaSach);
    }
    public void xuat(boolean abc){
         System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-15s |\n", 
                 "S" + maSach, tenSach, tacGia, nhaCungCap, theLoai, ngayNhap, 
                 giaSach);
    }
    
}

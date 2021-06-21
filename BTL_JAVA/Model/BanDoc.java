/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Model;

import java.util.Scanner;

/**
 *
 * @author BENH VIEN CONG NGHE
 */
public class BanDoc extends Nguoi{
    private String tenLop;
    Scanner sc= new Scanner(System.in);
    public BanDoc() {
    }

    public BanDoc(String tenLop, int ma, String ten, Date ngaySinh, String gioiTinh, String sdt, String email) {
        super(ma, ten, ngaySinh, gioiTinh, sdt, email);
        this.tenLop = tenLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap ten lop: ");
        this.tenLop = (new Scanner(System.in)).nextLine();
    }
    public void xuat() {
        super.xuat();
        System.out.format("| %-8s |",""+ tenLop);
    }
    public static void main(String[] args) {
        BanDoc bd=new BanDoc();
        bd.nhap();
        bd.xuat();
    }
}
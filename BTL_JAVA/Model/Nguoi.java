package BTL_JAVA.Model;

import java.util.Scanner;

public class Nguoi{
    private int ma;
    private String ten;
    private Date ngaySinh;
    private String gioiTinh;
    private String sdt;
    private String email;

    public Nguoi() {
        ngaySinh = new Date();
    }

    public Nguoi(int ma, String ten, Date ngaySinh, String gioiTinh, String sdt, String email) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public void nhap() {
        System.out.println("Nhap ho va ten: ");
        this.ten = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap ngay sinh: ");
        this.ngaySinh.setNgay((new Scanner(System.in)).nextInt());
        System.out.println("Nhap thang sinh: ");
        this.ngaySinh.setThang((new Scanner(System.in)).nextInt());
        System.out.println("Nhap nam sinh: ");
        this.ngaySinh.setNam((new Scanner(System.in)).nextInt());
        System.out.println("Nhap gioi tinh: 1. Nam - 0. Nu");
        int x = (new Scanner(System.in)).nextInt();
        if(x == 1) this.gioiTinh = "Nam";
        else this.gioiTinh = "Nu";
        System.out.println("Nhap so dien thoai: ");
        this.sdt = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap email: ");
        this.email = (new Scanner(System.in)).nextLine();
    }
        
    public void xuat() {
        System.out.format("| %-8s | %-25s | %-10s | %-8s | %-15s | %-20s", "PS" + 
                ma, ten, ngaySinh, gioiTinh, sdt, email);
    }
    
}

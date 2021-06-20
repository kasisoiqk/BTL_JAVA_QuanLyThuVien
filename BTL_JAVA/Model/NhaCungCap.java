package BTL_JAVA.Model;

import java.util.Scanner;

public class NhaCungCap{
    private int MaNhaCungCap;
    private String TenNhaCungCap;
    private String DiaChi;
    private int sdtncc;
    private String emailncc;
    Scanner sc= new Scanner(System.in);
    public NhaCungCap() {
    }

    public NhaCungCap(int MaNhaCungCap, String TenNhaCungCap, String DiaChi, int sdtncc, String emailncc) {
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

    public int getSdtncc() {
        return sdtncc;
    }

    public void setSdtncc(int sdtncc) {
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
        this.sdtncc = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap email nha cung cap: ");
        this.emailncc = (new Scanner(System.in)).nextLine();
    }
    public void xuat() {
        System.out.format("| %-8s | %-25s | %-25s | %-15s | %-20s", "Nha cung cap: " + 
                MaNhaCungCap, TenNhaCungCap, DiaChi, sdtncc, emailncc);
    }
}

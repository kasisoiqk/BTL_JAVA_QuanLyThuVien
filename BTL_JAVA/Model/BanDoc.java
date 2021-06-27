package BTL_JAVA.Model;

import java.io.Serializable;
import java.util.Scanner;

public class BanDoc extends Nguoi implements Serializable{
    private String tenLop;
    private String maSV;
    public BanDoc() {
    }

    public BanDoc(String tenLop, String maSV, int ma, String ten, Date ngaySinh, String gioiTinh, String sdt, String email) {
        super(ma, ten, ngaySinh, gioiTinh, sdt, email);
        this.tenLop = tenLop;
        this.maSV = maSV;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void nhap()
    {
        super.nhap();
        System.out.print("Nhập mã sinh viên: ");
        this.maSV = (new Scanner(System.in)).nextLine();
        System.out.print("Nhập tên lớp: ");
        this.tenLop = (new Scanner(System.in)).nextLine();
    }
    public void xuat() {
        System.out.format("| %-14s", this.getMaSV());
        super.xuat();
        System.out.format(" | %-15s |\n", tenLop);
    }
    public static void main(String[] args) {
        BanDoc bd=new BanDoc();
        bd.nhap();
        bd.xuat();
    }
}
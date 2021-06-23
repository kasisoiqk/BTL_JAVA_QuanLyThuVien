package BTL_JAVA.Model;

import java.util.Scanner;

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
        System.out.print("Nhập tên lớp: ");
        this.tenLop = (new Scanner(System.in)).nextLine();
    }
    public void xuat() {
        System.out.format("| %-8s","SV"+ this.getMa());
        super.xuat();
        System.out.format(" | %-15s |\n", tenLop);
    }
    public static void main(String[] args) {
        BanDoc bd=new BanDoc();
        bd.nhap();
        bd.xuat();
    }
}
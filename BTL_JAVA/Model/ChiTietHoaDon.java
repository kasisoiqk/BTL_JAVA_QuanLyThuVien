package BTL_JAVA.Model;

import java.io.Serializable;
import java.util.Scanner;

public class ChiTietHoaDon implements Serializable{
    private int maHD;
    private int maSach;
    private int gia;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maHD, int maSach, int gia) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.gia = gia;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    public void nhap() {
        System.out.print("Nhập mã hóa đơn: ");
        maHD = (new Scanner(System.in)).nextInt();
        System.out.print("Nhập mã sách: ");
        maSach = (new Scanner(System.in)).nextInt();
        System.out.print("Nhập giá: ");
        gia = (new Scanner(System.in)).nextInt();
    }
    
    public void xuat() {
        System.out.format("| %-8s | %-8s | %-15s |\n", "HD"+maHD, "S"+maSach, gia);
    }
}

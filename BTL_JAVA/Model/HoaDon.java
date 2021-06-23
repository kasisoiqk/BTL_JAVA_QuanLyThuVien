package BTL_JAVA.Model;

import java.io.Serializable;
import java.util.Scanner;

public class HoaDon implements Serializable{
    private int MaHoaDon;
    private int SoLuongSach;
    private int TongSoTien;
    private int MaBanDoc;
    private int MaThuThu;
    private Date NgayMuon;
    private Date NgayTra;

    public HoaDon() {
        NgayMuon = new Date();
        NgayTra = new Date();
    }

    public HoaDon(int MaHoaDon, int SoLuongSach, int TongSoTien, int MaBanDoc, int MaThuThu, Date NgayMuon, Date NgayTra) {
        this.MaHoaDon = MaHoaDon;
        this.SoLuongSach = SoLuongSach;
        this.TongSoTien = TongSoTien;
        this.MaBanDoc = MaBanDoc;
        this.MaThuThu = MaThuThu;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
    }
    
    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getSoLuongSach() {
        return SoLuongSach;
    }

    public void setSoLuongSach(int SoLuongSach) {
        this.SoLuongSach = SoLuongSach;
    }

    public int getTongSoTien() {
        return TongSoTien;
    }

    public void setTongSoTien(int TongSoTien) {
        this.TongSoTien = TongSoTien;
    }

    public int getMaBanDoc() {
        return MaBanDoc;
    }

    public void setMaBanDoc(int MaBanDoc) {
        this.MaBanDoc = MaBanDoc;
    }

    public int getMaThuThu() {
        return MaThuThu;
    }

    public void setMaThuThu(int MaThuThu) {
        this.MaThuThu = MaThuThu;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }
    public void nhap()
    {
        System.out.println("Nhap ma hoa don: ");
        this.MaHoaDon = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap so luong sach: ");
        this.SoLuongSach = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap tong so tien: ");
        this.TongSoTien = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap ma thu thu: ");
        this.MaThuThu = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap ma ban doc: ");
        this.MaBanDoc = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap ngay muon: ");
        this.NgayMuon.setNgay((new Scanner(System.in)).nextInt());
        System.out.println("Nhap thang muon: ");
        this.NgayMuon.setThang((new Scanner(System.in)).nextInt());
        System.out.println("Nhap nam muon");
        this.NgayMuon.setNam((new Scanner(System.in)).nextInt());
        System.out.println("Nhap ngay tra: ");
        this.NgayTra.setNgay((new Scanner(System.in)).nextInt());
        System.out.println("Nhap thang tra: ");
        this.NgayTra.setThang((new Scanner(System.in)).nextInt());
        System.out.println("Nhap nam tra: ");
        this.NgayTra.setNam((new Scanner(System.in)).nextInt());
    }
    public void xuat() {
        System.out.format("| %-8s | %-8s | %-15s | %-10s | %-10s | %-10s | %-10s |\n", "HD" + 
                MaHoaDon, SoLuongSach, TongSoTien, MaThuThu, MaBanDoc, NgayMuon, NgayTra);
    }
    public static void main(String[] args) {
        HoaDon hd =new HoaDon();
        hd.nhap();
        hd.xuat();
    }
}

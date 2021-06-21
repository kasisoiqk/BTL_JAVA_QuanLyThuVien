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
public class ChiTietHoaDon implements Serializable{
    private static final long serialVersionUID = -1892561327013038124L;
    private int maHd;// mã hóa đơn
    private int maScah;//ma sach;
    private int GiaSach;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maHd, int maScah, int GiaSach) {
        this.maHd = maHd;
        this.maScah = maScah;
        this.GiaSach = GiaSach;
    }

    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public int getMaScah() {
        return maScah;
    }

    public void setMaScah(int maScah) {
        this.maScah = maScah;
    }

    public int getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(int GiaSach) {
        this.GiaSach = GiaSach;
    }

   
    public void Nhap(){
        System.out.println("Nhap ma hoa don:");
        this.maHd = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap ma sach:");
        this.maScah = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap ma gia sach:");
        this.GiaSach = (new Scanner(System.in)).nextInt();
    }
    public void xuat() {
       System.out.format("|%-8d|%-8d|%-8d",maHd,maScah,GiaSach);
    }
}

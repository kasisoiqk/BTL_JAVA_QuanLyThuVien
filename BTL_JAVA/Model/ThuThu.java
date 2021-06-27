package BTL_JAVA.Model;

import java.io.Serializable;
import java.util.Scanner;

public class ThuThu extends Nguoi implements  Serializable{
    
    private String chucVu;
    private int maTk;

   
    
    public  ThuThu(){
        
    }
    public ThuThu(String chucVu, int maTk, int ma, String ten, Date ngaySinh, String gioiTinh, String sdt, String email) {
        super(ma, ten, ngaySinh, gioiTinh, sdt, email);
        this.chucVu = chucVu;
        this.maTk = maTk;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getMaTk() {
        return maTk;
    }

    public void setMaTk(int maTk) {
        this.maTk = maTk;
    }
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập mã tài khoản: ");
        this.maTk = (new Scanner(System.in)).nextInt();
        System.out.print("Nhập chức vụ: ");
        this.chucVu = (new Scanner(System.in)).nextLine();
    }
    
    @Override
    public void xuat() {
        System.out.format("| %-8s", "TT"+getMa());
        super.xuat();
        System.out.format(" | %-8s | %-25s |\n",maTk,chucVu);
    }
    
}

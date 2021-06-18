package BTL_JAVA.Model;

import java.io.Serializable;

public class QuanTri extends Nguoi implements Serializable{
    private int maTK;
    
    public QuanTri() {
        
    }

    public QuanTri(int ma, String ten, Date ngaySinh, String gioiTinh, String sdt, String email, int maTK) {
        super(ma, ten, ngaySinh, gioiTinh, sdt, email);

        this.maTK = maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public int getMaTK() {
        return this.maTK;
    }

    @Override
    public void nhap() {
        super.nhap();
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" |");
    }

}
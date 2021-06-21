/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;

import BTL_JAVA.DAO.ChiTietHoaDonDao;
import BTL_JAVA.Model.ChiTietHoaDon;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ChiTietHoaDonManager {
    private List<ChiTietHoaDon> list ;
    private ChiTietHoaDonDao cthoadon;
    
    public ChiTietHoaDonManager() {
        cthoadon = new ChiTietHoaDonDao();
        list = cthoadon.read();
    }
    public boolean them() {
        int maHd = (list.size() > 0) ? (list.get(list.size() - 1).getMaHd() + 1) : 1;
        ChiTietHoaDon hd = new ChiTietHoaDon();
        hd.Nhap();
        hd.setMaHd(maHd);

        return cthoadon.write(hd);
    }
    
    public boolean sua(ChiTietHoaDon hoadon, int maHd) {
        for(ChiTietHoaDon hd : list) {
            if(hd.getMaHd() == maHd) {
                hd = hoadon;
                return cthoadon.write(list, true);
            }
        }
        return false;
    }
    
    public boolean xoa(int maHd) {
        for(ChiTietHoaDon hd : list) {
            if(hd.getMaHd() == maHd) {
                list.remove(hd);
                return cthoadon.write(list, true);
            }
        }
        return false;
    } 
    public static void main(String[] args) {
        ChiTietHoaDonManager hdMn = new ChiTietHoaDonManager();
        hdMn.them();
        
        ChiTietHoaDonDao dao = new ChiTietHoaDonDao();
        List<ChiTietHoaDon> list = dao.read();
        for(ChiTietHoaDon hd : list){
            hd.xuat();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;

import BTL_JAVA.DAO.HoaDonDao;
import BTL_JAVA.Model.HoaDon;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dell
 */
public class HoaDonManager implements Serializable{
    private List<HoaDon> list ;
    private HoaDonDao hoadondao;
    
    public HoaDonManager() {
        hoadondao = new HoaDonDao();
        list = hoadondao.read();
    }
    public boolean them() {
        int maHd = (list.size() > 0) ? (list.get(list.size() - 1).getMaHoaDon() + 1) : 1;
        HoaDon hd = new HoaDon();
        hd.nhap();
        hd.setMaHoaDon(maHd);

        return hoadondao.write(hd);
    }
    
    public boolean sua(HoaDon hoadon, int maHd) {
        for(HoaDon hd : list) {
            if(hd.getMaHoaDon() == maHd) {
                hd = hoadon;
                return hoadondao.write(list, true);
            }
        }
        return false;
    }
    
    public boolean xoa(int maHd) {
        for(HoaDon hd : list) {
            if(hd.getMaHoaDon() == maHd) {
                list.remove(hd);
                return hoadondao.write(list, true);
            }
        }
        return false;
    } 
    public static void main(String[] args) {
        HoaDonManager hdMn = new HoaDonManager();
        hdMn.them();
        
        HoaDonDao dao = new HoaDonDao();
        List<HoaDon> list = dao.read();
        for(HoaDon hd : list){
            hd.xuat();
        }
    }
}

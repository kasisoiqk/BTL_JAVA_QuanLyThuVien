package BTL_JAVA.Controller;

import BTL_JAVA.DAO.HoaDonDAO;
import BTL_JAVA.Model.HoaDon;
import java.util.List;

public class HoaDonManager {
    private List<HoaDon> list ;
    private HoaDonDAO hoadondao;
    
    public HoaDonManager() {
        hoadondao = new HoaDonDAO();
        list = hoadondao.read();
    }
    public boolean them() {
        int maHd = (list.size() > 0) ? (list.get(list.size() - 1).getMaHoaDon() + 1) : 1;
        HoaDon hd = new HoaDon();
        hd.nhap();
        hd.setMaHoaDon(maHd);
        list.add(hd);

        return hoadondao.write(list, true);
    }
    
    public boolean them(HoaDon hd) {
        int maHd = (list.size() > 0) ? (list.get(list.size() - 1).getMaHoaDon() + 1) : 1;
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
    
    public int timMaHoaDon(HoaDon hoaDon) {
        list = hoadondao.read();
        for(HoaDon hd : list) {
            if(hd.getMaBanDoc() == hoaDon.getMaBanDoc() && hd.getMaThuThu() == hd.getMaThuThu() 
                    && hd.getSoLuongSach() == hoaDon.getSoLuongSach() && hd.getTongSoTien() == hoaDon.getTongSoTien()) {
                return hd.getMaHoaDon();
            }
        }
        return -1;
    }
    
    public List<HoaDon> getList() {
        return list;
    }
    
    public static void main(String[] args) {
        HoaDonManager hdMn = new HoaDonManager();
        //hdMn.them();
        
        HoaDonDAO dao = new HoaDonDAO();
        List<HoaDon> list = dao.read();
        for(HoaDon hd : list){
            hd.xuat();
        }
    }
}

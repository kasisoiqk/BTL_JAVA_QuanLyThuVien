package BTL_JAVA.Controller;

import BTL_JAVA.DAO.ChiTietHoaDonDAO;
import BTL_JAVA.Model.ChiTietHoaDon;
import BTL_JAVA.Model.HoaDon;
import java.util.List;

public class ChiTietHoaDonController {
    private List<ChiTietHoaDon> list ;
    private ChiTietHoaDonDAO cthoadon;
    
    public ChiTietHoaDonController() {
        cthoadon = new ChiTietHoaDonDAO();
        list = cthoadon.read();
    }
    public boolean them() {
        int maHd = (list.size() > 0) ? (list.get(list.size() - 1).getMaHD() + 1) : 1;
        ChiTietHoaDon hd = new ChiTietHoaDon();
        hd.nhap();
        hd.setMaHD(maHd);
        list.add(hd);

        return cthoadon.write(list, true);
    }
    
    public boolean them(ChiTietHoaDon chiTietHoaDon) {
        //int maHd = (list.size() > 0) ? (list.get(list.size() - 1).getMaHD() + 1) : 1;
        //chiTietHoaDon.setMaHD(maHd);
        list.add(chiTietHoaDon);

        return cthoadon.write(list, true);
    }
    
    public boolean sua(ChiTietHoaDon hoadon, int maHd) {
        for(ChiTietHoaDon hd : list) {
            if(hd.getMaHD() == maHd) {
                hd = hoadon;
                return cthoadon.write(list, true);
            }
        }
        return false;
    }
    
    public boolean xoa(int maHd) {
        for(ChiTietHoaDon hd : list) {
            if(hd.getMaHD() == maHd) {
                list.remove(hd);
                return cthoadon.write(list, true);
            }
        }
        return false;
    } 
    
    public List<ChiTietHoaDon> getList() {
        return list;
    }
    
    public static void main(String[] args) {
        ChiTietHoaDonController hdMn = new ChiTietHoaDonController();
        //hdMn.them(new ChiTietHoaDon(0, 0, 0));
        
        ChiTietHoaDonDAO dao = new ChiTietHoaDonDAO();
        List<ChiTietHoaDon> list = dao.read();
        for(ChiTietHoaDon hd : list){
            hd.xuat();
        }
    }
}

package BTL_JAVA.Controller;

import BTL_JAVA.DAO.HoaDonDAO;
import BTL_JAVA.Model.HoaDon;
import java.util.List;

public class HoaDonController {
    private List<HoaDon> list ;
    private HoaDonDAO hoadondao;
    
    public HoaDonController() {
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
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getMaHoaDon() == maHd) {
                list.set(i, hoadon);
                return hoadondao.write(list, true);
            }
        }
        return false;
    }
    
    public boolean xoa(int maHd) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getMaHoaDon() == maHd) {
                list.remove(i);
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
        HoaDonController hdMn = new HoaDonController();
        //hdMn.them();
        
        HoaDonDAO dao = new HoaDonDAO();
        List<HoaDon> list = dao.read();
        for(HoaDon hd : list){
            hd.xuat();
        }
    }
}

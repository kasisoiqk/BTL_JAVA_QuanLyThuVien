package BTL_JAVA.Controller;

import BTL_JAVA.Model.ThuThu;
import BTL_JAVA.DAO.ThuThuDAO;
import java.util.List;

public class ThuThuManager {
    private List<ThuThu> list;
    private ThuThuDAO thuThuDAO;

    public ThuThuManager() {
        thuThuDAO = new ThuThuDAO();
        list = thuThuDAO.read();
    }

    public boolean them() {
        int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMa() + 1) : 1;
        ThuThu tt = new ThuThu();
        tt.nhap();
        tt.setMa(ma);
        list.add(tt);

        return thuThuDAO.write(list, true);
    }
    
    public boolean sua(ThuThu thuthu, int ma) {
        for(ThuThu tt : list) {
            if(tt.getMa() == ma) {
                tt = thuthu;
                return thuThuDAO.write(list, true);
            }
        }
        return false;
    }
    
    public boolean xoa(int ma) {
        for(ThuThu tt : list) {
            if(tt.getMa() == ma) {
                list.remove(tt);
                return thuThuDAO.write(list, true);
            }
        }
        return false;
    } 

    public static void main(String[] args) {
        ThuThuManager ttMn = new ThuThuManager();
        
        ttMn.them();

        ThuThuDAO quan = new ThuThuDAO();
        //quan.write(new thuThu(4, "A", new Date(1, 1, 1), "Nam", "09", "sauysah", 0));
//        quan.write(new QuanTri(4, "A", new Date(1, 1, 1), "Nam", "09", "sauysah", 0));
        List<ThuThu> list = quan.read();
        for(ThuThu tt : list){
            tt.xuat();
        }

    }
}

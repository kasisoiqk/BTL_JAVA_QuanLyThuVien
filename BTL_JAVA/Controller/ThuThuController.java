package BTL_JAVA.Controller;

import BTL_JAVA.Model.ThuThu;
import BTL_JAVA.DAO.ThuThuDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThuThuController {
    private List<ThuThu> list;
    private ThuThuDAO thuThuDAO;

    public ThuThuController() {
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
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getMa() == ma) {
                list.set(i, thuthu);
                return thuThuDAO.write(list, true);
            }
        }
        return false;
    }
    
    public boolean xoa(int ma) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getMa() == ma) {
                list.remove(i);
                return thuThuDAO.write(list, true);
            }
        }
        return false;
    } 
    
    public ThuThu tim(int maTK) {
        for(ThuThu thuThu : list) {
            if(thuThu.getMaTk() == maTK) 
                return thuThu;
        }
        return null;
    }
    
    public List<ThuThu> TimTheoTen(String Name){
        List<ThuThu> listAns = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen() == null ? Name == null : list.get(i).getTen().equals(Name)) {
                listAns.add(list.get(i));
            }            
        }
        return listAns;
    }
    
    public List<ThuThu> sort() {
        List<ThuThu> listAns = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            ThuThu tt = list.get(i);
            listAns.add(new ThuThu(tt.getChucVu(), tt.getMaTk(), tt.getMa(), tt.getTen(), 
                    tt.getNgaySinh(), tt.getGioiTinh(), tt.getSdt(), tt.getEmail()));
        }
        Collections.sort(listAns);
        return listAns;
    }

    public static void main(String[] args) {
        ThuThuController ttMn = new ThuThuController();
        
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

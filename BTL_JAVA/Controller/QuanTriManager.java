package BTL_JAVA.Controller;

import BTL_JAVA.DAO.DataReadWriteObject;
import BTL_JAVA.DAO.QuanTriDAO;
import BTL_JAVA.Model.Date;
import BTL_JAVA.Model.QuanTri;
import java.util.List;

public class QuanTriManager {
    private List<QuanTri> list;
    private QuanTriDAO quanTriDAO;

    public QuanTriManager() {
        quanTriDAO = new QuanTriDAO();
        list = quanTriDAO.read();
    }

    public boolean them() {
        int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMa() + 1) : 1;
        QuanTri qt = new QuanTri();
        qt.nhap();
        qt.setMa(ma);

        return quanTriDAO.write(qt);
    }
    
    public boolean sua(QuanTri quanTri, int ma) {
        for(QuanTri qt : list) {
            if(qt.getMa() == ma) {
                qt = quanTri;
                return quanTriDAO.write(list, true);
            }
        }
        return false;
    }
    
    public boolean xoa(int ma) {
        for(QuanTri qt : list) {
            if(qt.getMa() == ma) {
                list.remove(qt);
                return quanTriDAO.write(list, true);
            }
        }
        return false;
    } 

    public static void main(String[] args) {
        QuanTriManager qtMn = new QuanTriManager();
        
        qtMn.them();

        QuanTriDAO quan = new QuanTriDAO();
//        quan.write(new QuanTri(4, "A", new Date(1, 1, 1), "Nam", "09", "sauysah", 0));
//        quan.write(new QuanTri(4, "A", new Date(1, 1, 1), "Nam", "09", "sauysah", 0));
        List<QuanTri> list = quan.read();
        for(QuanTri qt : list){
            qt.xuat();
        }

    }
}

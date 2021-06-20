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

        list.add(qt);

        return quanTriDAO.write(list, true);
    }

    public boolean sua(QuanTri quanTri, int ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa() == ma) {
                list.set(i, quanTri);
                return quanTriDAO.write(list, true);
            }
        }
        return false;
    }

    public boolean xoa(int ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa() == ma) {
                list.remove(i);
                return quanTriDAO.write(list, true);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        QuanTriManager qtMn = new QuanTriManager();

        //qtMn.them();
        if (qtMn.sua(new QuanTri(2, "Linh", new Date(1, 1, 1), "Nu", "1", "1", 0), 2)) {
            System.out.println("A");
        }
        
        qtMn.xoa(3);

        QuanTriDAO quan = new QuanTriDAO();
        List<QuanTri> list = quan.read();
        for (QuanTri qt : list) {
            qt.xuat();
        }

    }
}

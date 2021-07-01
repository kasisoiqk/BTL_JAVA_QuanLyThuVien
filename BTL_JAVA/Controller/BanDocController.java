/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;

import BTL_JAVA.DAO.BanDocDAO;
import BTL_JAVA.Model.BanDoc;
import BTL_JAVA.Model.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class BanDocController {

    private List<BanDoc> list;
    private BanDocDAO banDocDao;

    public BanDocController() {
        banDocDao = new BanDocDAO();
        list = banDocDao.read();
    }

    public boolean them() {
        int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMa() + 1) : 1;
        BanDoc b = new BanDoc();
        b.nhap();
        b.setMa(ma);
        list.add(b);
        return banDocDao.write(list, true);
    }

    public boolean them(BanDoc banDoc) {
        int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMa() + 1) : 1;
        banDoc.setMa(ma);
        list.add(banDoc);
        return banDocDao.write(list, true);
    }

    public boolean sua(BanDoc b, String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSV().equals(ma)) {
                list.set(i, b);
                return banDocDao.write(list, true);
            }
        }
        return false;
    }

    public boolean xoa(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSV().equals(ma)) {
                list.remove(i);
                return banDocDao.write(list, true);
            }
        }
        return false;
    }

    public int timMa(BanDoc banDoc) {
        for (BanDoc bd : list) {
            if (bd.getMaSV().equals(banDoc.getMaSV()) && bd.getTen().equals(banDoc.getTen())) {
                return bd.getMa();
            }
        }
        return -1;
    }

    public BanDoc timBanDoc(int ma) {
        for (BanDoc bd : list) {
            if (bd.getMa() == ma) {
                return bd;
            }
        }
        return null;
    }

    public BanDoc timBanDoc(String maSV) {
        for (BanDoc bd : list) {
            if (bd.getMaSV().equals(maSV)) {
                return bd;
            }
        }
        return null;
    }

    public List<BanDoc> TimTheoTen(String Name) {
        List<BanDoc> listAns = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen() == null ? Name == null : list.get(i).getTen().contains(Name)) {
                listAns.add(list.get(i));
            }
        }
        return listAns;
    }

    public List<BanDoc> getList() {
        return banDocDao.read();
    }

    public List<BanDoc> sort() {
        List<BanDoc> listSort = new ArrayList<>();
        for (BanDoc bd : list) {
            listSort.add(bd);
        }
        Collections.sort(listSort, new Comparator<BanDoc>() {
            @Override
            public int compare(BanDoc o1, BanDoc o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
        });
        return listSort;
    }

}

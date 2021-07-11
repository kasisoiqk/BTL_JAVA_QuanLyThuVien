/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;

import BTL_JAVA.Model.Sach;
import BTL_JAVA.DAO.SachDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class SachController {

    private List<Sach> list;
    private SachDAO sachDao;

    public SachController() {
        sachDao = new SachDAO();
        list = sachDao.read();
    }

    public boolean them() {
        int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMaSach() + 1) : 1;
        Sach s = new Sach();
        s.nhap();
        s.setMaSach(ma);
        list.add(s);
        return sachDao.write(list, true);
    }

    public boolean sua(Sach s, int maSach) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSach() == maSach) {
                list.set(i, s);
                return sachDao.write(list, true);
            }
        }
        return false;
    }

    public boolean xoa(int maSach) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSach() == maSach) {
                list.remove(i);
                return sachDao.write(list, true);
            }
        }
        return false;
    }

    public int tim(int maSach, List<Sach> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSach() == maSach) {
                return i;
            }
        }
        return -1;
    }

    public List<Sach> getList() {
        return list;
    }

    public void xemDanhSach() {
        System.out.println("/--------------------------------------------------------------------------------"
                + "------------------------------------------------------------------------------\\");
        System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
        System.out.println("|------------|------------------------|---------------------------|----------------"
                + "------|--------------------|-----------------|------------|-----------------|");
        for (Sach sach : list) {
            sach.xuat();
        }
        System.out.println("\\--------------------------------------------------------------------------------"
                + "------------------------------------------------------------------------------/");
    }

    public int kiemTraSoLuong(int index) {
        if (index <= 0) {
            return -1;
        }
        if (index > list.get(index).getSoLuongTong()) {
            return list.get(index).getSoLuongTong();
        }
        return 1;
    }

    public int kiemTraTrungTen(Sach sach) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTenSach().equals(sach.getTenSach())) {
                return i;
            }
        }
        return -1;
    }

    public List<Sach> timkiem(String tenSach) {
        List<Sach> listSearch = new ArrayList<>();
        for (Sach sach : list) {
            if (sach.getTenSach() != null && sach.getTenSach().contains(tenSach)) {
                listSearch.add(sach);

            }

        }
        return listSearch;
    }

    public List<Sach> timkiemEquals(String theLoai) {
        // list=sachDao.read();
        List<Sach> listSearch = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //int b=list.get(i).getTheLoai().indexOf(theLoai);
            if (list.get(i).getTheLoai().equals(theLoai)) {
                listSearch.add(list.get(i));

            }

        }

        return listSearch;
    }

    public List<Sach> sort() {
        List<Sach> listSort = list;
        Collections.sort(listSort, new Comparator<Sach>() {
            @Override
            public int compare(Sach o1, Sach o2) {
                return o1.getTenSach().compareTo(o2.getTenSach());
            }
        });
        return listSort;
    }

    public void travel() {
        for (Sach sach : list) {
            System.out.println(sach);
        }
    }

    public static void main(String[] args) {
        SachController sm = new SachController();
        //sm.them();
        //sm.sua(new Sach(1, "Cha giau cha ngheo", "Thay khanh", "Trang an", "21/06/2021", 100, 50,"Tai lieu", 100000), 2);
        //sm.xoa(001);
        SachDAO sDao = new SachDAO();
        List<Sach> list = sDao.read();
        List<Sach> listAns = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Sach sach = list.get(i);
            listAns.add(new Sach(sach.getMaSach(), sach.getTenSach(), sach.getTacGia(), sach.getNhaCungCap(),
                    sach.getNgayNhap(), sach.getSoLuongTong(), sach.getTheLoai(), sach.getGiaSach()));
            listAns.get(i).setGiaSach(1);
        }
        for (Sach b : list) {
            b.xuat();
        }
    }

}

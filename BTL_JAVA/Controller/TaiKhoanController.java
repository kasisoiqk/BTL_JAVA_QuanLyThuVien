/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;

import BTL_JAVA.Model.TaiKhoan;
import BTL_JAVA.DAO.TaiKhoanDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class TaiKhoanController {

    private List<TaiKhoan> list;
    private TaiKhoanDao tkDao;

    public TaiKhoanController() {
        tkDao = new TaiKhoanDao();
        list = tkDao.read();
    }

    public boolean them() {
        int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMaTk() + 1) : 1;
        TaiKhoan tk = new TaiKhoan();
        tk.nhap();
        tk.setMaTk(ma);
        list.add(tk);
        return tkDao.write(list, true);
    }

    public boolean sua(TaiKhoan t, int ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaTk() == ma) {
                list.set(i, t);
                return tkDao.write(list, true);
            }
        }
        return false;
    }

    public boolean xoa(int ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaTk() == ma) {
                list.remove(i);
                return tkDao.write(list, true);
            }
        }
        return false;
    }
    
    public TaiKhoan tim(String username, String password) {
        for(TaiKhoan taiKhoan : list) {
            if(taiKhoan.getTenDangNhap().equalsIgnoreCase(username) && taiKhoan.getMatKhau().equalsIgnoreCase(password)) {
                return taiKhoan;
            }
        }
        return null;
    }

    public List<TaiKhoan> TimTheoTen(String Name) {
        List<TaiKhoan> listAns = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTenDangNhap() == null ? Name == null : list.get(i).getTenDangNhap().equals(Name)) {
                listAns.add(list.get(i));
            }
        }
        return listAns;
    }

    public List<TaiKhoan> sort() {
        List<TaiKhoan> listAns = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TaiKhoan tt = list.get(i);
            listAns.add(new TaiKhoan(tt.getMaTk(), tt.getTenDangNhap(), tt.getMatKhau(), tt.getPhanQuyen()));
        }
        Collections.sort(listAns);
        return listAns;
    }

    public List<TaiKhoan> getList() {
        return list;
    }

    public static void main(String[] args) {
        TaiKhoanController tkmn = new TaiKhoanController();
//        tkmn.them();
//        tkmn.sua(new TaiKhoan(1, "tien dat", "123456", "Thu Thu"), 1);
        tkmn.xoa(1);
        TaiKhoanDao tkD = new TaiKhoanDao();
        List<TaiKhoan> list = tkD.read();
        for (TaiKhoan taiKhoan : list) {
            taiKhoan.xuat();
        }
    }
}

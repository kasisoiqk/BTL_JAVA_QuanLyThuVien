/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.NhaCungCapDAO;
import Model.Date;
import Model.NhaCungCap;
import java.util.List;
/**
 *
 * @author BENH VIEN CONG NGHE
 */
public class NhaCungCapManager {
    private List<NhaCungCap> list;
    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapManager() {
        nhaCungCapDAO = new NhaCungCapDAO();
        list = nhaCungCapDAO.read();
    }
    public boolean them()
    {
        int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMaNhaCungCap() + 1) : 1;
        NhaCungCap ncc = new NhaCungCap();
        ncc.nhap();
        ncc.setMaNhaCungCap(ma);
        list.add(ncc);
        return nhaCungCapDAO.write(list, true);
    }
    public boolean sua(NhaCungCap nhaCungCap, int ma) 
    {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNhaCungCap() == ma) {
                list.set(i, nhaCungCap);
                return nhaCungCapDAO.write(list, true);
            }
        }
        return false;
    }
    public boolean xoa(int ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNhaCungCap() == ma) {
                list.remove(i);
                return nhaCungCapDAO.write(list, true);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        NhaCungCapManager nccMn = new NhaCungCapManager();
//      nccMn.them();
//        if (nccMn.sua(new NhaCungCap(2, "Sach Ha Dong", "Ha noi", "0373713221", "sachhadong@gmail.com"), 1)) {
//            System.out.println("A");
//       }
//      nccMn.xoa(2);
        NhaCungCapDAO nha = new NhaCungCapDAO();
        List<NhaCungCap> list = nha.read();
        for (NhaCungCap ncc : list) {
            ncc.xuat();
        }
    }
}
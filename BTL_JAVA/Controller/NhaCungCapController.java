/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;

import BTL_JAVA.DAO.NhaCungCapDAO;
import BTL_JAVA.Model.Date;
import BTL_JAVA.Model.NhaCungCap;
import java.util.List;
/**
 *
 * @author BENH VIEN CONG NGHE
 */
public class NhaCungCapController {
    private List<NhaCungCap> list;
    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapController() {
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
        NhaCungCapController nccMn = new NhaCungCapController();
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

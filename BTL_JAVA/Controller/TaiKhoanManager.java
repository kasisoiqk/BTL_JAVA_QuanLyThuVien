/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Class.TaiKhoan;
import Read_Write.TaiKhoanDao;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class TaiKhoanManager {
    private List<TaiKhoan> list;
    private TaiKhoanDao tkDao;
    
    public TaiKhoanManager(){
       tkDao=new TaiKhoanDao();
       list=tkDao.read();
    }
    public boolean them(){
      int ma=(list.size()>0) ? (list.get(list.size()-1).getMaTk()+1):1;
      TaiKhoan tk=new TaiKhoan();
      tk.Nhap();
      tk.setMaTk(ma);
      list.add(tk);
      return tkDao.write(list, true);
    }
    public boolean sua(TaiKhoan t,int ma){
     for(int i=0;i<list.size();i++){
       if(list.get(i).getMaTk()==ma){
          list.set(i,t);
          return tkDao.write(list, true);
        }
     }
     return false;
    }
    public boolean xoa(int ma){
       for(int i=0;i<list.size();i++){
          if(list.get(i).getMaTk()==ma){
            list.remove(i);
            return tkDao.write(list, true);
          }
       }
       return false;
    }
    public static void main(String[] args) {
        TaiKhoanManager tkmn=new TaiKhoanManager();
        //tkmn.them();
        //tkmn.sua(new TaiKhoan(2, "tien dat", "123456", "Thu Thu"), 1);
        tkmn.xoa(3);
        TaiKhoanDao tkD=new TaiKhoanDao();
        List<TaiKhoan> list=tkD.read();
        for (TaiKhoan taiKhoan : list) {
            taiKhoan.Xuat();
        }
    }
}

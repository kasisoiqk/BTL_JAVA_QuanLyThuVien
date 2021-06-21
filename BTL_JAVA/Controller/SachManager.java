/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;

import BTL_JAVA.Model.Sach;
import BTL_JAVA.DAO.SachDAO;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class SachManager {
    private List<Sach> list;
    private SachDAO sachDao;

    public SachManager() {
        sachDao=new SachDAO();
        list=sachDao.read();
    }
    public boolean them(){
       int ma=(list.size()>0) ? (list.get(list.size()-1).getMaSach() + 1) : 1;
       Sach s=new Sach();
       s.nhap();
       s.setMaSach(ma);
       list.add(s);
       return sachDao.write(list,true);
    }
    public boolean sua(Sach s, int maSach){
       for(int i=0;i<list.size();i++){
          if(list.get(i).getMaSach()==maSach){
             list.set(i, s);
             return sachDao.write(list,true);
          }
       }
       return false;
    }
    public boolean xoa(int maSach){
       for(int i=0;i<list.size();i++){
         if(list.get(i).getMaSach()==maSach){
            list.remove(i);
            return sachDao.write(list, true);
         }
       }
       return false;
    }
    public static void main(String[] args) {
        SachManager sm=new SachManager();
        //sm.them();
        sm.sua(new Sach(1, "Cha giau cha ngheo", "Thay khanh", "Trang an", "21/06/2021", 100, 50,"Tai lieu", 100000), 2);
        sm.xoa(001);
        SachDAO sDao=new SachDAO();
        List<Sach> list=sDao.read();
        for (Sach sach : list) {
            sach.xuat();
        }
    }
    
}

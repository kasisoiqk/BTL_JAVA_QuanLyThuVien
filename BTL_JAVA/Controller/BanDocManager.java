/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.Controller;


import BTL_JAVA.DAO.BanDocDAO;
import BTL_JAVA.Model.BanDoc;
import BTL_JAVA.Model.Date;
import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class BanDocManager {
    private List<BanDoc> list;
    private BanDocDAO banDocDao;

    public BanDocManager() {
        banDocDao=new BanDocDAO();
        list=banDocDao.read();
    }
    public boolean them(){
       int ma=(list.size()>0) ? (list.get(list.size()-1).getMa()+1):1;
       BanDoc b=new BanDoc();
       b.nhap();
       b.setMa(ma);
       list.add(b);
       return banDocDao.write(list, true);
    }
    public boolean sua(BanDoc b,int ma){
        for(int i=0;i<list.size();i++){
           if(list.get(i).getMa()==ma){
              list.set(i, b);
              return banDocDao.write(list, true);
           }
        }
        return false;
    }
    public boolean xoa(int ma){
      for(int i=0;i<list.size();i++){
         if(list.get(i).getMa()==ma){
         list.remove(i);
         return banDocDao.write(list, true);
         }
      }
      return false;
    }
    public static void main(String[] args) {
        BanDocManager bmn=new BanDocManager();
        //bmn.them();
        bmn.sua(new BanDoc("70dctt21", 2, "Nguyen Tien Dat", new Date(25,01,2001), "nam", "0337101457", "nguyendat250101@gamil.com"), 1);
        BanDocDAO bd=new BanDocDAO();
      //Nguy bd.write(new BanDoc("70dctt21", 3, "Khanh", new Date(25,01,2001), "nam", "0838483", "nghdj.gamil.com"));
       List<BanDoc> list1=bd.read();
        for (BanDoc b : list1) {
            b.xuat();
        }
            
        }
        
    }
    


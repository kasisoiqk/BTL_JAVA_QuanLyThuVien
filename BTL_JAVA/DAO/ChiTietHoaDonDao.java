/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.DAO;

import BTL_JAVA.DAO.DataReadWriteObject;
import BTL_JAVA.Model.ChiTietHoaDon;
import java.io.Serializable;
import java.util.List;

public class ChiTietHoaDonDao implements Serializable{
    
    private static final String ChiTietHoaDon_FILE_NAME = "Chitiethoadon.txt";
    private static DataReadWriteObject<ChiTietHoaDon> data = new DataReadWriteObject<>(ChiTietHoaDon_FILE_NAME);
    
    public boolean write(List<ChiTietHoaDon> list,boolean isNewFile ) {
        return this.data.writeFile(list,isNewFile);
    }
    
    public boolean write(ChiTietHoaDon hd) {
        return this.data.writeFile(hd);
    }
    
    public List<ChiTietHoaDon> read() {
        return this.data.readFile();
    }

    
    
}

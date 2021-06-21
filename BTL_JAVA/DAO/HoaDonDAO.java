package BTL_JAVA.DAO;

import BTL_JAVA.DAO.DataReadWriteObject;
import BTL_JAVA.Model.HoaDon;
import java.io.Serializable;
import java.util.List;

public class HoaDonDao implements Serializable{
    
    private static final String HoaDon_FILE_NAME = "hoadon.txt";
    private static DataReadWriteObject<HoaDon> data = new DataReadWriteObject<>(HoaDon_FILE_NAME);
    
    public boolean write(List<HoaDon> list,boolean isNewFile ) {
        return this.data.writeFile(list,isNewFile);
    }
    
    public boolean write(HoaDon tt) {
        return this.data.writeFile(tt);
    }
    
    public List<HoaDon> read() {
        return this.data.readFile();
    }

    
    
}
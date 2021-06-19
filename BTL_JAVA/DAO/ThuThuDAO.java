package BTL_JAVA.DAO;

import BTL_JAVA.DAO.DataReadWriteObject;
import BTL_JAVA.Model.ThuThu;
import java.io.Serializable;
import java.util.List;

public class ThuThuDAO implements Serializable{
    
    private static final String thuThu_FILE_NAME = "thuthu.txt";
    private static DataReadWriteObject<ThuThu> data = new DataReadWriteObject<>(thuThu_FILE_NAME);
    
    public boolean write(List<ThuThu> list,boolean isNewFile ) {
        return this.data.writeFile(list,isNewFile);
    }
    
    public boolean write(ThuThu tt) {
        return this.data.writeFile(tt);
    }
    
    public List<ThuThu> read() {
        return this.data.readFile();
    }

    
    
}
package BTL_JAVA.DAO;

import BTL_JAVA.Model.NhaCungCap;
import java.util.List;

public class NhaCungCapDAO {
    private static final String QUANTRI_FILE_NAME = "nhacungcap.txt";
    private static DataReadWriteObject<NhaCungCap> data = new DataReadWriteObject<>(QUANTRI_FILE_NAME);

    public boolean write(List<NhaCungCap> list, boolean isNewFile) {
        return this.data.writeFile(list, isNewFile);
    }

    public boolean write(NhaCungCap bd) {
        return this.data.writeFile(bd);
    }

    public List<NhaCungCap> read() {
        return this.data.readFile();
    }
}

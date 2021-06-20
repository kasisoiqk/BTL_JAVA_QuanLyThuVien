package BTL_JAVA.DAO;

import BTL_JAVA.Model.HoaDon;
import java.util.List;

public class HoaDonDAO {
    private static final String QUANTRI_FILE_NAME = "quantri.txt";
    private static DataReadWriteObject<HoaDon> data = new DataReadWriteObject<>(QUANTRI_FILE_NAME);

    public boolean write(List<HoaDon> list, boolean isNewFile) {
        return this.data.writeFile(list, isNewFile);
    }

    public boolean write(HoaDon bd) {
        return this.data.writeFile(bd);
    }

    public List<HoaDon> read() {
        return this.data.readFile();
    }
}

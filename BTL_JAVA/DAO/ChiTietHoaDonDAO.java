package BTL_JAVA.DAO;

import BTL_JAVA.Model.ChiTietHoaDon;
import java.util.List;

public class ChiTietHoaDonDAO {
    private static final String CHITIETHOADON_FILE_NAME = "chitiethoadon.txt";
    private static DataReadWriteObject<ChiTietHoaDon> data = new DataReadWriteObject<>(CHITIETHOADON_FILE_NAME);

    public boolean write(List<ChiTietHoaDon> list, boolean isNewFile) {
        return this.data.writeFile(list, isNewFile);
    }

    public boolean write(ChiTietHoaDon qt) {
        return this.data.writeFile(qt);
    }

    public List<ChiTietHoaDon> read() {
        return this.data.readFile();
    }
}

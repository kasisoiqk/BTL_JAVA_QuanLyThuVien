package BTL_JAVA.DAO;

import BTL_JAVA.Model.QuanTri;
import java.util.List;

public class QuanTriDAO {
    private static final String QUANTRI_FILE_NAME = "quantri.txt";
    private static DataReadWriteObject<QuanTri> data = new DataReadWriteObject<>(QUANTRI_FILE_NAME);

    public boolean write(List<QuanTri> list, boolean isNewFile) {
        return this.data.writeFile(list, isNewFile);
    }

    public boolean write(QuanTri qt) {
        return this.data.writeFile(qt);
    }

    public List<QuanTri> read() {
        return this.data.readFile();
    }
}

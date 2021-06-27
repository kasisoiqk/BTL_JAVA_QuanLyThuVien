package BTL_JAVA.DAO;

import BTL_JAVA.Model.BanDoc;
import java.util.List;

public class BanDocDAO {
    private static final String BANDOC_FILE_NAME = "bandoc.txt";
    private static DataReadWriteObject<BanDoc> data = new DataReadWriteObject<>(BANDOC_FILE_NAME);

    public boolean write(List<BanDoc> list, boolean isNewFile) {
        return this.data.writeFile(list, isNewFile);
    }

    public boolean write(BanDoc bd) {
        return this.data.writeFile(bd);
    }

    public List<BanDoc> read() {
        return this.data.readFile();
    }
}

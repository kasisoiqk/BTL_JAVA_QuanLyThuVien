/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.DAO;

import BTL_JAVA.Model.Sach;
import java.util.List;

/**
 *
 * @author Kasi Soi
 */
public class SachDAO {
    private static final String SACH_FILE_NAME = "sach.txt";
    private static DataReadWriteObject<Sach> data = new DataReadWriteObject<>(SACH_FILE_NAME);

    public boolean write(List<Sach> list, boolean isNewFile) {
        return this.data.writeFile(list, isNewFile);
    }

    public boolean write(Sach qt) {
        return this.data.writeFile(qt);
    }

    public List<Sach> read() {
        return this.data.readFile();
    }
}

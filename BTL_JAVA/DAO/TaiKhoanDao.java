/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.DAO;

import BTL_JAVA.Model.TaiKhoan;
import java.util.List;

/**
 *
 * @author Dell
 */
public class TaiKhoanDao {
    private static final String TAIKHOAN_FILE_NAME = "taikhoan.txt";
    private static DataReadWriteObject<TaiKhoan> data = new DataReadWriteObject<>(TAIKHOAN_FILE_NAME);

    public boolean write(List<TaiKhoan> list, boolean isNewFile) {
        return this.data.writeFile(list, isNewFile);
    }

    public boolean write(TaiKhoan tk) {
        return this.data.writeFile(tk);
    }

    public List<TaiKhoan> read() {
        return this.data.readFile();
    }
}

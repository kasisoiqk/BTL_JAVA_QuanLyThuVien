package BTL_JAVA.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataReadWriteObject<T> implements Serializable {
    private String FILE_NAME;

    public DataReadWriteObject() {

    }

    public DataReadWriteObject(String fileName) {
        this.FILE_NAME = fileName;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public void setFILE_NAME(String fILE_NAME) {
        FILE_NAME = fILE_NAME;
    }
    
    public List<T> readFile() { 
        List<T> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        ObjectInputStream ois = null;
        try {
            if(file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                Object obj = ois.readObject();
                while (obj != null) {
                    list.add((T) obj);
                    try {
                        obj = ois.readObject();
                    } catch (Exception e) {
                        obj = null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (Exception e) {

            }
        }
        return list;
    }

    public boolean writeFile(T t) {
        File file = new File(FILE_NAME);
        ObjectOutputStream oos = null;
        try {
            if (file.isFile()) {
                oos = new MyObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file, true));
            }
            oos.writeObject(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {

            }
        }
        return false;
    }
    
    public boolean writeFile(List<T> list, boolean isNewFile) {
        File file = new File(FILE_NAME);
        ObjectOutputStream oos = null;
        try {
            if (file.isFile() && isNewFile == false) {
                oos = new MyObjectOutputStream(new FileOutputStream(file));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            for (T t : list) {
                oos.writeObject(t);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {

            }
        }
        return false;
    }

}
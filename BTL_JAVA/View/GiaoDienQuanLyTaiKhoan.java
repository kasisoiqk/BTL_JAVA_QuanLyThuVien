package BTL_JAVA.View;

import BTL_JAVA.Controller.TaiKhoanController;
import BTL_JAVA.DAO.TaiKhoanDao;
import BTL_JAVA.Model.TaiKhoan;
import java.awt.Robot;
import java.util.List;
import java.util.Scanner;

public class GiaoDienQuanLyTaiKhoan {

    public static void clearScreen() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Hienthi() {
        System.out.println("----------------------Danh sách tài khoản--------------------");
        System.out.format("| %-8s | %-20s | %-20s | %-15s |\n",
                "Mã TK", "Tên đăng nhập", "Mật khẩu", "Quyền hạn");
    }

    public void run() throws InterruptedException {
        GiaoDienQuanLyTaiKhoan menu = new GiaoDienQuanLyTaiKhoan();
        TaiKhoanController Mn = new TaiKhoanController();
        TaiKhoanDao dao = new TaiKhoanDao();
        List<TaiKhoan> list;
        int chon;
        do {
            Thread.sleep(50);
            list = dao.read();
            menu.Hienthi();
            for (TaiKhoan taiKhoan : list) {
                taiKhoan.xuat();
            }
            System.out.println(" *********************************************************** ");
            System.out.println(" *                     QUẢN LÝ TÀI KHOẢN                   * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *              1. Thêm tài khoản                          * ");
            System.out.println(" *              2. Sửa thông tin tài khoản                 * ");
            System.out.println(" *              3. Xóa thông tin tài khoản                 * ");
            System.out.println(" *              4. Tìm thông tin tài khoản                 * ");
            System.out.println(" *              5. Chức năng sắp xếp thông tin             * ");
            System.out.println(" *              0. Quay lại                                * ");
            System.out.println(" *********************************************************** ");
            System.out.print("Vui lòng lựa chọn: ");
            chon = new Scanner(System.in).nextInt();
            String str;
            switch (chon) {
                case 1:
                    System.out.println("Bạn chọn chức năng thêm thông tin");

                    Mn.them();
                    list = dao.read();
                    menu.Hienthi();
                    for (TaiKhoan tk : list) {
                        tk.xuat();
                    }
                    System.out.println("--Thêm thành công--");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 2:
                    TaiKhoan tk = new TaiKhoan();
                    System.out.println("Bạn chọn chức năng sửa");
                    System.out.print("Nhập mã tài khoản cần sửa: ");
                    int mat = new Scanner(System.in).nextInt();
                    System.out.println("Nhập dữ liệu cần sửa");
                    tk.nhap();
                    tk.setMaTk(mat);
                    Mn.sua(tk, mat);
                    list = dao.read();
                    menu.Hienthi();
                    for (TaiKhoan t : list) {
                        t.xuat();

                    }
                    System.out.println("--Sửa thành công--");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 3:
                    System.out.println("Bạn chọn chức năng xóa");
                    System.out.print("Nhap ma thu thu can xoa:");
                    int ma = (new Scanner(System.in).nextInt());
                    if (Mn.xoa(ma)) {
                        System.out.println("--Xóa thành công--");
                        list = dao.read();
                        menu.Hienthi();
                        for (TaiKhoan t : list) {
                            t.xuat();

                        }
                    } else {
                        System.out.println("Xóa thất bại");
                    }
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 4:
                    System.out.println("Thuc hien chuc nang Search");
                    System.out.println("Nhap tu khoa can tim (name): ");
                    String keywork = new Scanner(System.in).nextLine();
                    list = Mn.TimTheoTen(keywork);
                    if (list.size() > 0) {
                        System.out.println("Ket qua tim kiem:");
                        for (TaiKhoan t : list) {
                            t.xuat();

                        }
                    } else {
                        System.out.println("Khong tim thay ket qua");
                    }
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 5:
                    System.out.println("Thuc hien chuc nang Sort");
                    for (TaiKhoan tt : Mn.sort()) {
                            tt.xuat();
                        }
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 0:
                    System.out.println("Thuc hien chuc nang Exit");
                    break;
                default:
                    System.out.println("ko tồn tại chức năng này");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
            }
        } while (chon != 0);

    }
    public static void main(String[] args) throws InterruptedException {
        GiaoDienQuanLyTaiKhoan d = new GiaoDienQuanLyTaiKhoan();
        d.run();
    }
}

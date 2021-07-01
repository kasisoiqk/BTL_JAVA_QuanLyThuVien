package BTL_JAVA.View;

import BTL_JAVA.Controller.ThuThuController;
import BTL_JAVA.DAO.ThuThuDAO;
import BTL_JAVA.Model.ThuThu;
import java.awt.Robot;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class GiaoDienQuanLyThuThu implements Serializable {

    public void clearScreen() {
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
        System.out.println("\n----------------------Danh sách thủ thư--------------------");
        System.out.println("/-----------------------------------------------------------------------------------------"
                + "------------------------------------------------------------\\");
        System.out.format("| %-8s | %-25s | %-10s | %-10s | %-15s | %-25s | %-8s | %-25s |\n", "Mã", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Email", "Mã tk", "Chức vụ");
        System.out.println("|----------|---------------------------|------------|------------|-----------------|-----"
                + "----------------------|----------|---------------------------|");
    }

    public void run() throws InterruptedException {
        GiaoDienQuanLyThuThu menu = new GiaoDienQuanLyThuThu();
        ThuThuController Mn = new ThuThuController();
        ThuThuDAO dao = new ThuThuDAO();
        List<ThuThu> list;
        int chon;
        do {
            Thread.sleep(50);
            list = dao.read();
            menu.Hienthi();
            for (ThuThu thuThu : list) {
                thuThu.xuat();
            }
            System.out.println("\\-----------------------------------------------------------------------------------------"
                    + "------------------------------------------------------------/");
            System.out.println("\n *********************************************************** ");
            System.out.println(" *                     QUẢN LÝ THỦ THƯ                     * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *              1. Thêm thủ thư                            * ");
            System.out.println(" *              2. Sửa thông tin thủ thư                   * ");
            System.out.println(" *              3. Xóa thông tin thủ thư                   * ");
            System.out.println(" *              4. Tìm thông tin thủ thư                   * ");
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
                    System.out.println("--Thêm thành công--");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 2:
                    ThuThu t = new ThuThu();
                    System.out.println("Bạn chọn chức năng sửa");
                    System.out.print("Nhập mã thủ thư cần sửa: ");
                    int mat = new Scanner(System.in).nextInt();
                    System.out.println("Nhập dữ liệu cần sửa");
                    t.nhap();
                    t.setMa(mat);
                    Mn.sua(t, mat);
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
                    } else {
                        System.out.println("Xóa thất bại");
                    }
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 4:
                    System.out.println("Thuc hien chuc nang Search");
                    System.out.print("Nhap tu khoa can tim (name): ");
                    String keywork = new Scanner(System.in).nextLine();
                    list = Mn.TimTheoTen(keywork);
                    if (list.size() > 0) {
                        System.out.println("Ket qua tim kiem:");
                        Hienthi();
                        for (ThuThu thuThu : list) {
                            thuThu.xuat();
                        }
                        System.out.println("\\-----------------------------------------------------------------------------------------"
                                + "------------------------------------------------------------/");
                    } else {
                        System.out.println("Khong tim thay ket qua");
                    }
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 5:
                    System.out.println("Thuc hien chuc nang Sort");
                    Hienthi();
                    for (ThuThu tt : Mn.sort()) {
                        tt.xuat();
                    }
                    System.out.println("\\-----------------------------------------------------------------------------------------"
                            + "------------------------------------------------------------/");
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
}

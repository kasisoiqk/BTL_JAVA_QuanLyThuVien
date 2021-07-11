package BTL_JAVA.View;

import BTL_JAVA.Controller.BanDocController;
import BTL_JAVA.Model.BanDoc;
import java.awt.Robot;
import java.util.List;
import java.util.Scanner;

public class GiaoDienQuanLyBanDoc {

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

    public void run() {
        GiaoDienQuanLyBanDoc gd = new GiaoDienQuanLyBanDoc();
        BanDocController bm = new BanDocController();
        try {
            int luaChon;
            do {
                Thread.sleep(50);
                System.out.println("-----Danh sách bạn đọc-----");
                List<BanDoc> list = bm.getList();
                System.out.println("/---------------------------------------------------------------------------------------------"
                        + "-----------------------------------------\\");
                System.out.format("| %-14s | %-25s | %-10s | %-10s | %-15s | %-25s | %-15s |\n",
                        "Mã SV", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Email", "Lớp");
                System.out.println("|----------------|---------------------------|------------|------------|-----------------|------"
                        + "---------------------|-----------------|");
                for (BanDoc banDoc : list) {
                    banDoc.xuat();
                }
                System.out.println("\\---------------------------------------------------------------------------------------------"
                        + "-----------------------------------------/ \n");
                System.out.println("1: Thêm bạn đọc | 2: Sửa thông tin bạn đọc | 3: Xóa bạn đọc | 4: Tìm kiếm | 5: Sắp xếp | 0: Quay lại ");
                System.out.print("Vui lòng chọn: ");
                try {
                    luaChon = (new Scanner(System.in)).nextInt();
                } catch (Exception ex) {
                    luaChon = -1;
                }
                String str;
                switch (luaChon) {
                    case 1:
                        if (bm.them()) {
                            System.out.println("Thêm bạn đọc thành công !");
                        } else {
                            System.out.println("Thêm không thành công !");
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        gd.clearScreen();
                        break;
                    case 2:
                        BanDoc b = new BanDoc();
                        System.out.print("Nhập mã SV của bạn đọc cần sửa: ");
                        String mab = new Scanner(System.in).nextLine();
                        if (bm.timBanDoc(mab) == null) {
                            System.out.println("Mã bạn đọc không đúng!");
                        } else {
                            System.out.println("Nhập dữ liệu:");
                            b.nhap();
                            bm.sua(b, mab);
                            System.out.println("Sửa thông tin bạn đọc thành công !");
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        gd.clearScreen();
                        break;
                    case 3:
                        System.out.print("Nhập mã SV bạn đọc cần xóa :");
                        String ma = new Scanner(System.in).nextLine();
                        int chon;
                        System.out.println("Bạn có thực sự muốn xóa bạn đọc có mã SV " + ma + " không ? "
                                + " 1: Đồng ý | 2: Không đồng ý ");
                        System.out.print("Vui lòng chọn ");
                        chon = new Scanner(System.in).nextInt();
                        switch (chon) {
                            case 1:
                                System.out.println("Xóa thành công !");
                                bm.xoa(ma);
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Vui lòng chọn lại !!!");
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        gd.clearScreen();
                        break;
                    case 4:
                        System.out.println("Bạn chọn tìm bạn đọc!");
                        System.out.println("Nhập tên bạn đọc muốn tìm kiếm: ");
                        String name = (new Scanner(System.in)).nextLine();
                        List<BanDoc> list4 = bm.TimTheoTen(name);
                        if (list4.size() > 0) {
                            System.out.println("Danh sách kết quả tìm kiếm:");
                            for (BanDoc banDoc : list4) {
                                banDoc.xuat();
                            }
                        } else {
                            System.out.println("Không có kết quả tìm kiếm!");
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        gd.clearScreen();
                        break;
                    case 5:
                        System.out.println("Danh sách sau khi sắp xếp:");
                        List<BanDoc> list5 = bm.sort();
                        for (BanDoc banDoc : list5) {
                            banDoc.xuat();
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        gd.clearScreen();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại ");
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        gd.clearScreen();
                }
            } while (luaChon != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

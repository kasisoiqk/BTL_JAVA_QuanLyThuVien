package BTL_JAVA.View;

import BTL_JAVA.Model.Sach;
import BTL_JAVA.Controller.SachController;
import BTL_JAVA.DAO.SachDAO;
import java.awt.Robot;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GiaoDienQuanLySach {

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

    public void run() {
        System.out.println("----Danh sách thông tin sách-----");
        SachController sm = new SachController();
        SachDAO sd = new SachDAO();
        List<Sach> list = sd.read();

        try {
            String str;
            int luaChon;
            do {
                System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                        "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
                for (Sach sach : list) {
                    sach.xuat();
                }
                System.out.println("1: Thêm sách | 2: Sửa thông tin của sách | 3:Xóa sách | 4: Tìm kiếm sách | 5: Sắp xếp | 0:Exit");
                System.out.print("Vui lòng lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                switch (luaChon) {
                    case 1:
                        if (sm.them()) {
                            System.out.println("Thêm sách thành công !");
                            List<Sach> list1 = sd.read();
                            System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                                    "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
                            for (Sach sach : list1) {
                                sach.xuat();
                            }
                        } else {
                            System.out.println("Thêm sách không thành công");
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        break;
                    case 2:

                        System.out.print("Nhập mã của sách cần sửa: ");
                        int ma = new Scanner(System.in).nextInt();
                        int vt = sm.tim(ma, list);
                        if (vt == -1) {
                            System.out.println("Không tồn tại mã sách " + ma);
                        } else {
                            System.out.println("Nhập tên sách mới: ");
                            String ten = new Scanner(System.in).nextLine();
                            System.out.println("Nhập tên tác giả mới: ");
                            String tenTg = new Scanner(System.in).nextLine();
                            System.out.println("Nhập tên nhà cung cấp mới: ");
                            String tenNhaCC = new Scanner(System.in).nextLine();
                            System.out.println("Nhập giá sách sách mới: ");
                            int gia = new Scanner(System.in).nextInt();
                            list.get(vt).setTenSach(ten);
                            list.get(vt).setTacGia(tenTg);
                            list.get(vt).setNhaCungCap(tenNhaCC);
                            list.get(vt).setGiaSach(gia);
                            sm.sua(list.get(vt), ma);
                            System.out.println("Sửa thành công");
                            List<Sach> list1 = sd.read();
                            System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                                    "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
                            for (Sach sach : list1) {
                                sach.xuat();
                            }

                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        break;
                    case 3:
                        System.out.println("Nhập mã sách cần xóa : ");
                        int maSach = new Scanner(System.in).nextInt();
                        if (sm.xoa(maSach)) {
                            System.out.println("Xóa  sách thành công");
                            List<Sach> list1 = sd.read();
                            System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                                    "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
                            for (Sach sach : list1) {
                                sach.xuat();
                            }
                        } else {
                            System.out.println("Xóa sách thất bại ");
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        break;
                    case 4:
                        System.out.println("1: Tìm kiếm theo tên sách | 2:Tìm kiếm theo thể loại 3: Hủy ");
                        int chon = new Scanner(System.in).nextInt();
                        switch (chon) {
                            case 1:
                                System.out.print("Nhập tên sách cần tìm: ");
                                String tenSach = new Scanner(System.in).nextLine();
                                List<Sach> listSearch = sm.timkiem(tenSach);
                                if (listSearch.size() > 0) {
                                    System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                                            "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
                                    for (Sach sach : listSearch) {
                                        sach.xuat();
                                    }
                                } else {
                                    System.out.println("Không tìm thấy tên sách " + tenSach);
                                }
                                break;
                            case 2:
                                System.out.print("Nhập thể loại cần tìm kiếm: ");

                                String key = new Scanner(System.in).nextLine();
                                List<Sach> listSearch1 = sm.timkiemEquals(key);
                                if (listSearch1.size() > 0) {
                                    System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                                            "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
                                    for (Sach sach1 : listSearch1) {
                                        sach1.xuat();
                                    }
                                } else {
                                    System.out.println("Không tìm thấy !");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Chọn không đúng ! Vui lòng chọn lại");

                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        break;
                    case 5:
                        //sm.sort();
                        //List<Sach> listSx=sd.read();
                        System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                                "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
                        for (Sach sach : sm.sort()) {
                            sach.xuat();
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        break;

                    case 0:
                        //JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát không? ", "Xác nhận yêu cầu thoát", JOptionPane.OK_CANCEL_OPTION);
                        break;
                    default:
                        System.out.println("Chọn không đúng ! Vui lòng chọn lại");
                }
                list = sd.read();
                clearScreen();
            } while (luaChon != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

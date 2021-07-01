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

    public void nhapSach() {
        SachController sm = new SachController();
        List<Sach> list = sm.getList();
        Sach sach = new Sach();
        sach.nhap();
        int masach = sm.kiemTraTrungTen(sach);
        if (sm.kiemTraTrungTen(sach) == -1) {
            SachDAO sachDAO = new SachDAO();
            int ma = (list.size() > 0) ? (list.get(list.size() - 1).getMaSach() + 1) : 1;
            sach.setMaSach(ma);
            list.add(sach);
            sachDAO.write(list, true);
            System.out.println("******Nhập tài liệu mới thành công******");
        } else {
            Sach sach1 = new Sach(list.get(masach).getMaSach(), list.get(masach).getTenSach(), list.get(masach).getTacGia(), list.get(masach).getNhaCungCap(), list.get(masach).getNgayNhap(),
                    list.get(masach).getSoLuongTong() + sach.getSoLuongTong(), list.get(masach).getTheLoai(), list.get(masach).getGiaSach());
            sm.sua(sach1, sach1.getMaSach());
            System.out.println("******Thêm " + sach.getSoLuongTong() + " quyển vào tài liệu " + list.get(masach).getTenSach() + " thành công******");
        }
    }

    public void printList(List<Sach> list) {
        System.out.println("/--------------------------------------------------------------------------------"
                + "------------------------------------------------------------------------------\\");
        System.out.format("| %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-10s | %-15s |" + "\n",
                "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp", "Thể loại", "Ngày nhập", "Số lượng", "Giá sách");
        System.out.println("|------------|------------------------|---------------------------|----------------"
                + "------|--------------------|-----------------|------------|-----------------|");
        for (Sach sach : list) {
            sach.xuat();
        }
        System.out.println("\\--------------------------------------------------------------------------------"
                + "------------------------------------------------------------------------------/");
    }

    public void run() throws InterruptedException {
        GiaoDienQuanLySach gd = new GiaoDienQuanLySach();
        SachController sm = new SachController();
        SachDAO sd = new SachDAO();
        List<Sach> list = sd.read();

        try {
            String str;
            int luaChon;
            do {
                Thread.sleep(50);
                System.out.println("----Danh sách thông tin sách-----");
                printList(list);
                System.out.println("\n1: Thêm sách | 2: Sửa thông tin của sách | 3:Xóa sách | 4: Tìm kiếm sách | 5: Sắp xếp | 0: Quay lại");
                System.out.print("Vui lòng lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                switch (luaChon) {
                    case 1:
                        gd.nhapSach();
                        System.out.println("Thêm sách thành công !");
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        clearScreen();
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

                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        clearScreen();
                        break;
                    case 3:
                        System.out.println("Nhập mã sách cần xóa : ");
                        int maSach = new Scanner(System.in).nextInt();
                        if (sm.xoa(maSach)) {
                            System.out.println("Xóa  sách thành công");
                        } else {
                            System.out.println("Xóa sách thất bại ");
                        }
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        clearScreen();
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
                                    printList(listSearch);
                                } else {
                                    System.out.println("Không tìm thấy tên sách " + tenSach);
                                }
                                break;
                            case 2:
                                System.out.print("Nhập thể loại cần tìm kiếm: ");

                                String key = new Scanner(System.in).nextLine();
                                List<Sach> listSearch1 = sm.timkiemEquals(key);
                                if (listSearch1.size() > 0) {
                                    printList(listSearch1);
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
                        clearScreen();
                        break;
                    case 5:
                        //sm.sort();
                        //List<Sach> listSx=sd.read();
                        printList(sm.sort());
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                        clearScreen();
                        break;

                    case 0:
                        break;
                    default:
                        System.out.println("Chọn không đúng ! Vui lòng chọn lại");
                        System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                        str = (new Scanner(System.in)).nextLine();
                }
                list = sd.read();
            } while (luaChon != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new GiaoDienQuanLySach().run();
    }
}

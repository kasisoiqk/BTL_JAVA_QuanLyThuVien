package BTL_JAVA.View;

import BTL_JAVA.Controller.SachManager;
import BTL_JAVA.Model.Sach;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiaoDienQuanLyMuonTraSach {

    private int maThuThu;
    private SachManager sachMn;

    public GiaoDienQuanLyMuonTraSach(int maThuThu) {
        this.maThuThu = maThuThu;
        sachMn = new SachManager();
    }

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

    public void inDanhMucHD(List<Sach> danhmucHD, List<Integer> quantity) {
        if (danhmucHD.size() <= 0) {
            System.out.println("Danh mục hóa đơn trống!");
            return;
        } else {
            System.out.println("Danh mục hóa đơn có " + danhmucHD.size() + " bản ghi.");
        }
        System.out.format("| %-10s | %-22s | %-25s | %-15s | %-15s |%-15s |\n",
                "Mã sách", "Tên sách", "Tên tác giả", "Thể loại", "Số lượng", "Giá");
        int i = 0;
        for (Sach sach : danhmucHD) {
            System.out.format("| %-10s | %-20s | %-25s | %-15s | %-15s |%-15s |\n",
                    "S" + sach.getMaSach(), sach.getTenSach(), sach.getTacGia(),
                    sach.getTheLoai(), quantity.get(i), sach.getGiaSach());
            i++;
        }
    }

    public String checkInputMaSach(String ma, List<Sach> list) {
        String[] s = ma.split("S");

        while (s.length <= 1) {
            System.out.print("Bạn nhập sai mã sách. Vui lòng nhập lại (hoặc nhập 'huy' để quay lại): ");
            ma = (new Scanner(System.in)).nextLine();
            if (ma.equals("huy")) {
                break;
            }
            s = ma.split("S");
        }
        if (ma.equals("huy")) {
            return "huy";
        }
        int index = sachMn.tim(Integer.parseInt(s[1].trim()), list);
        while (index == -1) {
            System.out.print("Bạn nhập sai mã sách. Vui lòng nhập lại (hoặc nhập 'huy' để quay lại): ");
            ma = (new Scanner(System.in)).nextLine();
            if (ma.equals("huy")) {
                return "huy";
            }
            s = ma.split("S");

            index = sachMn.tim(Integer.parseInt(s[1].trim()), list);
        }
        return index + "";
    }

    public void muonSach() {
        GiaoDienQuanLyMuonTraSach gd = new GiaoDienQuanLyMuonTraSach(1);
        List<Sach> danhmucHD = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        boolean isRun = true;

        while (isRun) {
            System.out.println(" *********************************************************** ");
            System.out.println(" *                       MƯỢN SÁCH                         * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *              1. Thêm sách vào hóa đơn                   * ");
            System.out.println(" *              2. Sửa thông tin sách trong hóa đơn        * ");
            System.out.println(" *              3. Xóa sách trong hóa đơn                  * ");
            System.out.println(" *              4. Nhập thông tin bạn đọc                  * ");
            System.out.println(" *              5. Sửa thông tin bạn đọc                  * ");
            System.out.println(" *              6. Thanh toán                              * ");
            System.out.println(" *              7. Xem danh sách                           * ");
            System.out.println(" *              0. Quay lại                                * ");
            System.out.println(" *********************************************************** ");

//            danhmucHD.add(new Sach(1, "a", "A", "A", "1/1/1001", 5, 4, "A", 3000));
//            danhmucHD.add(new Sach(2, "a", "A", "A", "1/1/1001", 5, 4, "A", 3000));
//            quantity.add(3);
//            quantity.add(4);
            System.out.println("");
            gd.inDanhMucHD(danhmucHD, quantities);
            System.out.println("");

            System.out.print("Mời bạn chọn chức năng: ");

            int key = Integer.parseInt((new Scanner(System.in)).nextLine());
            while (key < 0 || key > 7) {
                System.out.print("Yêu cầu nhập lại chức năng: ");
                key = Integer.parseInt((new Scanner(System.in)).nextLine());
            }

            int index;
            String ma;
            int quantity;

            switch (key) {
                case 1:
                    System.out.print("Bạn lựa chọn thêm sách mới vào hóa đơn!");
                    System.out.print("Nhập mã sách: ");
                    ma = (new Scanner(System.in)).nextLine();
                    ma = checkInputMaSach(ma, sachMn.getList());
                    if(ma.equals("huy")) break;
                    System.out.print("Nhập số lượng sách: ");
                    quantity = (new Scanner(System.in)).nextInt();
                    danhmucHD.add(sachMn.getList().get(Integer.parseInt(ma)));
                    quantities.add(quantity);
                    break;
                case 2:
                    System.out.print("Bạn lựa chọn sửa thông tin sách trong hóa đơn!");
                    System.out.print("Nhập mã sách muốn sửa: ");
                    ma = (new Scanner(System.in)).nextLine();
                    ma = checkInputMaSach(ma, danhmucHD);
                    if(ma.equals("huy")) break;
                    System.out.print("Nhập số lượng sách sửa: ");
                    quantity = (new Scanner(System.in)).nextInt();
                    index = Integer.parseInt(ma);
                    quantities.set(index, quantity);
                    break;
                case 3:
                    System.out.print("Bạn lựa chọn xóa thông tin sách trong hóa đơn!");
                    System.out.print("Nhập mã sách muốn xóa: ");
                    ma = (new Scanner(System.in)).nextLine();
                    ma = checkInputMaSach(ma, danhmucHD);
                    if(ma.equals("huy")) break;
                    index = Integer.parseInt(ma);
                    danhmucHD.remove(index);
                    quantities.remove(index);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("\nDanh sách sách có trong thư viện:");
                    sachMn.xemDanhSach();
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    ma = (new Scanner(System.in)).nextLine();
                    break;
                case 0:
                    isRun = false;
                    break;
            }

            clearScreen();
        }
    }

    public static void main(String[] args) {
        GiaoDienQuanLyMuonTraSach gd = new GiaoDienQuanLyMuonTraSach(1);
        boolean isRun = true;

        while (isRun) {
            System.out.println(" *********************************************************** ");
            System.out.println(" *                       MƯỢN TRẢ SÁCH                     * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *                     1. Mượn sách                        * ");
            System.out.println(" *                     2. Trả sách                         * ");
            System.out.println(" *                     3. Xem hóa đơn mượn trả             * ");
            System.out.println(" *                     0. Quay lại                         * ");
            System.out.println(" *********************************************************** ");
            System.out.print("Mời bạn chọn chức năng: ");

            int key = Integer.parseInt((new Scanner(System.in)).nextLine());
            while (key < 0 || key > 3) {
                System.out.print("Yêu cầu nhập lại chức năng: ");
                key = Integer.parseInt((new Scanner(System.in)).nextLine());
            }

            switch (key) {
                case 1:
                    clearScreen();
                    gd.muonSach();
                    break;
                case 2:
                    clearScreen();
                    break;
                case 3:
                    clearScreen();
                    break;
                case 0:
                    isRun = false;
                    break;
            }
        }
    }
}

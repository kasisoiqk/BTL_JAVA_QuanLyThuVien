package BTL_JAVA.View;

import BTL_JAVA.Controller.*;
import BTL_JAVA.Model.*;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiaoDienQuanLyMuonTraSach {

    private int maThuThu;
    private SachController sachMn;

    public GiaoDienQuanLyMuonTraSach(int maThuThu) {
        this.maThuThu = maThuThu;
        sachMn = new SachController();
    }

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

    public void inDanhMucHD(List<Sach> danhmucHD, List<Integer> quantity) {
        if (danhmucHD.size() <= 0) {
            System.out.println("Danh mục hóa đơn trống!");
            return;
        } else {
            System.out.println("Danh mục hóa đơn có " + danhmucHD.size() + " bản ghi.");
        }
        System.out.format("| %-10s | %-22s | %-25s | %-18s | %-15s |%-15s |\n",
                "Mã sách", "Tên sách", "Tên tác giả", "Thể loại", "Số lượng", "Giá");
        int i = 0;
        for (Sach sach : danhmucHD) {
            System.out.format("| %-10s | %-22s | %-25s | %-18s | %-15s |%-15s |\n",
                    "S" + sach.getMaSach(), sach.getTenSach(), sach.getTacGia(),
                    sach.getTheLoai(), quantity.get(i), sach.getGiaSach());
            i++;
        }
    }

    public void inThongTinBanDoc(BanDoc banDoc) {
        if (banDoc == null) {
            System.out.println("Thông tin bạn đọc trống!");
        } else {
            System.out.format("| %-14s | %-25s | %-10s | %-10s | %-15s | %-25s | %-15s |\n",
                    "Mã SV", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Email", "Lớp");
            banDoc.xuat();
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

    public int checkInputSoLuong(int soLuong, Sach sach) {
        while (soLuong <= 0 || soLuong > sach.getSoLuongTong()) {
            if (soLuong <= 0) {
                System.out.println("Vui lòng nhập só lượng lớn hơn 0!");
            } else {
                System.out.println("Số lượng trong thư viện không đủ so với số lượng nhập! (còn lại " + sach.getSoLuongTong() + ")");
            }
            System.out.print("Nhập số lượng sách: ");
            soLuong = (new Scanner(System.in)).nextInt();
        }
        return soLuong;
    }

    public void muonSach() throws InterruptedException {
        GiaoDienQuanLyMuonTraSach gd = new GiaoDienQuanLyMuonTraSach(1);
        List<Sach> danhmucHD = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        BanDocController banDocMn = new BanDocController();
        BanDoc banDoc = null;
        HoaDonController hoaDonMn = new HoaDonController();
        HoaDon hoaDon;
        ChiTietHoaDonController chiTietHdMn = new ChiTietHoaDonController();

        boolean isRun = true;

        while (isRun) {
            Thread.sleep(50);
            System.out.println(" *********************************************************** ");
            System.out.println(" *                       MƯỢN SÁCH                         * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *              1. Thêm sách vào hóa đơn                   * ");
            System.out.println(" *              2. Sửa thông tin sách trong hóa đơn        * ");
            System.out.println(" *              3. Xóa sách trong hóa đơn                  * ");
            System.out.println(" *              4. Nhập thông tin bạn đọc                  * ");
            System.out.println(" *              5. Thanh toán                              * ");
            System.out.println(" *              6. Xem danh sách                           * ");
            System.out.println(" *              0. Quay lại                                * ");
            System.out.println(" *********************************************************** ");

            System.out.println("");
            gd.inDanhMucHD(danhmucHD, quantities);
            System.out.println("");
            gd.inThongTinBanDoc(banDoc);
            System.out.println("");

            System.out.print("Mời bạn chọn chức năng: ");

            int key = Integer.parseInt((new Scanner(System.in)).nextLine());
            while (key < 0 || key > 6) {
                System.out.print("Yêu cầu nhập lại chức năng: ");
                key = Integer.parseInt((new Scanner(System.in)).nextLine());
            }

            int index;
            String ma;
            int quantity;
            Date ngayMuon, ngayTra;
            List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();

            switch (key) {
                case 1:
                    System.out.println("Bạn lựa chọn thêm sách mới vào hóa đơn!");
                    System.out.print("Nhập mã sách: ");
                    ma = (new Scanner(System.in)).nextLine();
                    ma = checkInputMaSach(ma, sachMn.getList());
                    if (ma.equals("huy")) {
                        break;
                    }
                    System.out.print("Nhập số lượng sách: ");
                    quantity = (new Scanner(System.in)).nextInt();
                    quantity = checkInputSoLuong(quantity, sachMn.getList().get(Integer.parseInt(ma)));
                    danhmucHD.add(sachMn.getList().get(Integer.parseInt(ma)));
                    quantities.add(quantity);
                    break;
                case 2:
                    System.out.println("Bạn lựa chọn sửa thông tin sách trong hóa đơn!");
                    System.out.print("Nhập mã sách muốn sửa: ");
                    ma = (new Scanner(System.in)).nextLine();
                    ma = checkInputMaSach(ma, danhmucHD);
                    if (ma.equals("huy")) {
                        break;
                    }
                    System.out.print("Nhập số lượng sách sửa: ");
                    quantity = (new Scanner(System.in)).nextInt();
                    quantity = checkInputSoLuong(quantity, sachMn.getList().get(Integer.parseInt(ma)));
                    index = Integer.parseInt(ma);
                    quantities.set(index, quantity);
                    break;
                case 3:
                    System.out.println("Bạn lựa chọn xóa thông tin sách trong hóa đơn!");
                    System.out.print("Nhập mã sách muốn xóa: ");
                    ma = (new Scanner(System.in)).nextLine();
                    ma = checkInputMaSach(ma, danhmucHD);
                    if (ma.equals("huy")) {
                        break;
                    }
                    index = Integer.parseInt(ma);
                    danhmucHD.remove(index);
                    quantities.remove(index);
                    break;
                case 4:
                    System.out.println("Bạn lựa chọn nhập thông tin bạn đọc!");
                    System.out.println("Nhập thông tin bạn đọc: ");
                    banDoc = new BanDoc();
                    banDoc.nhap();
                    break;
                case 5:
                    if (danhmucHD.size() <= 0 || banDoc == null) {
                        System.out.println("Vui lòng nhập đầy đủ thông tin!");
                    } else {
                        System.out.println("Bạn có chắc chắn muốn thanh toán không?");
                        System.out.print("Bấm 'yes' để xác nhận, bấm bất kỳ khác để hủy: ");
                        ma = (new Scanner(System.in)).nextLine();
                        if (!ma.equals("yes")) {
                            break;
                        }
                        // Them vao hoa don
                        int sum = 0,
                                totalMoney = 0;
                        for (int i = 0; i < danhmucHD.size(); i++) {
                            sum += quantities.get(i);
                            totalMoney += danhmucHD.get(i).getGiaSach() * quantities.get(i);
                        }
                        ngayMuon = new Date();
                        System.out.print("Nhập ngày mượn: ");
                        ngayMuon.setNgay((new Scanner(System.in)).nextInt());
                        System.out.print("Nhập tháng mượn: ");
                        ngayMuon.setThang((new Scanner(System.in)).nextInt());
                        System.out.print("Nhập năm mượn: ");
                        ngayMuon.setNam((new Scanner(System.in)).nextInt());
                        ngayTra = new Date();
                        System.out.print("Nhập ngày trả: ");
                        ngayTra.setNgay((new Scanner(System.in)).nextInt());
                        System.out.print("Nhập tháng trả: ");
                        ngayTra.setThang((new Scanner(System.in)).nextInt());
                        System.out.print("Nhập năm trả: ");
                        ngayTra.setNam((new Scanner(System.in)).nextInt());
                        banDocMn.them(banDoc);
                        hoaDon = new HoaDon(-1, sum, totalMoney, banDocMn.timMa(banDoc), maThuThu, ngayMuon, ngayTra, "Chưa trả");
                        hoaDonMn.them(hoaDon);
                        index = hoaDonMn.timMaHoaDon(hoaDon);
                        for (int i = 0; i < danhmucHD.size(); i++) {
                            chiTietHoaDons.add(new ChiTietHoaDon(index, danhmucHD.get(i).getMaSach(), danhmucHD.get(i).getGiaSach(), quantities.get(i)));
                            chiTietHdMn.them(chiTietHoaDons.get(i));

                            Sach s = sachMn.getList().get(sachMn.tim(danhmucHD.get(i).getMaSach(), sachMn.getList()));
                            s = new Sach(s.getMaSach(), s.getTenSach(), s.getTacGia(), s.getNhaCungCap(),
                                    s.getNgayNhap(), s.getSoLuongTong() - quantities.get(i), s.getTheLoai(), s.getGiaSach());
                            sachMn.sua(s, s.getMaSach());
                        }
                        System.out.print("Thanh toán thành công! ");
                    }
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    ma = (new Scanner(System.in)).nextLine();
                    break;
                case 6:
                    System.out.println("\nDanh sách sách có trong thư viện:");
                    sachMn.xemDanhSach();
                    System.out.println("");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    ma = (new Scanner(System.in)).nextLine();
                    break;
                case 0:
                    isRun = false;
                    break;
                default:
                    System.out.print("Vui lòng nhập lại: ");
            }

            clearScreen();
        }
    }

    public void xemHoaDonMuonSach() {
        HoaDonController hoaDonMn = new HoaDonController();
        List<HoaDon> listHoaDon = hoaDonMn.getList();
        ChiTietHoaDonController chiTietMn = new ChiTietHoaDonController();
        List<ChiTietHoaDon> listChiTiet = chiTietMn.getList();
        BanDocController banDocMn = new BanDocController();
        boolean isRun = true;
        System.out.println("Bạn chọn chức năng xem hóa đơn mượn sách!");

        while (isRun) {
            System.out.println("/--------------------------------------------------------------------------------"
                    + "--------------------------------\\");
            System.out.format("| %-5s | %-8s | %-8s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                    "STT", "Mã HD", "Só lượng", "Tổng tiền", "Mã thủ thư", "Mã bạn đọc", "Ngày mượn", "Ngày trả", "Trạng thái");
            System.out.println("|--------------------------------------------------------------------------------"
                    + "--------------------------------|");
            for (int i = 0; i < listHoaDon.size(); i++) {
                System.out.format("| %-5s | %-8s | %-8s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                        i + 1, "HD" + listHoaDon.get(i).getMaHoaDon(), listHoaDon.get(i).getSoLuongSach(), listHoaDon.get(i).getTongSoTien(),
                        "TT" + listHoaDon.get(i).getMaThuThu(), "SV" + listHoaDon.get(i).getMaBanDoc(), listHoaDon.get(i).getNgayMuon(),
                        listHoaDon.get(i).getNgayTra(), listHoaDon.get(i).getStatus());
            }
            System.out.println("\\--------------------------------------------------------------------------------"
                    + "--------------------------------/");
            System.out.print("\nNhập số thứ tự của hóa đơn để xem chi tiết hóa đơn: ");
            int key = (new Scanner(System.in)).nextInt();

            while (key <= 0 || key > listHoaDon.size()) {
                System.out.print("\nBạn nhập số thứ tự vượt quá hoặc không hợp lệ."
                        + "\nYêu cầu nhập lại (hoặc bấm '-1' để quay lại): ");
                key = (new Scanner(System.in)).nextInt();
                if (key == -1) {
                    break;
                }
            }

            if (key == -1) {
                break;
            }

            System.out.println("");
            System.out.println("Thông tin chi tiết hóa đơn:");
            System.out.format("| %-5s | %-8s | %-10s | %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-15s |\n",
                    "STT", "Mã HD", "Số lượng", "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp",
                    "Thể loại", "Ngày nhập", "Giá sách");
            int j = 1;
            for (int i = 0; i < listChiTiet.size(); i++) {
                if (listChiTiet.get(i).getMaHD() == listHoaDon.get(key - 1).getMaHoaDon()) {
                    int maSach = listChiTiet.get(i).getMaSach();
                    System.out.format("| %-5s | %-8s | %-10s ",
                            j, "HD" + listChiTiet.get(i).getMaHD(), listChiTiet.get(i).getSoLuong());
                    sachMn.getList().get(sachMn.tim(maSach, sachMn.getList())).xuat(true);
                    j++;
                }
            }
            System.out.println("");
            System.out.println("Thông tin chi tiết bạn đọc mượn sách:");
            inThongTinBanDoc(banDocMn.timBanDoc(listHoaDon.get(key - 1).getMaBanDoc()));
            System.out.println("");
            System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
            String s = (new Scanner(System.in)).nextLine();
            clearScreen();
        }
        clearScreen();
    }

    public void traSach() {
        HoaDonController hoaDonMn = new HoaDonController();
        List<HoaDon> listHoaDon = hoaDonMn.getList();
        ChiTietHoaDonController chiTietMn = new ChiTietHoaDonController();
        List<ChiTietHoaDon> listChiTiet = chiTietMn.getList();
        BanDocController banDocMn = new BanDocController();
        boolean isRun = true;
        System.out.println("Bạn chọn trả sách!");

        while (isRun) {
            System.out.println("/--------------------------------------------------------------------------------"
                    + "--------------------------------\\");
            System.out.format("| %-5s | %-8s | %-8s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                    "STT", "Mã HD", "Só lượng", "Tổng tiền", "Mã thủ thư", "Mã bạn đọc", "Ngày mượn", "Ngày trả", "Trạng thái");
            System.out.println("|-------|----------|----------|-----------------|------------|------------|-------"
                    + "-----|------------|------------|");
            for (int i = 0; i < listHoaDon.size(); i++) {
                System.out.format("| %-5s | %-8s | %-8s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                        i + 1, "HD" + listHoaDon.get(i).getMaHoaDon(), listHoaDon.get(i).getSoLuongSach(), listHoaDon.get(i).getTongSoTien(),
                        "TT" + listHoaDon.get(i).getMaThuThu(), "SV" + listHoaDon.get(i).getMaBanDoc(), listHoaDon.get(i).getNgayMuon(), listHoaDon.get(i).getNgayTra(), listHoaDon.get(i).getStatus());
            }
            System.out.println("\\--------------------------------------------------------------------------------"
                    + "--------------------------------/");
            System.out.print("\nNhập số thứ tự của hóa đơn để xem chi tiết hóa đơn: ");
            int key = (new Scanner(System.in)).nextInt();

            while (key <= 0 || key > listHoaDon.size()) {
                System.out.print("\nBạn nhập số thứ tự vượt quá hoặc không hợp lệ."
                        + "\nYêu cầu nhập lại (hoặc bấm '-1' để quay lại): ");
                key = (new Scanner(System.in)).nextInt();
                if (key == -1) {
                    break;
                }
            }

            if (key == -1) {
                break;
            }

            System.out.println("");

            System.out.println("Thông tin chi tiết hóa đơn:");
            System.out.format("| %-5s | %-8s | %-10s | %-10s | %-22s | %-25s | %-20s | %-18s | %-15s | %-15s |\n",
                    "STT", "Mã HD", "Số lượng", "Mã sách", "Tên sách", "Tác giả", "Nhà cung cấp",
                    "Thể loại", "Ngày nhập", "Giá sách");
            int j = 1;
            for (int i = 0; i < listChiTiet.size(); i++) {
                if (listChiTiet.get(i).getMaHD() == listHoaDon.get(key - 1).getMaHoaDon()) {
                    int maSach = listChiTiet.get(i).getMaSach();
                    System.out.format("| %-5s | %-8s | %-10s ",
                            j, "HD" + listChiTiet.get(i).getMaHD(), listChiTiet.get(i).getSoLuong());
                    sachMn.getList().get(sachMn.tim(maSach, sachMn.getList())).xuat(true);
                    j++;
                }
            }
            System.out.println("");
            System.out.println("Thông tin chi tiết bạn đọc mượn sách:");
            inThongTinBanDoc(banDocMn.timBanDoc(listHoaDon.get(key - 1).getMaBanDoc()));
            System.out.println("");
            System.out.print("Nhập 'yes' để xác nhận trả sách! Nhập bất kỳ khác để hủy: ");
            String str = (new Scanner(System.in)).nextLine();

            if (str.equals("yes")) {
                HoaDon hd = new HoaDon(listHoaDon.get(key - 1).getMaHoaDon(), listHoaDon.get(key - 1).getSoLuongSach(),
                        listHoaDon.get(key - 1).getTongSoTien(), listHoaDon.get(key - 1).getMaBanDoc(), listHoaDon.get(key - 1).getMaThuThu(),
                        listHoaDon.get(key - 1).getNgayMuon(), listHoaDon.get(key - 1).getNgayTra(), "Đã trả");
                hoaDonMn.sua(hd, listHoaDon.get(key - 1).getMaHoaDon());

                for (int i = 0; i < listChiTiet.size(); i++) {
                    if (listChiTiet.get(i).getMaHD() == listHoaDon.get(key - 1).getMaHoaDon()) {
                        int maSach = listChiTiet.get(i).getMaSach();
                        Sach s = sachMn.getList().get(sachMn.tim(maSach, sachMn.getList()));
                        s = new Sach(s.getMaSach(), s.getTenSach(), s.getTacGia(), s.getNhaCungCap(),
                                s.getNgayNhap(), s.getSoLuongTong() + listChiTiet.get(i).getSoLuong(), s.getTheLoai(), s.getGiaSach());
                        sachMn.sua(s, s.getMaSach());
                    }
                }
                

                System.out.print("Thành công! Nhấn phím bất kỳ để tiếp tục! ");
                str = (new Scanner(System.in)).nextLine();
                listHoaDon = new HoaDonController().getList();
            }
            clearScreen();
        }
        clearScreen();
    }

    public void run() throws InterruptedException {
        boolean isRun = true;

        while (isRun) {
            Thread.sleep(50);
            System.out.println(" *********************************************************** ");
            System.out.println(" *                       MƯỢN TRẢ SÁCH                     * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *                     1. Mượn sách                        * ");
            System.out.println(" *                     2. Trả sách                         * ");
            System.out.println(" *                     3. Xem hóa đơn mượn sách            * ");
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
                    muonSach();
                    break;
                case 2:
                    clearScreen();
                    traSach();
                    break;
                case 3:
                    clearScreen();
                    xemHoaDonMuonSach();
                    break;
                case 0:
                    isRun = false;
                    break;
                default:
                    System.out.print("Vui lòng nhập lại: ");
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new GiaoDienQuanLyMuonTraSach(0).run();
    }
}

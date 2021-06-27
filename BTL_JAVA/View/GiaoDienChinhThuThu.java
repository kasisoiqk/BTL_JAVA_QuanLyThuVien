package BTL_JAVA.View;

import BTL_JAVA.Model.ThuThu;
import java.awt.Robot;
import java.util.Scanner;

public class GiaoDienChinhThuThu {
    
    private ThuThu tt;

    public GiaoDienChinhThuThu(ThuThu tt) {
        this.tt = tt;
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
    
    public void run() {
        boolean isRun = true;
        while(isRun) {
            System.out.println(" *********************************************************** ");
            System.out.format(" *                THỦ THƯ - %-22s         * \n", tt.getTen());
            System.out.println(" *********************************************************** ");
            System.out.println(" *            1. Quản lý sách trong thư viện               * ");
            System.out.println(" *            2. Quản lý mượn trả sách                     * ");
            System.out.println(" *            3. Quản lý danh sách bạn đọc                 * ");
            System.out.println(" *            0. Đăng xuất                                 * ");
            System.out.println(" *********************************************************** ");
            System.out.print(" Lựa chọn chức năng: ");
            int key = (new Scanner(System.in)).nextInt();
            String str;
            
            switch(key) {
                case 1:
                    clearScreen();
                    System.out.println("Bạn chọn quản lý sách trong thư viện!");
                    new GiaoDienQuanLySach().run();
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Bạn chọn quản lý mượn trả sách!");
                    new GiaoDienQuanLyMuonTraSach(this.tt.getMa()).run();
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 3:
                    clearScreen();
                    System.out.println("Bạn chọn quản lý danh sách bạn đọc!");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 0:
                    isRun = false;
                    break;
                default:
                    System.out.print("Vui lòng nhập lại: ");
            }
        }
    }
}

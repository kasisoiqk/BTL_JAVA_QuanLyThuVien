package BTL_JAVA.View;

import BTL_JAVA.View.GiaoDienQuanLyThuThu;
import BTL_JAVA.View.GiaoDienQuanLyTaiKhoan;
import java.awt.Robot;
import java.util.Scanner;

public class GiaoDienChinhQuanTri {
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
    
    public void run() throws InterruptedException {
        boolean isRun = true;
        while(isRun) {
            Thread.sleep(50);
            System.out.println(" *********************************************************** ");
            System.out.println(" *                 - QUẢN TRỊ HỆ THỐNG -                   * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *                1. Quản lý tài khoản                     * ");
            System.out.println(" *                2. Quản lý thủ thư                       * ");
            System.out.println(" *                0. Đăng xuất                             * ");
            System.out.println(" *********************************************************** ");
            System.out.print(" Lựa chọn chức năng: ");
            int key = (new Scanner(System.in)).nextInt();
            String str;
            
            switch(key) {
                case 1:
                    clearScreen();
                    System.out.println("Bạn chọn quản lý tài khoản!");
                    new GiaoDienQuanLyTaiKhoan().run();
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Bạn chọn quản lý thủ thư!");
                    new GiaoDienQuanLyThuThu().run();
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 0:
                    System.out.print("Bạn có chắc chắn muốn đăng xuất? (Nhập 'yes' để xác nhận nhập khác để hủy): ");
                    str = (new Scanner(System.in)).nextLine();
                    if(str.equals("yes")) {
                        isRun = false;
                    }
                    else {
                        clearScreen();
                    }
                    break;
                default:
                    System.out.print("Vui lòng nhập lại: ");
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL_JAVA.View;

import BTL_JAVA.Controller.TaiKhoanController;
import BTL_JAVA.Controller.ThuThuController;
import BTL_JAVA.Model.TaiKhoan;
import BTL_JAVA.Model.ThuThu;
import java.awt.Robot;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class GiaoDienDangNhap {

    private List<TaiKhoan> list;
    private TaiKhoanController tkMn;

    private String username;
    private String password;

    public GiaoDienDangNhap() {
        tkMn = new TaiKhoanController();
        list = tkMn.getList();
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

    public void dangNhap() throws InterruptedException {
        System.out.print("Tên tài khoản: ");
        this.username = (new Scanner(System.in)).nextLine();
        System.out.print("Mật khẩu: ");
        this.password = (new Scanner(System.in)).nextLine();
        list = tkMn.getList();

        TaiKhoan taiKhoan = tkMn.tim(username, password);
        if (taiKhoan == null) {
            System.out.println("Bạn nhập sai tên tài khoản hoặc mật khẩu! Đăng nhập thất bại!");
        } else {
//            System.out.println("Đăng nhập thành công!");
//            System.out.println("Bạn là: " + taiKhoan.getPhanQuyen());
            if(taiKhoan.getPhanQuyen().equals("Thu thu")) {
                ThuThuController thuThuMn = new ThuThuController();
                ThuThu thuThu = thuThuMn.tim(taiKhoan.getMaTk());
                clearScreen();
                new GiaoDienChinhThuThu(thuThu).run();
            }
            else {
                clearScreen();
                new GiaoDienChinhQuanTri().run();
            }
        }
    }

    public void doiMatKhau() {
        System.out.print("Tên tài khoản: ");
        this.username = (new Scanner(System.in)).nextLine();
        System.out.print("Mật khẩu: ");
        this.password = (new Scanner(System.in)).nextLine();
        System.out.print("Mật khẩu mới: ");
        String newPass = (new Scanner(System.in)).nextLine();
        System.out.print("Nhập lại mật khẩu: ");
        String newPass2 = (new Scanner(System.in)).nextLine();
        list = tkMn.getList();

        TaiKhoan taiKhoan = tkMn.tim(username, password);
        if (taiKhoan == null) {
            System.out.println("Bạn nhập sai tên tài khoản hoặc mật khẩu!\nĐổi mật khẩu thất bại!");
        } else {
            if (newPass.equalsIgnoreCase(newPass2)) {
                taiKhoan = new TaiKhoan(taiKhoan.getMaTk(), username, newPass, taiKhoan.getPhanQuyen());
                tkMn.sua(taiKhoan, taiKhoan.getMaTk());
                System.out.println("Đổi mật khẩu thành công!");
            } else {
                System.out.println("Mật khẩu nhập lại không giống với mật khẩu đã nhập trước đó!\nĐổi mật khẩu thất bại!");
            }
        }
    }

    public void run() throws InterruptedException {
        GiaoDienDangNhap gd = new GiaoDienDangNhap();
        TaiKhoan t = new TaiKhoan();
        int luaChon;
        do {
            list = tkMn.getList();
            Thread.sleep(50);
            System.out.println(" *********************************************************** ");
            System.out.println(" *                   ĐĂNG NHẬP HỆ THỐNG                    * ");
            System.out.println(" *********************************************************** ");
            System.out.println(" *                   1. Đăng nhập                          * ");
            System.out.println(" *                   2. Đổi mật khẩu                       * ");
            System.out.println(" *                   0. Thoát                              * ");
            System.out.println(" *********************************************************** ");
            System.out.print(" Lựa chọn chức năng: ");

            luaChon = (new Scanner(System.in)).nextInt();
            String str;

            switch (luaChon) {
                case 1:
                    gd.dangNhap();
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 2:
                    gd.doiMatKhau();
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
                    break;
                case 0:
                    System.out.print("Bạn có chắc chắn muốn thoát? (Nhập 'yes' để xác nhận nhập khác để hủy): ");
                    str = (new Scanner(System.in)).nextLine();
                    if(!str.equals("yes")) {
                        luaChon = -1;
                    }
                    break;
                default:
                    System.out.println("Mời bạn nhập lại!");
                    System.out.print("Nhấn phím bất kỳ để tiếp tục! ");
                    str = (new Scanner(System.in)).nextLine();
                    clearScreen();
            }
        } while (luaChon != 0);

    }

}

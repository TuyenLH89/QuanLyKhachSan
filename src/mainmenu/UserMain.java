package mainmenu;

import models.User;
import services.UserService;

import java.util.Scanner;

public class UserMain {
    public static UserService userService = new UserService();
    public static Menu menu = new Menu();

    public static void login(){
        String userName, password;
        System.out.printf("Nhập tên đăng nhập: ");
        userName = new Scanner(System.in).nextLine();
        System.out.printf("Nhập tên mật khẩu: ");
        password = new Scanner(System.in).nextLine();
        boolean check = userService.checkLogin(userName, password);
        if (check){
            if (userService.user.getRole().equals("Admin")){
                System.out.println("Xin chào quản lý "+userService.user.getUserName());
                adminManage();
            }else {
                System.out.println("Xin chào nhân viên "+userService.user.getUserName());
                userManage();
            }
        }else {
            System.out.println("Tài khoản đăng nhập không đúng. Hãy đăng nhập lại!!!");
            menu.menu();
        }
    }
    public static void addNhanVien(){
        String userName, password;
        System.out.printf("Nhập tên đăng nhập: ");
        userName = new Scanner(System.in).nextLine();
        System.out.printf("Nhập tên mật khẩu: ");
        password = new Scanner(System.in).nextLine();
        boolean check = userService.checkDangKy(userName);
        if (check){
            User user = new User(userName, password);
            userService.add(user);
            System.out.println("Đã thêm nhân viên thành công");
            adminManageNV();
        }else {
            System.out.println("Tên đăng nhập đã tồn tại. Vui lòng đăng ký lại");
            adminManageNV();
        }
    }
    public static void deleteNhanVien(){
        long idUser;
        System.out.printf("Nhập ID nhân viên: ");
        idUser = new Scanner(System.in).nextLong();
        boolean check = userService.checkId(idUser);
        if (check){
            userService.deleteById(idUser);
            System.out.println("Đã xóa thành công nhân viên");
            adminManageNV();
        }else {
            System.out.println("Không tồn tại nhân viên này");
            adminManageNV();
        }
    }
    public static void inDanhSachNV(){
        userService.printList();
        adminManageNV();
    }
    public static void adminManageNV(){
        int luaChon = 0;
        do {
            try {
                System.out.println("1. Thêm nhân viên");
                System.out.println("2. Xóa nhân viên");
                System.out.println("3. In danh sách nhân viên");
                System.out.println("4. Quay lại menu");
                System.out.printf("Xin mời nhập lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                if (luaChon < 1 || luaChon > 4){
                    System.out.println("Không có lựa chọn này. Hãy chọn lại!!!");
                }
            }catch (Exception e){
                adminManageNV();
            }
        }while (luaChon < 1 || luaChon > 4);
        switch (luaChon){
            case 1:
                addNhanVien();
                break;
            case 2:
                deleteNhanVien();
                break;
            case 3:
                inDanhSachNV();
                break;
            case 4:
                adminManage();
                break;
        }
    }
    public static void adminManage(){
        int luaChon = 0;
        do {
            try {
                System.out.println("1. Quản lý phòng");
                System.out.println("2. Quản lý khách hàng");
                System.out.println("3. Quản lý nhân viên");
                System.out.println("4. Quay lại Menu");
                System.out.printf("Xin mời nhập lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                if (luaChon < 1 || luaChon > 4){
                    System.out.println("Không có lựa chọn này. Hãy chọn lại!!!");
                }
            }catch (Exception e){
                adminManage();
            }
        }while (luaChon < 1 || luaChon > 4);
        switch (luaChon){
            case 1:
                RoomMain.roomManage();
                break;
            case 2:
                CustomerMain.customerManage();
                break;
            case 3:
                adminManageNV();
                break;
            case 4:
                Menu.menu();
                break;
        }

    }
    public static void userManage(){
        int luaChon = 0;
        do {
            try {
                System.out.println("1. Quản lý phòng");
                System.out.println("2. Quản lý khách hàng");
                System.out.println("3. Quay lại Menu");
                System.out.printf("Xin mời nhập lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                if (luaChon < 1 || luaChon > 3){
                    System.out.println("Không có lựa chọn này. Hãy chọn lại!!!");
                }
            }catch (Exception e){
                userManage();
            }
        }while (luaChon < 1 || luaChon > 3);
        switch (luaChon){
            case 1:
                RoomMain.roomManage();
                break;
            case 2:
                CustomerMain.customerManage();
                break;
            case 3:
                Menu.menu();
                break;
        }

    }

}

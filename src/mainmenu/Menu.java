package mainmenu;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        int luaChon = 1;
        do {
            try {
                System.out.println("1. Đăng nhập");
                System.out.println("0. Thoát chương trình");
                System.out.printf("Bạn hãy nhập lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                if (luaChon < 0 || luaChon > 1)
                    System.out.println("Không có lựa chọn này. Hãy nhập lại!!!");
            }catch (Exception e){
                menu();
            }
        }while (luaChon < 0 || luaChon > 1);
        switch (luaChon){
            case 1:
                UserMain.login();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}

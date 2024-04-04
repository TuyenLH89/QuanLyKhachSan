package mainmenu;

import models.Room;
import services.RoomService;

import java.util.Scanner;

public class RoomMain {
    public static RoomService roomService = new RoomService();
    public static void roomManage(){
        int luaChon = 0;
        do {
            try {
                System.out.println("1. Thêm phòng");
                System.out.println("2. Cập nhật phòng");
                System.out.println("3. Xóa phòng");
                System.out.println("4. Hiển thị danh sách phòng");
                System.out.println("5. Quay lại menu quản lí");
                System.out.printf("Xin mời nhập lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                if (luaChon < 1 || luaChon > 5){
                    System.out.println("Không có lựa chọn này. Hãy chọn lại!!!");
                }
            }catch (Exception e){
                roomManage();
            }
        }while (luaChon < 1 || luaChon > 5);
        switch (luaChon){
            case 1:
                addRoom();
                break;
            case 2:
                capNhatRoom();
                break;
            case 3:
                xoaPhong();
                break;
            case 4:
                hienThiPhong();
                break;
            case 5:
                UserMain.adminManage();
                break;
        }
    }
    public static void addRoom(){
        int numberOfBedroom, numberOfBathroom, price;
        String status;
        try {
            System.out.printf("Nhập số phòng ngủ: ");
            numberOfBedroom = new Scanner(System.in).nextInt();
            System.out.printf("Nhập số phòng tắm: ");
            numberOfBathroom = new Scanner(System.in).nextInt();
            System.out.printf("Nhập giá: ");
            price = new Scanner(System.in).nextInt();
            System.out.printf("Nhập tình trạng phòng: ");
            status = new Scanner(System.in).nextLine();
            Room room = new Room(numberOfBedroom,numberOfBathroom,price,status);
            roomService.add(room);
            System.out.println("Đã thêm phòng thành công");
            RoomMain.roomManage();
        }catch (Exception e){
            addRoom();
        }
    }
    public static void capNhatRoom(){
        long id;
        int price;
        String status;
        try {
            System.out.printf("Nhập số phòng cần cập nhật: ");
            id = new Scanner(System.in).nextLong();
            boolean check = roomService.checkId(id);
            if (check){
                roomService.findById(id);
                System.out.println("Nhập thông tin cần sửa đổi.");
                System.out.printf("Nhập giá: ");
                price = new Scanner(System.in).nextInt();
                System.out.printf("Nhập tình trạng phòng: ");
                status = new Scanner(System.in).nextLine();
                Room room = new Room(price,status);
                roomService.updateById(id, room);
                System.out.println("Cập nhật phòng thành công");
            }else {
                System.out.println("Không tồn tại phòng này!!!");
            }
            RoomMain.roomManage();
        }catch (Exception e){
            capNhatRoom();
        }
    }
    public static void xoaPhong(){
        long roomNumber;
        try {
            System.out.printf("Nhập số phòng cần xóa: ");
            roomNumber = new Scanner(System.in).nextLong();
            boolean check = roomService.checkId(roomNumber);
            if (check){
                roomService.deleteById(roomNumber);
                System.out.println("Đã xóa thành công");
                RoomMain.roomManage();
            }else
                System.out.println("Không tồn tại phòng này");
            RoomMain.roomManage();
        }catch (Exception e){
            xoaPhong();
        }
    }
    public static void hienThiPhong(){
        roomService.printList();
        RoomMain.roomManage();
    }
}

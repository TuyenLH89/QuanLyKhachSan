package mainmenu;

import models.Customer;
import services.CustomerService;

import java.util.Scanner;

public class CustomerMain {
    public static CustomerService customerService = new CustomerService();
    public static void customerManage(){
        int luaChon = 0;
        do {
            try {
                System.out.println("1. Thêm khách hàng");
                System.out.println("2. Xóa khách hàng");
                System.out.println("3. Cập nhật thông tin khách hàng");
                System.out.println("4. Hiển thị danh sách khách hàng");
                System.out.println("5. Quay lại menu quản lý");
                System.out.printf("Nhập lựa chọn: ");
                luaChon = new Scanner(System.in).nextInt();
                if (luaChon < 1 || luaChon > 5)
                    System.out.println("Không có lựa chọn này");
            }catch (Exception e){
                customerManage();
            }
        }while (luaChon < 1 || luaChon > 5);
        switch (luaChon){
            case 1:
                addCustomer();
                break;
            case 2:
                deleteCustomer();
                break;
            case 3:
                capNhatCustomer();
                break;
            case 4:
                hienThiCustomer();
                break;
            case 5:
                UserMain.adminManage();
                break;
        }
    }
    public static void addCustomer(){
        String citizenIdentificationCard, phoneNumber;
        int age;
        try {
            System.out.printf("Nhập căn cước công dân: ");
            citizenIdentificationCard = new Scanner(System.in).nextLine();
            System.out.printf("Nhập số điện thoại: ");
            phoneNumber = new Scanner(System.in).nextLine();
            System.out.printf("Nhập tuổi: ");
            age = new Scanner(System.in).nextInt();
            Customer customer = new Customer(citizenIdentificationCard, phoneNumber, age);
            customerService.add(customer);
            System.out.println("Dẫ thêm khách hàng thành công!!!");
            customerManage();
        }catch (Exception e){
            addCustomer();
        }
    }
    public static void deleteCustomer(){
        long idCustomer;
        try {
            System.out.printf("Nhập vào ID của khách hàng: ");
            idCustomer = new Scanner(System.in).nextLong();
            boolean check = customerService.checkId(idCustomer);
            if (check){
                customerService.deleteById(idCustomer);
                System.out.println("Đã xóa khách hàng thành công");
                customerManage();
            }else {
                System.out.println("Khách hàng không tồn tại. Hãy kiểm tra lại");
                customerManage();
            }
        }catch (Exception e){
            deleteCustomer();
        }
    }
    public static void capNhatCustomer(){
        long idCustomer;
        try {
            System.out.printf("Nhập vào ID của khách hàng: ");
            idCustomer = new Scanner(System.in).nextLong();
            String citizenIdentificationCard, phoneNumber;
            int age;
            boolean check = customerService.checkId(idCustomer);
            if (check){
                customerService.findById(idCustomer);
                System.out.println("Nhập các thông tin cần thay đổi");
                System.out.printf("Nhập CCCD: ");
                citizenIdentificationCard = new Scanner(System.in).nextLine();
                System.out.printf("Nhập số điện thoại: ");
                phoneNumber = new Scanner(System.in).nextLine();
                System.out.printf("Nhập tuổi: ");
                age = new Scanner(System.in).nextInt();
                Customer customer = new Customer(citizenIdentificationCard,phoneNumber,age);
                customerService.updateById(idCustomer, customer);
                System.out.println("Đã cập nhật thành công thông tin khách hàng");
                customerManage();
            }else {
                System.out.println("Không tồn tại khách hàng này. Hãy kiểm tra lại!!!");
                customerManage();
            }
        }catch (Exception e){
            capNhatCustomer();
        }
    }
    public static void hienThiCustomer(){
        customerService.printList();
        customerManage();
    }

}

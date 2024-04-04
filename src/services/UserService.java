package services;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Management<User> {
    public static List<User> userList = new ArrayList<>();
    public static User user;
    static {
        initUser();
    }

    private static void initUser() {
        User user = new User();
        user.setUserName("admin");
        user.setId(userList.size()+1);
        user.setPassword("123");
        user.setRole("Admin");
        userList.add(user);
    }

    @Override
    public User findById(long id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id)
                return userList.get(i);
        }
        return null;
    }

    @Override
    public void printList() {
        System.out.printf("%-16s%-26s%-26s%n", "Id:", "User Name:", "Role:");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    @Override
    public void updateById(long id, User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id){
                if (user.getUserName() != null)
                    userList.get(i).setUserName(user.getUserName());
                if (user.getPassword() != null)
                    userList.get(i).setPassword(user.getPassword());
            }
        }
    }

    @Override
    public void add(User user) {
        user.setId(userList.size()+1);
        user.setRole("User");
        userList.add(user);
    }

    @Override
    public void deleteById(long id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id){
                userList.remove(i);
                return;
            }
        }
    }
    public boolean checkId(long idUser){
        for (int i = 1; i < userList.size(); i++) {
            if (userList.get(i).getId() == idUser)
                return true;
        }
        return false;
    }
    public boolean checkLogin(String userName, String password){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName) && userList.get(i).getPassword().equals(password)){
                user = userList.get(i);
                return true;
            }
        }
        return false;
    }
    public boolean checkDangKy(String userName){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName))
                return false;
        }
        return true;
    }
}

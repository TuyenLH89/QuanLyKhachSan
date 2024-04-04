package services;

import models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomService implements Management<Room> {
    public static List<Room> roomList = new ArrayList<>();
    static {
        initRoom();

    }

    private static void initRoom() {
        Room room = new Room(1,3,2,250,"Trống");
        Room room1 = new Room(2,5,2,500,"Trống");
        Room room2 = new Room(3,3,1,200,"Trống");
        roomList.add(room);
        roomList.add(room1);
        roomList.add(room2);
    }

    @Override
    public Room findById(long id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomNumber() == id)
                return roomList.get(i);

        }
        return null;
    }

    @Override
    public void printList() {
        System.out.printf("%-16s%-26s%-26s%-26s%-26s%n", "Room Number:", "Status:", "Number Of Bed rooms", "Number Of Bath Rooms", "Price");
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println(roomList.get(i));
        }
    }

    @Override
    public void updateById(long id, Room room) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomNumber() == id){
                if (room.getPrice() != roomList.get(i).getPrice())
                    roomList.get(i).setPrice(room.getPrice());
                if (room.getStatus() != null)
                    roomList.get(i).setStatus(room.getStatus());
            }
        }
    }

    @Override
    public void add(Room room) {
        room.setRoomNumber(roomList.size()+1);
        roomList.add(room);
    }

    @Override
    public void deleteById(long id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomNumber() == id){
                roomList.remove(i);
                return;
            }
        }
    }
    public boolean checkId(long roomNember){
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomNumber() == roomNember)
                return true;
        }
        return false;
    }
}

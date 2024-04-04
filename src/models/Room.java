package models;

public class Room {
    private long roomNumber, numberOfBedroom, numberOfBathroom, price;
    private String status;

    public Room() {
    }

    public Room(long roomNumber, long numberOfBedroom, long numberOfBathroom, long price, String status) {
        this.roomNumber = roomNumber;
        this.numberOfBedroom = numberOfBedroom;
        this.numberOfBathroom = numberOfBathroom;
        this.price = price;
        this.status = status;
    }

    public Room(long numberOfBedroom, long numberOfBathroom, long price, String status) {
        this.numberOfBedroom = numberOfBedroom;
        this.numberOfBathroom = numberOfBathroom;
        this.price = price;
        this.status = status;
    }

    public Room(String status) {
        this.status = status;
    }

    public Room(long price) {
        this.price = price;
    }

    public Room(long price, String status) {
        this.price = price;
        this.status = status;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getNumberOfBedroom() {
        return numberOfBedroom;
    }

    public void setNumberOfBedroom(long numberOfBedroom) {
        this.numberOfBedroom = numberOfBedroom;
    }

    public long getNumberOfBathroom() {
        return numberOfBathroom;
    }

    public void setNumberOfBathroom(long numberOfBadroom) {
        this.numberOfBathroom = numberOfBadroom;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%-16s%-26s%-26s%-26s%-26s%n", getRoomNumber(), getStatus(), getNumberOfBedroom(), getNumberOfBathroom(), getPrice());
    }
}

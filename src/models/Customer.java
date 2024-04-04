package models;

public class Customer {
    private long idCustomer;
    private String citizenIdentificationCard;
    private String phoneNumber;
    private int age;

    public Customer(String citizenIdentificationCard, String phoneNumber, int age) {
        this.citizenIdentificationCard = citizenIdentificationCard;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Customer(String citizenIdentificationCard, String phoneNumber) {
        this.citizenIdentificationCard = citizenIdentificationCard;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int age) {
        this.age = age;
    }

    public Customer() {

    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCitizenIdentificationCard() {
        return citizenIdentificationCard;
    }

    public void setCitizenIdentificationCard(String citizenIdentificationCard) {
        this.citizenIdentificationCard = citizenIdentificationCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-30s%-30s%-18s", getIdCustomer(), getCitizenIdentificationCard(), getAge(), getPhoneNumber());
    }
}

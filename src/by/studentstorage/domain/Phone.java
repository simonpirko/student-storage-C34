package by.studentstorage.domain;

import java.util.Objects;

public class Phone {
    private int phoneNumber;
    private long userId;

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber=" + phoneNumber +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return phoneNumber == phone.phoneNumber &&
                userId == phone.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, userId);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Phone() {
    }

    public Phone(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

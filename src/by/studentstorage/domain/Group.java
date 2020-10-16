package by.studentstorage.domain;

import java.util.Objects;

public class Group {
    private long userID;
    private String groupName;

    @Override
    public String toString() {
        return "Group{" +
                "userID=" + userID +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    public Group(long userID, String groupName) {
        this.userID = userID;
        this.groupName = groupName;
    }
}

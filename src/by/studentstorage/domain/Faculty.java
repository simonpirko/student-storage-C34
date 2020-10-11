package by.studentstorage.domain;

import java.util.Objects;

public class Faculty {
    private long userID;

    @Override
    public String toString() {
        return "Faculty{" +
                "userID=" + userID +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Faculty(String faculty, long userID) {
        this.userID = userID;
        this.faculty = faculty;
    }

    private String faculty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty1 = (Faculty) o;
        return Objects.equals(faculty, faculty1.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty);
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Faculty() {
    }

    public Faculty(String faculty) {
        this.faculty = faculty;
    }
}

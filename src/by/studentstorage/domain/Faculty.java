package by.studentstorage.domain;

import java.util.Objects;

public class Faculty {
    private String faculty;

    @Override
    public String toString() {
        return "Faculty{" +
                "faculty='" + faculty + '\'' +
                '}';
    }

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

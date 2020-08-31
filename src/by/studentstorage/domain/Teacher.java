package by.studentstorage.domain;

import java.util.Objects;

public class Teacher extends User{
    private Rank rank;
    private Position position;
    private String department;

    public Teacher(String name, String surname, String email, String password, Role role, Rank rank, Position position, String department) {
        super(name, surname, email, password, role);
        this.rank = rank;
        this.position = position;
        this.department = department;
    }

    public Teacher(long id, String name, String surname, String email, String password, Role role, Rank rank, Position position, String department) {
        super(id, name, surname, email, password, role);
        this.rank = rank;
        this.position = position;
        this.department = department;
    }

    public Teacher() {
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return rank == teacher.rank &&
                position == teacher.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rank, position);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "rank=" + rank +
                ", position=" + position +
                ", department='" + department + '\'' +
                '}';
    }
}

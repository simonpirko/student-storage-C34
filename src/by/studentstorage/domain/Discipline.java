package by.studentstorage.domain;

import java.util.Objects;

public class Discipline {
    private long id;
    private String disciplineName;

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", disciplineName='" + disciplineName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return Objects.equals(disciplineName, that.disciplineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Discipline() {
    }

    public Discipline(long id, String disciplineName) {
        this.id = id;
        this.disciplineName = disciplineName;
    }

    public Discipline(String disciplineName) {
        this.disciplineName = disciplineName;
    }
}

package by.studentstorage.domain;

import java.util.Date;
import java.util.Objects;

public class Lesson {
    private long incID = 1;
    private long id = incID++;
    private String lessonType;
    private String discipline;
    private Date startTime;
    private Date endTime;
    private Date data;
    private Teacher teacher;

    public Lesson(String discipline, Date data, Teacher teacher) {
        this.discipline = discipline;
        this.data = data;
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Lesson() {
    }

    public Lesson(long id, String lessonType, String discipline, Date startTime, Date endTime, Date data, Teacher teacher) {
        this.id = id;
        this.lessonType = lessonType;
        this.discipline = discipline;
        this.startTime = startTime;
        this.endTime = endTime;
        this.data = data;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonType=" + lessonType +
                ", discipline=" + discipline +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", data=" + data +
                ", teacher=" + teacher +
                '}';
    }

    public Lesson(String lessonType, String discipline, Date startTime, Date endTime, Date data) {
        this.lessonType = lessonType;
        this.discipline = discipline;
        this.startTime = startTime;
        this.endTime = endTime;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return lessonType == lesson.lessonType &&
                Objects.equals(discipline, lesson.discipline) &&
                Objects.equals(startTime, lesson.startTime) &&
                Objects.equals(endTime, lesson.endTime) &&
                Objects.equals(data, lesson.data) &&
                Objects.equals(teacher, lesson.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonType, discipline, startTime, endTime, data, teacher);
    }

    public Lesson(String lessonType, String discipline, Date startTime, Date endTime, Date data, Teacher teacher) {
        this.lessonType = lessonType;
        this.discipline = discipline;
        this.startTime = startTime;
        this.endTime = endTime;
        this.data = data;
        this.teacher = teacher;
    }
}


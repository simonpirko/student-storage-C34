package by.studentstorage.domain;

import java.util.Date;
import java.util.Objects;

public class Lesson {
    private long id;
    private LessonType lessonType;
    private Discipline discipline;
    private Date startTime;
    private Date endTime;
    private Date data;
    private Teacher teacher;

    public Lesson() {
    }

    public Lesson(long id, LessonType lessonType, Discipline discipline, Date startTime, Date endTime, Date data, Teacher teacher) {
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

    public Lesson(LessonType lessonType, Discipline discipline, Date startTime, Date endTime, Date data, Teacher teacher) {
        this.lessonType = lessonType;
        this.discipline = discipline;
        this.startTime = startTime;
        this.endTime = endTime;
        this.data = data;
        this.teacher = teacher;
    }
}


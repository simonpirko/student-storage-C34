package by.studentstorage.domain;

import javax.swing.*;
import java.util.Date;
import java.util.Objects;


public class Student extends User{
    private String address;
    private City city;
    private String nationality;
    private Country country;
    private Phone phone;
    private GroupLayout.Group group;
    private Faculty faculty;
    private int courseNumber;
    private Date bornDate;
    private EducationForm educationForm;
    private boolean warrior;

    public Student(String name, String login, String surname, String email, String password, Role role, String address, City city, String nationality, Country country, Phone phone, GroupLayout.Group group, Faculty faculty, int courseNumber, Date bornDate, EducationForm educationForm, boolean warrior) {
        super(name, login, surname, email, password, role);
        this.address = address;
        this.city = city;
        this.nationality = nationality;
        this.country = country;
        this.phone = phone;
        this.group = group;
        this.faculty = faculty;
        this.courseNumber = courseNumber;
        this.bornDate = bornDate;
        this.educationForm = educationForm;
        this.warrior = warrior;
    }

    public Student(long id, String login, String name, String surname, String email, String password, Role role, String address, City city, String nationality, Country country, Phone phone, GroupLayout.Group group, Faculty faculty, int courseNumber, Date bornDate, EducationForm educationForm, boolean warrior) {
        super(id, login, name, surname, email, password, role);
        this.address = address;
        this.city = city;
        this.nationality = nationality;
        this.country = country;
        this.phone = phone;
        this.group = group;
        this.faculty = faculty;
        this.courseNumber = courseNumber;
        this.bornDate = bornDate;
        this.educationForm = educationForm;
        this.warrior = warrior;
    }

    public Student() {
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", city=" + city +
                ", nationality='" + nationality + '\'' +
                ", country=" + country +
                ", phone=" + phone +
                ", group=" + group +
                ", faculty=" + faculty +
                ", courseNumber=" + courseNumber +
                ", bornDate=" + bornDate +
                ", educationForm=" + educationForm +
                ", warrior=" + warrior +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(address, student.address) &&
                Objects.equals(city, student.city) &&
                Objects.equals(nationality, student.nationality) &&
                Objects.equals(country, student.country) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, city, nationality, country, group);
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public GroupLayout.Group getGroup() {
        return group;
    }

    public void setGroup(GroupLayout.Group group) {
        this.group = group;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public boolean isWarrior() {
        return warrior;
    }

    public void setWarrior(boolean warrior) {
        this.warrior = warrior;
    }
}

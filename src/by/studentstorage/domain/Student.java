package by.studentstorage.domain;


import java.util.Objects;


public class Student extends User{
    private String address;
    private String city;
    private String nationality;
    private String country;
    private int phone;
    private String group;
    private String faculty;
    private int courseNumber;
    private String bornDate;
    private String educationForm;
    private boolean warrior;

    public Student(String login, String name, String surname, String password) {
        super(login, name, surname, password, Role.STUDENT);
    }

    public Student(String name, String login, String surname, String email, String password, Role role, String address, String city, String nationality, String country, int phone, String group, String faculty, int courseNumber, String  bornDate, String educationForm, boolean warrior) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String  country) {
        this.country = country;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String  bornDate) {
        this.bornDate = bornDate;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public boolean isWarrior() {
        return warrior;
    }

    public void setWarrior(boolean warrior) {
        this.warrior = warrior;
    }
}

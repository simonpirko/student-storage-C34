package by.studentstorage.action;

import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.*;
import by.studentstorage.service.StudentService;
import by.studentstorage.service.TeacherService;
import by.studentstorage.service.UserService;

public class ModeratorAction {
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();
    private TeacherService teacherService = new TeacherService();

    public void updateLogin() {
        consoleWriter.writeString("Please enter user's id");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);


        User userByLogin = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's login");
        String newLogin = consoleReader.readString();
        userService.updateLogin(newLogin, userByLogin.getId());
    }

    public void updateName() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's name");
        String name = consoleReader.readString();
        userService.updateName(name, userByID.getId());
    }

    public void updateSurname() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's surname");
        String surname = consoleReader.readString();
        userService.updateSurname(surname, userByID.getId());
    }

    public void updateEmail() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's e-mail");
        String email = consoleReader.readString();
        userService.updateEmail(email, userByID.getId());
    }

    public void updatePass() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }
        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's password");
        String pass = consoleReader.readString();
        userService.updatePassword(pass, userByID.getId());
    }

    public void updateAddress() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's address");
        String address = consoleReader.readString();
        studentService.updateAddress(address, (Student) userByID);
    }

    public void updateCity() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's City");
        String city = consoleReader.readString();
        studentService.updateCity(city, userByID.getId());
    }

    public void updateNationality() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's nationality");
        String nat = consoleReader.readString();
        studentService.updateNationality(nat, userByID.getId());
    }

    public void updateCountry() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's country");
        String coutry = consoleReader.readString();
        studentService.updateCountry(coutry, userByID.getId());
    }

    public void updatePhone() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's phone");
        int phone = consoleReader.readInt();
        studentService.updatePhone(phone, userByID.getId());
    }


    public void updateGroup() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's gropu");
        String group = consoleReader.readString();
        studentService.updateGroup(group, (Student) userByID);
    }

    public void updateFaculty() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's faculty");
        String faculty = consoleReader.readString();
        studentService.updateFaculty(faculty, (Student) userByID);
    }

    public void updateCourse() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's course number");
        int course = consoleReader.readInt();
        studentService.updateCourse(course, (Student) userByID);
    }

    public void updateBirth() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's date of birth:number of day");

        int numDay;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            numDay=consoleReader.readInt();
            if(numDay<1 || numDay>31){
                consoleWriter.writeString("Error: input numbers >0 and <32");
            }
            else {
                break;
            }

        } while(true);



        consoleWriter.writeString("Write date:input number of month");
        int numMonth;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            numMonth=consoleReader.readInt();
            if(numMonth<1 || numMonth>12){
                consoleWriter.writeString("Error: input numbers >0 and <13");
            }
            else {
                break;
            }

        } while(true);

        consoleWriter.writeString("Write date:input number of year");
        int numYear;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            numYear=consoleReader.readInt();
            if(numYear<1900 || numYear>2100){
                consoleWriter.writeString("Error: input numbers >1899 and <2101");
            }
            else {
                break;
            }

        } while(true);

        String birth = numDay+"/"+numMonth+"/"+numYear;
        studentService.updateBirth(birth, userByID.getId());
    }

    public void updateEducationForm() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's form of education");
        String education = consoleReader.readString();
        studentService.updateEducationForm(education, (Student) userByID);
    }


    public void updateWarrior() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter users's suitability for the army.");
        consoleWriter.writeString("1-Is not suitable \n2-Is suitable");
        int hasArmy;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers:1 or 2");
            }
            hasArmy = consoleReader.readInt();
            if(hasArmy<1 || hasArmy>2){
                consoleWriter.writeString("Error: input numbers 1 or 2");
            }
            else {
                break;
            }

        } while(true);

        switch (hasArmy){
            case 1: studentService.updateWarrior(false, userByID.getId()); break;
            case 2: studentService.updateWarrior(true, userByID.getId()); break;
        }
    }

    public void updateRank() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's rank");
        consoleWriter.writeString("1-PROFESSOR \n2-DOCENT");
        int rank;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers:1 or 2");
            }
            rank=consoleReader.readInt();
            if(rank<1 || rank>2){
                consoleWriter.writeString("Error: input numbers 1 or 2");
            }
            else {
                break;
            }

        } while(true);

        Rank rank1;
        switch (rank){
            case 1: rank1=Rank.PROFESSOR; break;
            case 2: rank1=Rank.DOCENT; break;
            default: rank1=null;
        }

        teacherService.updateRank(rank1, (Teacher) userByID);
    }

    public void updatePosition() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's position");
        int position;
        consoleWriter.writeString("1-ASSISTANT \n2-SENIOR");
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers:1 or 2");
            }
            position=consoleReader.readInt();
            if(position<1 || position>2){
                consoleWriter.writeString("Error: input numbers 1 or 2");
            }
            else {
                break;
            }

        } while(true);

        Position position1;
        switch (position){
            case 1: position1=Position.ASSISTANT; break;
            case 2: position1=Position.SENIOR; break;
            default: position1=null;
        }

        teacherService.updatePosition(position1, (Teacher) userByID);
    }

    public void updateDepartment() {
        consoleWriter.writeString("Please enter user's ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's department");
        String dep = consoleReader.readString();
        teacherService.updateDepartment(dep, (Teacher) userByID);
    }
}

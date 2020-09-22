package learn.java.classes.student;

import learn.java.classes.DateOfBirth;
import learn.java.classes.Person;

import java.util.Objects;

class Student extends Person {
    private String address;
    private DateOfBirth dateOfBirth;
    private int telephoneNumber;
    private Faculties faculty;
    private int yearOfStudy;
    private Groups group;

    public Student() {

    }

    public Student(int id, String name, String lastName, String patronym, String address, DateOfBirth dateOfBirth, int telephoneNumber, Faculties faculty, int yearOfStudy, Groups group) {
        super(id, name, lastName, patronym);
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.group = group;
    }

    @Override
    public void printPersonalData() {
        super.printPersonalData();
        System.out.println("Date of birth: " + getDateOfBirthAsString() +
                "\n" + "Address: " + getAddress() +
                "\n" + "Year of study: " + getYearOfStudy() +
                "\n" + "Faculty: " + faculty.getName() +
                "\n" + "Group: " + group.getName() +
                "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return telephoneNumber == student.telephoneNumber &&
                yearOfStudy == student.yearOfStudy &&
                Objects.equals(address, student.address) &&
                Objects.equals(dateOfBirth, student.dateOfBirth) &&
                faculty == student.faculty &&
                group == student.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, dateOfBirth, telephoneNumber, faculty, yearOfStudy, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronym='" + patronym + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephoneNumber=" + telephoneNumber +
                ", faculty=" + faculty +
                ", yearOfStudy=" + yearOfStudy +
                ", group=" + group +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfBirthAsString() {
        return dateOfBirth.getDay() + "." + dateOfBirth.getMonth() + "." + dateOfBirth.getYear();
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }
}

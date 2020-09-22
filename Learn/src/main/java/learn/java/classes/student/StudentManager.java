package learn.java.classes.student;

import learn.java.classes.DateOfBirth;
import learn.java.classes.Manageable;

import java.util.Scanner;

class StudentManager implements Manageable {
    private Student[] students;

    public StudentManager(int amountOfStudents) {
        this.students = new Student[amountOfStudents];
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager(5);

        studentManager.insertNewStudent(new Student(0, "Name", "LastName", "Patronym", "Street of Pushkin, house of Kolotushkin", new DateOfBirth(7, 2, 1999), 7123643, Faculties.ECONOMY, 1, Groups.FIRST_GROUP));
        studentManager.insertNewStudent(new Student(1, "Name1", "LastName1", "Patronym1", "Street of Pushkin, house of Kolotushkin", new DateOfBirth(2, 5, 1998), 8123643, Faculties.LAW, 2, Groups.SECOND_GROUP));
        studentManager.insertNewStudent(new Student(2, "Name2", "LastName2", "Patronym2", "Street of Pushkin, house of Kolotushkin", new DateOfBirth(6, 2, 1997), 1123643, Faculties.WEBDESIGN, 3, Groups.THIRD_GROUP));
        studentManager.insertNewStudent(new Student(4, "Name3", "LastName3", "Patronym3", "Street of Pushkin, house of Kolotushkin", new DateOfBirth(1, 1, 1997), 5123643, Faculties.MATH, 1, Groups.FOURTH_GROUP));
        studentManager.insertNewStudent(new Student(5, "Name4", "LastName4", "Patronym4", "Street of Pushkin, house of Kolotushkin", new DateOfBirth(10, 10, 1995), 9123643, Faculties.MATH, 2, Groups.FOURTH_GROUP));

        studentManager.collectInput();
    }

    @Override
    public void collectInput() {
        System.out.println("What do you wanna do?" +
                "\n0. Choose a faculty and print all students from this faculty." +
                "\n1. Print all students." +
                "\n2. Choose a year and print all students who are born after this year." +
                "\n3. Choose a group and print all students from this group.");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 0:
                    try {
                        printAllStudentsFromFaculty(Faculties.chooseFaculty());
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    } finally {
                        break;
                    }
                case 1:
                    printAllStudentsFromAllFaculties();
                    break;
                case 2:
                    printAllStudentsWhoAreBornAfterThisYear(checkIfInputIsAInteger());
                    break;
                case 3:
                    try {
                        printAllStudentsWhoAreFromThisGroup(Groups.chooseGroup());
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    } finally {
                        break;
                    }
            }
        }
    }

    public void insertNewStudent(Student student) {
        if (isListFull()) {
            expandList();
        }

        for (int i = 0; i < students.length; i++) {
            if (isSlotInListEmpty(i)) {
                students[i] = student;
                return;
            }
        }
    }

    public void printAllStudentsFromFaculty(Faculties faculty) {
        System.out.println("These students are from faculty of " + faculty.getName() + "----------------------->");
        for (Student student : students) {
            if (student != null && student.getFaculty().equals(faculty)) {
                student.printPersonalData();
            }
        }
        collectInput();
    }

    public void printAllStudentsFromAllFaculties() {
        for (Faculties faculty : Faculties.values()) {
            System.out.println("These students are from faculty of " + faculty.getName() + " ----------------------->");
            for (int yearOfStudy = 1; yearOfStudy < 5; yearOfStudy++) {
                for (Student student : students) {
                    if (student != null && student.getFaculty().equals(faculty) && student.getYearOfStudy() == yearOfStudy) {
                        student.printPersonalData();
                    }
                }
            }
        }
        collectInput();
    }

    public void printAllStudentsWhoAreBornAfterThisYear(int year) {
        System.out.println("These students are born after " + year + " ----------------------->");
        for (Student student : students) {
            if (student != null && student.getDateOfBirth().getYear() > year) {
                student.printPersonalData();
            }
        }
        collectInput();
    }

    public void printAllStudentsWhoAreFromThisGroup(Groups group) {
        System.out.println("These students are from " + group.getName() + " ----------------------->");
        for (Student student : students) {
            if (student != null && student.getGroup() == group) {
                student.printPersonalData();
            }
        }
        collectInput();
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public boolean isSlotInListEmpty(int slotIndex) {
        return students[slotIndex] == null;
    }

    @Override
    public boolean isListFull() {
        for (int i = 0; i < students.length; i++) {
            if (isSlotInListEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void expandList() {
        System.out.println("Student list is full. Expanding...");
        int currentLength = students.length;
        Student[] newListOfStudents = new Student[currentLength * 2];
        for (int i = 0; i < currentLength; i++) {
            newListOfStudents[i] = students[i];
        }
        students = newListOfStudents;
    }

    @Override
    public int checkIfInputIsAInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextInt() ? scanner.nextInt() : checkIfInputIsAInteger();
    }

    @Override
    public long checkIfInputIsALong() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextLong() ? scanner.nextLong() : checkIfInputIsALong();
    }
}

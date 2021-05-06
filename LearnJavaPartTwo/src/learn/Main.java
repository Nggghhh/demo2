package learn;

import java.util.Arrays;
import java.util.List;

import learn.university.NoFacultiesException;
import learn.university.University;
import learn.university.faculties.Faculty;
import learn.university.faculties.NoStudentGroupsException;
import learn.university.faculties.groups.EmptyStudentGroupException;
import learn.university.faculties.groups.Group;
import learn.university.students.EmptySubjectListException;
import learn.university.students.Student;
import learn.university.subjects.InvalidGradeException;
import learn.university.subjects.Subject;

public class Main {
	private University university;
	private static List<Subject> subjectsOfIvan = Arrays.asList(
			new Subject("Math", 1),
			new Subject("Language", 2),
			new Subject("Economy", 3)
			);
	
	private static List<Subject> subjectsOfAnton = Arrays.asList(
			new Subject("Math", 9),
			new Subject("Language", 7),
			new Subject("Economy", 6)
			);
	
	private static List<Subject> subjectsOfVlad = Arrays.asList(
			new Subject("Math", 2),
			new Subject("Law", 6),
			new Subject("Philosophy", 5)
			);
	
	private static List<Student> studentsOfEconomy = Arrays.asList(
			new Student("Ivan Ivanov Ivanovich", subjectsOfIvan),
			new Student("Anton Ivanov Ivanovich", subjectsOfAnton)
			);
	
	private static List<Student> studentsOfLaw = Arrays.asList(
			new Student("Vladislav Vladislavov Vladislavovich", subjectsOfVlad)
			);
	
	private static List<Group> groupsEconomy = Arrays.asList(
			new Group("DGR-3", studentsOfEconomy),
			new Group("DGR-2", studentsOfEconomy)
			);
	
	private static List<Group> groupsLaw = Arrays.asList(
			new Group("LGR-1", studentsOfLaw)
			);
	
	private static List<Faculty> faculties = Arrays.asList(
			new Faculty("Faculty of economy", groupsEconomy),
			new Faculty("Faculty of law", groupsLaw)
			);
	
	public static void main(String[] args) {
		University university = new University("Economy university", faculties);
		try {
			System.out.println(university.calculateAverageScoreOfAStudent("Faculty of economy", "DGR-3", "Ivan Ivanov Ivanovich"));
		} catch (NoStudentGroupsException | NoFacultiesException | EmptyStudentGroupException | InvalidGradeException | EmptySubjectListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(university.calculateAverageScoreBySubjectOnFaculty("Math", "Faculty of economy", "DGR-3"));
		} catch (NoStudentGroupsException | NoFacultiesException | EmptyStudentGroupException | InvalidGradeException | EmptySubjectListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(university.calculateAverageScoreBySubject("Math"));
		} catch (NoStudentGroupsException | NoFacultiesException | EmptyStudentGroupException | InvalidGradeException | EmptySubjectListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

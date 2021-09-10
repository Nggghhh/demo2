package learn.exceptions.university;

import java.util.ArrayList;
import java.util.List;

import learn.exceptions.university.faculties.Faculty;
import learn.exceptions.university.faculties.NoStudentGroupsException;
import learn.exceptions.university.faculties.groups.EmptyStudentGroupException;
import learn.exceptions.university.faculties.groups.Group;
import learn.exceptions.university.students.EmptySubjectListException;
import learn.exceptions.university.students.Student;
import learn.exceptions.university.subjects.InvalidGradeException;
import learn.exceptions.university.subjects.Subject;

public class University {
	private String name;
	private List<Faculty> faculties;
	
	public University() {
		
	}
	
	public University(String name, List<Faculty> faculties) {
		this.name = name;
		this.faculties = faculties;
	}
	
	public void printStudents() {
		for(Faculty faculty : faculties) {
			for(Group group : faculty.getGroups()) {
				for(Student student : group.getStudents()) {
					System.out.println(student.getName()
							+ " " + group.getName()
							+ " " + faculty.getName());
				}
			}
		}
	}
	
	public double calculateAverageScoreOfAStudent(String facultyName, String groupName, String studentName) throws InvalidGradeException, EmptySubjectListException, NoStudentGroupsException, NoFacultiesException, EmptyStudentGroupException {
		double averageScore = 0;
		int amountOfSubjects = 0;
		Student student = getStudent(facultyName, groupName, studentName);
		
		for(Subject subject : student.getSubjects()) {
			averageScore += subject.getGrade();
			amountOfSubjects++;
		}

		return averageScore/amountOfSubjects;
	}
	
	public double calculateAverageScoreBySubjectOnFaculty(String subjectName, String facultyName, String groupName) throws NoStudentGroupsException, NoFacultiesException, EmptyStudentGroupException, InvalidGradeException, EmptySubjectListException {
		double averageScore = 0;
		int amountOfStudents = 0;
		List<Student> students = getStudents(facultyName, groupName);
		
		for(Student student : students) {
			for(Subject subject : student.getSubjects()) {
				if(subject.getName() == subjectName) {
					averageScore += subject.getGrade();
					amountOfStudents++;
					continue;
				}
			}
		}

		return averageScore/amountOfStudents;
	}
	
	public double calculateAverageScoreBySubject(String subjectName) throws NoStudentGroupsException, NoFacultiesException, EmptyStudentGroupException, InvalidGradeException, EmptySubjectListException {
		double averageScore = 0;
		int amountOfStudents = 0;
		List<Faculty> faculties = getFaculties();
		
		for(Faculty faculty : faculties) {
			String facultyName = faculty.getName();
			List<Group> groups = getGroups(facultyName);
			for(Group group : groups) {
				String groupName = group.getName();
				List<Student> students = getStudents(facultyName, groupName);
				for(Student student : students) {
					for (Subject subject : student.getSubjects()) {
						if(subject.getName() == subjectName) {
							averageScore += subject.getGrade();
							amountOfStudents++;
							continue;
						}
					}
				}
			}
		}

		return averageScore/amountOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Faculty> getFaculties() throws NoFacultiesException, NoStudentGroupsException {
		if(faculties.isEmpty()) {
			throw new NoFacultiesException("There should be at least one faculty");
		} else {
			for(Faculty faculty : faculties) {
				if(faculty.getGroups().isEmpty()) {
					throw new NoStudentGroupsException("There should be at least one student group in faculty");
				}
			}
		}
		return faculties;
	}
	
	public List<Group> getGroups(String facultyName) throws NoStudentGroupsException, NoFacultiesException, EmptyStudentGroupException, InvalidGradeException, EmptySubjectListException {
		List<Faculty> faculties = getFaculties();
		
		for(Faculty faculty : faculties) {
			if(faculty.getName() == facultyName) {
				for(Group group : faculty.getGroups()) {
					if(group.getStudents().isEmpty()) {
						throw new EmptyStudentGroupException("There should be at least one student in student group");
					}
				}
				return faculty.getGroups();
			}
		}
		
		return null;
	}
	
	public List<Student> getStudents(String facultyName, String groupName) throws NoStudentGroupsException, NoFacultiesException, EmptyStudentGroupException, EmptySubjectListException, InvalidGradeException {
		List<Group> groups = getGroups(facultyName);
		
		for(Group group : groups) {
			if(group.getName() == groupName) {
				for(Student student : group.getStudents()) {
					if(student.getSubjects().isEmpty()) {
						throw new EmptySubjectListException("Student should have at least one subject");
					} else {
						for(Subject subject : student.getSubjects()) {
							if(subject.getGrade() < 0 || subject.getGrade() > 10) {
								throw new InvalidGradeException(student.getName() + "'s grade is " + subject.getGrade() + ". Student's grade should be higher than 0 and lower than 10 or equal");
							}
						}
					}
				}
				return group.getStudents();
			}
		}
		
		return null;
	}
	
	public Student getStudent(String facultyName, String groupName, String studentName) throws NoStudentGroupsException, NoFacultiesException, EmptyStudentGroupException, EmptySubjectListException, InvalidGradeException {
		List<Student> students = this.getStudents(facultyName, groupName);
		
		for(Student student : students) {
			if(student.getName() == studentName) {
				return student;
			}
		}
		return null;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
}

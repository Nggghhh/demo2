package learn.exceptions.university.students;

import java.util.List;

import learn.exceptions.university.subjects.Subject;

public class Student {
	private String name;
	private List<Subject> subjects;
	
	public Student() {
		
	}
	
	public Student(String name, List<Subject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}
	
	public double calculateAverageScore() {
		double averageScore = 0;
		for(Subject subject : subjects) {
			averageScore += subject.getGrade();
		}
		return averageScore / subjects.size();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name +", subjects=" + subjects + "]";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(List<Subject> subjects) {

		this.subjects = subjects;
	}
}

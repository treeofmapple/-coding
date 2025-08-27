package java_poo.Five_5;

import java.util.ArrayList;

public class Student {

	private String name;
	private int grade;
	private ArrayList<String> courses;

	public Student(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
		this.courses = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void addCourse(String course) {
		courses.add(course);
	}

	public void removeCourse(String course) {
		courses.remove(course);
	}

	@Override
	public String toString() {
		return String.format("Student = [name: %s, grade: %s, courses: %s]", name, grade, courses);
	}

}

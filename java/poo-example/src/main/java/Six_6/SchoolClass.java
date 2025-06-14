package Six_6;

import java.util.ArrayList;

public class SchoolClass {

	private String className;
	private Teacher teachers;
	private ArrayList<Student> students;

	public SchoolClass(String className, Teacher teachers) {
		super();
		this.className = className;
		this.teachers = teachers;
		this.students = new ArrayList<Student>();
	}

	public String getClassName() {
		return className;
	}

	public Teacher getTeachers() {
		return teachers;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setTeachers(Teacher teachers) {
		this.teachers = teachers;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeStudent(Student student) {
		students.remove(student);
	}
}

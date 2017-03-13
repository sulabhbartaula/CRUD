package com.crud.model;

public class Student {

	private int studentId;
    private String firstName;
    private String lastName;
    private String course;
    private int year;
    
    public Student(){
    }
    
	public Student(int studentId, String firstName, String lastName,String course, int year) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.year = year;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", course=" + course + ", year="
				+ year + "]";
	}
    
}

package com.crud.dao;

import java.util.List;

import com.crud.model.Student;

public interface StudentDAO {

	public int addStudent( Student student );
    public int deleteStudent(int studentId);
    public int updateStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(int studentId);
}

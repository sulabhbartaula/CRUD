package com.crud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.StudentDAO;
import com.crud.dao.StudentDAOImpl;
import com.crud.model.Student;

public class StudentController extends HttpServlet {
	private StudentDAO dao = null;

	private static final long serialVersionUID = 1L;
	public static final String LIST_STUDENT = "/listStudent.jsp";
    public static final String INSERTEDIT = "/student.jsp";
	
	public StudentController(){
		dao =  new StudentDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = LIST_STUDENT;
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			int result = dao.deleteStudent(studentId);
			request.setAttribute("students", dao.getAllStudents());;
		}else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERTEDIT;
            int studentId = Integer.parseInt( request.getParameter("studentId") );
            Student student = dao.getStudentById(studentId);
            request.setAttribute("student", student);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERTEDIT;
        }
        else {
            forward = LIST_STUDENT;
            request.setAttribute("students", dao.getAllStudents() );
        }
		
		 RequestDispatcher view = request.getRequestDispatcher(forward);
	     view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 	Student student = new Student();
	        student.setFirstName( request.getParameter( "firstName" ) );
	        student.setLastName( request.getParameter( "lastName" ) );
	        student.setCourse( request.getParameter( "course" ) );
	        student.setYear( Integer.parseInt( request.getParameter( "year" ) ) );
	        String studentId = request.getParameter("studentId");
	 
	        if( studentId == null || studentId.isEmpty() )
	            dao.addStudent(student);
	        else {
	            student.setStudentId( Integer.parseInt(studentId) );
	            dao.updateStudent(student);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST_STUDENT);
	        request.setAttribute("students", dao.getAllStudents());
	        view.forward(request, response);
	    }
	}


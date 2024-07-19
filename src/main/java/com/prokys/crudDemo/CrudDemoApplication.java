package com.prokys.crudDemo;

import com.prokys.crudDemo.dao.StudentDAO;
import com.prokys.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: "+numOfRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " +studentId);
		studentDAO.deleteStudent(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id
		int studentId = 1;
		System.out.println("Getting the student with id: "+studentId);
		Student studentToUpdate = studentDAO.findById(studentId);
		//change the first name to Scooby
		System.out.println("Updating student");
		studentToUpdate.setFirstName("Scooby");

		//update the student
		studentDAO.updateStudent(studentToUpdate);

		//display the updated student
		System.out.println("Updated student to: "+ studentDAO.findById(studentId));
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		//display list of students
		for( Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for( Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating new student objects");
		Student tempStudent = new Student("John", "Doe", "paul@luv2code.com");
		Student tempStudent1 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent2 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
		//save the student objects
		System.out.println("Saving student objects");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO){
		// create a student object

		System.out.println("Creating new student object");
		Student tempStudent = new Student("Duffy", "Duck", "duffy@luv2code.com");

		// save the student

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of student

		System.out.println("New students id is: "+tempStudent.getId());

		// retrieve student by id
		Student recievedStudent = studentDAO.findById(tempStudent.getId());

		//display student
		System.out.println(recievedStudent);

	}
	
	

}

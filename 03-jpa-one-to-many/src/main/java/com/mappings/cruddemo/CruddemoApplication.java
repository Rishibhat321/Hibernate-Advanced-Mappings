package com.mappings.cruddemo;

import com.mappings.cruddemo.dao.AppDAO;
import com.mappings.cruddemo.entity.Course;
import com.mappings.cruddemo.entity.Instructor;
import com.mappings.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Executed after the spring beans have been loaded.
/*	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {

		return runner -> {
			System.out.println("Hello World");
		};
	}

 */

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
		//	createInstructor(appDAO);

		//	findInstructor(appDAO);

		//	deleteInstructor(appDAO);

		//	findInstructorDetail(appDAO);

		//	deleteInstructorDetail(appDAO);

		//	createInstructorWithCourses(appDAO);

		//	findInstructorWithCourses(appDAO);

		//	findCoursesForInstructor(appDAO);

		//	findInstructorWithCoursesJoinFetch(appDAO);

		//	updateInstructor(appDAO);

			updateCourse(appDAO);

		};
	}

	private void updateCourse(AppDAO appDAO) {

		// course id( from the database)
		int theId = 10;

		// find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);

		System.out.println("Course Updated!");

	}


	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		 // find the instructor
		System.out.println("Finding Instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("Rajput");

		appDAO.update(tempInstructor);

		System.out.println("Updated!");

	}


	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Completed!");

	}


	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor is: " + theId);

		// find the instructor
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("The associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}


	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor is: " + theId);

		// find instructor
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println(tempInstructor.getCourses());

		System.out.println("Done...");
	}


	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");

		// create the Instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		// this will also save the courses
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Saved!");

	}


	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Deleted!");

	}


	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructor = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructor: " + tempInstructor);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructor.getInstructor());

		System.out.println("Completed");

	}


	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Deleted!");
	}


	private void findInstructor(AppDAO appDAO) {

	//	int theId = 1;
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());

	}


	private void createInstructor(AppDAO appDAO) {

/*
		// create the instructor
		Instructor tempInstructor = new Instructor("Rishita", "Bhatnagar", "rishi@gmail.com");

		// create the Instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "guitar");
*/

		// create the instructor
		Instructor tempInstructor = new Instructor("Suraj", "Bhatia", "suraj@gmail.com");

		// create the Instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Badmintion");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// this will also save the details object
		// because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Completed");
	}

}

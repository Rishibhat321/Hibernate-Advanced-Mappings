package com.mappings.cruddemo;

import com.mappings.cruddemo.dao.AppDAO;
import com.mappings.cruddemo.entity.Instructor;
import com.mappings.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			deleteInstructorDetail(appDAO);

		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 2;
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
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.com/youtube", "guitar");
*/

		// create the instructor
		Instructor tempInstructor = new Instructor("Suraj", "Bhatia", "suraj@gmail.com");

		// create the Instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.com/youtube", "Badmintion");

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

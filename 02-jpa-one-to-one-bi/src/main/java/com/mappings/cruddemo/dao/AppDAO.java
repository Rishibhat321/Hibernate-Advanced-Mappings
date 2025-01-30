package com.mappings.cruddemo.dao;

import com.mappings.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    // find instructor by id
    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

}

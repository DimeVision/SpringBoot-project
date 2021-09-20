package com.dimevision.springboot.managementsystem.service;

import com.dimevision.springboot.managementsystem.entity.Student;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Service interface for {@link Student} entity class.
 *
 * @author Dimevision
 * @version 0.1
 */

public interface StudentService {

    void saveStudent(Student student);

    void deleteById(Long id);

    Student findByName(@NotEmpty String name);

    Student getStudent(Long id);

    List<Student> getAllStudents();
}

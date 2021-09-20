package com.dimevision.springboot.managementsystem.dao;

import com.dimevision.springboot.managementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dimevision
 * @version 0.1
 */

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

    Student findByName(String name);
}

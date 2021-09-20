package com.dimevision.springboot.managementsystem.service;

import com.dimevision.springboot.managementsystem.dao.StudentDao;
import com.dimevision.springboot.managementsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 */

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImplementation(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {

        studentDao.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}

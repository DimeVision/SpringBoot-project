package com.dimevision.springboot.managementsystem.controller;

import com.dimevision.springboot.managementsystem.entity.Student;
import com.dimevision.springboot.managementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller for pages mapping
 *
 * @author Dimevision
 * @version 0.1
 */

@Controller
public class MyController {

    private final StudentService studentService;

    @Autowired
    public MyController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showIndexPage() {

        return "index";
    }

    @GetMapping("/students")
    public String showWelcomePage(Model model) {

        List<Student> students = studentService.getAllStudents();
        model.addAttribute("allStudentsList", students);

        return "students-view";
    }

    @GetMapping("/students/{id}")
    public String showStudent(@PathVariable Long id, Model model) {

        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);

        return "student-profile";
    }

    @GetMapping("/student-delete/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/student-update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {

        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);

        return "student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(Student student) {

        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student-create")
    public String addStudentForm(Student student) {

        return "student-create";
    }

    @PostMapping("/student-create")
    public String addStudent(Student student) {

        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/test")
    public String test() {

        return "TESTPAGE";
    }
}

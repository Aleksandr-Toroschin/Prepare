package ru.toroschin.hw7.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.toroschin.hw7.dto.StudentDto;
import ru.toroschin.hw7.model.Student;
import ru.toroschin.hw7.service.StudentService;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddStudent() {
        return "add_student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String showUpdateStudent(@PathVariable Long id, Model model) {
        Student student = studentService.showUpdateStudent(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute StudentDto studentDto) {
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}

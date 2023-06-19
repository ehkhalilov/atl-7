package az.example.atl7.controller;

import az.example.atl7.model.StudentDto;
import az.example.atl7.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/atl/students")
public class StudentWebController {
    private final StudentService studentService;

    public StudentWebController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        List<StudentDto> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String addStudent() {
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(StudentDto studentDto) {
        studentService.save(studentDto);
        return "redirect:/atl/students";
    }
}

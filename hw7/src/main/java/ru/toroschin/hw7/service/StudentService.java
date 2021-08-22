package ru.toroschin.hw7.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.toroschin.hw7.dto.StudentDto;
import ru.toroschin.hw7.error.ResourceNotFoundException;
import ru.toroschin.hw7.model.Student;
import ru.toroschin.hw7.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        studentRepository.save(student);
    }

    public Student showUpdateStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElseThrow(() -> new ResourceNotFoundException("Не найден студент с id="+id));
    }

    @Transactional
    public void updateStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Не найден студент с id="+studentDto.getId()));
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        studentRepository.save(student);
    }

}

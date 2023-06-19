package az.example.atl7.service;

import az.example.atl7.dao.StudentEntity;
import az.example.atl7.dao.StudentRepository;
import az.example.atl7.exception.NotFoundException;
import az.example.atl7.mapper.StudentMapper;
import az.example.atl7.mapper.TeacherMapper;
import az.example.atl7.model.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.example.atl7.mapper.TeacherMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void save(StudentDto student) {
        studentRepository.save(StudentMapper.INSTANCE.mapDtoToEntity(student));
    }

    public StudentDto getStudent(Long studentId) {
        var studentEntity =  studentRepository.findById(studentId).orElseThrow(
                () -> new NotFoundException("STUDENT_NOT_FOUND")
        );

        var teachers = studentEntity.getTeachers()
                .stream()
                .map(INSTANCE::mapEntityToDto)
                .toList();
        var studentDto = StudentMapper.INSTANCE.mapEntityToDto(studentEntity);
        studentDto.setTeachers(teachers);

        return studentDto;
    }

    public List<StudentDto> getStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper.INSTANCE::mapEntityToDto).toList();
    }
}

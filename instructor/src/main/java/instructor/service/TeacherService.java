package instructor.service;

import instructor.client.StudentClient;
import instructor.entity.FullSchoolResponse;
import instructor.entity.Teacher;
import instructor.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private StudentClient studentClient;

    public Teacher saveTeacher(Teacher center){
        return teacherRepo.save(center);
    }

    public List<Teacher> getAllTeacher(){
        return teacherRepo.findAll();
    }

    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }

    public void updateTeacher(Long id, Teacher teacher) {

        Teacher existingTeacher = teacherRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with id " + id));

        // Update the existing product with the new data
        existingTeacher.setName(teacher.getName());
        existingTeacher.setPosition(teacher.getPosition());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhone(teacher.getPhone());

        // Save the updated product
        teacherRepo.save(teacher);
    }








    public FullSchoolResponse findTeacherWithStudents(Long id) {
        var teacher =teacherRepo.findById(id).orElse(
                Teacher.builder()
                        .name("Not Found")
                        .email("Not Found")
                        .build()
        );
        var students = studentClient.findAllStudentsByTeacherId(id) ;
        return FullSchoolResponse.builder()
                .name(teacher.getName())
                .position(teacher.getPosition())
                .students(students)
                .build()
                ;
    }
}

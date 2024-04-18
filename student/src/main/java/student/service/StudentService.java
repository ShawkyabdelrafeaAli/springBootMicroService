package student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.entity.Student;
import student.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }



    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public void updateStudent(Long id, Student student) {

        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id " + id));

        // Update the existing product with the new data
        existingStudent.setName(student.getName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setAge(student.getAge());
        existingStudent.setTeacherId(student.getTeacherId());

        // Save the updated product
        studentRepo.save(existingStudent);
    }


    public List<Student> findAllStudentByTeacherId(Long id) {
        return studentRepo.findAllByTeacherId( id);
    }
    public List<Student>findAllStudentByCourseId(Long  id){
        return studentRepo.findAllByCourseId(id);
    }
    public List<Student>findAllStudentByCenterId(Long  id){
        return studentRepo.findAllByCenterId(id);
    }
}

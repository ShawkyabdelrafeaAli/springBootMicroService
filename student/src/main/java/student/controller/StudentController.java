package student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.entity.Student;
import student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping("/getAllStudent")
    public ResponseEntity <List<Student>>getAllStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student with ID " + id + " deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return " Student with ID " + id + " updated successfully";
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity <List<Student>>getAllStudentsBYTeacherId(@PathVariable("teacherId") Long id){
        return  ResponseEntity.ok(studentService.findAllStudentByTeacherId(id));
    }
    @GetMapping("/course/{courseId}")
    public ResponseEntity <List<Student>>getAllStudentsByCourseId(@PathVariable("courseId") Long id){
        return  ResponseEntity.ok(studentService.findAllStudentByCourseId(id));
    }
    @GetMapping("/center/{centerId}")
    public ResponseEntity <List<Student>>getAllStudentsByCenterId(@PathVariable("centerId") Long id){
        return  ResponseEntity.ok(studentService.findAllStudentByCenterId(id));
    }
}

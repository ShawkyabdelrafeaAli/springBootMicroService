package instructor.controller;


import instructor.entity.FullSchoolResponse;
import instructor.entity.Teacher;
import instructor.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher  teacher){
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }
    @GetMapping("/getAllTeacher")
    public ResponseEntity <List<Teacher>>getAllTeacher(){
        return new ResponseEntity<>(teacherService.getAllTeacher(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "Teacher with ID " + id + " deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id,teacher );
        return " Teacher with ID " + id + " updated successfully";
    }

    @GetMapping("/with-student/{teacherId}")
    public ResponseEntity<FullSchoolResponse>findAllSchool(@PathVariable("teacherId") Long id){
//        System.out.println("EEEEEEEEEEEEEEEEEe");
//        System.out.println("EEEEEEEEEEEEEEEEEe");
        return ResponseEntity.ok(teacherService.findTeacherWithStudents(id));
    }
}

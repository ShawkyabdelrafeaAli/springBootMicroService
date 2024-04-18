package courseservice.controller;

import courseservice.entity.Course;
import courseservice.entity.FullCourseResponse;
import courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<Course>saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }
    @GetMapping("/getAllCourse")
    public ResponseEntity <List<Course>>getAllCenter(){
        return new ResponseEntity<>(courseService.getAllCourse(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course with ID " + id + " deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return " Course with ID " + id + " updated successfully";
    }
    @GetMapping("/with-student/{courseId}")
    public ResponseEntity<FullCourseResponse>findAllCourse(@PathVariable("courseId") Long id){
        return ResponseEntity.ok(courseService.findCourseWithStudents(id));
    }



}

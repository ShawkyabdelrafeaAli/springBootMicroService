package courseservice.service;

import courseservice.client.StudentClient;
import courseservice.entity.Course;
import courseservice.entity.FullCourseResponse;
import courseservice.repository.CourseRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentClient studentClient;

    public Course saveCourse(Course center){
        return courseRepo.save(center);
    }

    public List<Course> getAllCourse(){
        return courseRepo.findAll();
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    public void updateCourse(Long id, Course course) {

        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id " + id));

        // Update the existing product with the new data
        existingCourse.setName(course.getName());
        existingCourse.setPrice(course.getPrice());


        // Save the updated product
        courseRepo.save(course);
    }


    public FullCourseResponse findCourseWithStudents(Long id) {
        var course =courseRepo.findById(id).orElse(
                Course.builder()
                        .name("Not Found")
                        .build()
        );
        var students = studentClient.getAllStudentByCourse(id) ;
        return FullCourseResponse.builder()
                .name(course.getName())
                .price(course.getPrice())
                .students(students)
                .build()
                ;
    }

    }

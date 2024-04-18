package courseservice.client;

import courseservice.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STUDENT")
public interface StudentClient {
    @GetMapping("/api/student/course/{courseId}")
    List<Student> getAllStudentByCourse(@PathVariable("courseId") Long id);
}

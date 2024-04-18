package instructor.client;

import instructor.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URL;
import java.util.List;

@FeignClient(name = "STUDENT")
public interface StudentClient {
    @GetMapping("/api/student/teacher/{teacherId}")
    List<Student>findAllStudentsByTeacherId(@PathVariable("teacherId") Long id);
}

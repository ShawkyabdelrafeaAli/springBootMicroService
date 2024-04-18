package centerservice.client;


import centerservice.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STUDENT")
public interface StudentClient {
    @GetMapping("/api/student/center/{centerId}")
    List<Student> getAllStudentsByCenter(@PathVariable("centerId") Long id);
}

package centerservice.service;


import centerservice.client.StudentClient;
import centerservice.entity.Center;
import centerservice.entity.FullCenterResponse;
import centerservice.repository.CenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {
    @Autowired
    private CenterRepo centerRepo;
    @Autowired
   private StudentClient studentClient;

    public Center saveCenter(Center center){
        return centerRepo.save(center);
    }

    public List<Center> getAllCenter(){
        return centerRepo.findAll();
    }

    public void deleteCenter(Long id) {
        centerRepo.deleteById(id);
    }

    public void updateCenter(Long id, Center center) {

        Center existingCenter = centerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Center not found with id " + id));

        // Update the existing product with the new data
        existingCenter.setName(center.getName());
        existingCenter.setLocation(center.getLocation());


        // Save the updated product
        centerRepo.save(center);
    }

    public FullCenterResponse findCentersWithStudents(Long id) {
        var center =centerRepo.findById(id).orElse(
                Center.builder()
                        .name("Not Found")
                        .build()
        );
        var students = studentClient.getAllStudentsByCenter(id) ;
        return FullCenterResponse.builder()
                .name(center.getName())
                .location(center.getLocation())
                .students(students)
                .build()
                ;
    }




}

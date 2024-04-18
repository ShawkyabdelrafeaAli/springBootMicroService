package centerservice.controller;


import centerservice.entity.Center;
import centerservice.entity.FullCenterResponse;
import centerservice.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class CenterController {

    @Autowired
    private CenterService centerService;

    @PostMapping("/save")
    public ResponseEntity<Center>saveCenter(@RequestBody Center center){
        return new ResponseEntity<>(centerService.saveCenter(center), HttpStatus.CREATED);
    }
    @GetMapping("/getAllCenter")
    public ResponseEntity <List<Center>>getAllCenter(){
        return new ResponseEntity<>(centerService.getAllCenter(),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCenter(@PathVariable Long id) {
        centerService.deleteCenter(id);
        return "Center with ID " + id + " deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateCenter(@PathVariable Long id, @RequestBody Center center) {
        centerService.updateCenter(id, center);
        return " Center with ID " + id + " updated successfully";
    }

    @GetMapping("/with-student/{centerId}")
    public ResponseEntity<FullCenterResponse>findAllCentersWithStudents(@PathVariable("centerId") Long id){
        return ResponseEntity.ok(centerService.findCentersWithStudents(id));
    }
}

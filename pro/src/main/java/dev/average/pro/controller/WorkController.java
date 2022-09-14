package dev.average.pro.controller;


import dev.average.pro.model.Work;
import dev.average.pro.service.concretes.WorkManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/works")
public class WorkController {

    private final WorkManager workManager ;



    @GetMapping()
    public List<Work> getForms(){
        return workManager.getWorks();
    }

    @GetMapping("{id}")
    public ResponseEntity<Work> getForm(@PathVariable int id){
        Work work = workManager.getWork(id);
        return ResponseEntity.ok().body(work);
    }

    @PostMapping()
    public ResponseEntity<Work> newWork(@RequestBody Work work){

        return new ResponseEntity(workManager.newWork(work), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Work> updateForm(@PathVariable int id, @RequestBody Work work){



        return ResponseEntity.ok().
                body( workManager.updateWork(id,work)) ;
    }

    @DeleteMapping("/{id}")
    public void deleteWork(@PathVariable int id){
        workManager.deleteWork(id);
    }


}

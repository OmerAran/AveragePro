package dev.average.pro.controller;

import dev.average.pro.model.WorkWeek;
import dev.average.pro.service.concretes.WorkWeekManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/workweeks")
public class WorkWeekController {

    private final WorkWeekManager workWeekManager ;



    @GetMapping()
    public List<WorkWeek> getWorkWeeks(){
        return workWeekManager.getWorkWeeks();
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkWeek> getWorkWeek(@PathVariable int id){
        WorkWeek workWeek = workWeekManager.getWorkWeek(id);
        return ResponseEntity.ok().body(workWeek);
    }

    @PostMapping()
    public ResponseEntity<WorkWeek> newWorkWeek(@RequestBody WorkWeek workWeek){

        return new ResponseEntity(workWeekManager.newWorkWeek(workWeek), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<WorkWeek> updateWorkWeek(@PathVariable int id, @RequestBody WorkWeek workWeek){

        return ResponseEntity.ok().
                body( workWeekManager.updateWorkWeek(id,workWeek));
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable int id){
        workWeekManager.deleteWorkWeek(id);
    }




}

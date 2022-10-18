package dev.average.pro.controller;

import dev.average.pro.dto.workenv.WorkEnvDto;
import dev.average.pro.model.WorkEnv;
import dev.average.pro.service.concretes.WorkEnvManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/workenvs")
public class WorkEnvController {

    private final WorkEnvManager workEnvManager ;



    @GetMapping()
    public List<WorkEnv> getWorkEnvs(){
        return workEnvManager.getWorkEnvs();
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkEnv> getWorkEnv(@PathVariable int id){
        WorkEnv workEnv = workEnvManager.getWorkEnv(id);
        return ResponseEntity.ok().body(workEnv);
    }

    @PostMapping()
    public ResponseEntity<WorkEnv> newWorkEnv(@RequestBody WorkEnv workEnv){

        return new ResponseEntity(workEnvManager.newWorkEnv(workEnv), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<WorkEnv> updateWorkEnv(@PathVariable int id, @RequestBody WorkEnv workEnv){

        return ResponseEntity.ok(workEnvManager.updateWorkEnv(id,workEnv)) ;
    }

    @DeleteMapping("/{id}")
    public void deleteWorkEnv(@PathVariable int id){
        workEnvManager.deleteWorkEnv(id);
    }


}

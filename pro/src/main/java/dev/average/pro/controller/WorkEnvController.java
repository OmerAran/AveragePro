package dev.average.pro.controller;

import dev.average.pro.dto.work.WorkDto;
import dev.average.pro.dto.workenv.WorkEnvDto;
import dev.average.pro.model.Work;
import dev.average.pro.model.WorkEnv;
import dev.average.pro.service.concretes.WorkEnvManager;
import dev.average.pro.service.concretes.WorkManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class WorkEnvController {

    private ModelMapper modelMapper ;
    private final WorkEnvManager workEnvManager ;



    @GetMapping()
    public List<WorkDto> getWorkEnvs(){
        return workEnvManager.getWorkEnvs().stream().map(work->
                modelMapper.map(work,WorkDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkEnvDto> getWorkEnv(@PathVariable int id){
        WorkEnv workEnv = workEnvManager.getWorkEnv(id);
        WorkEnvDto workEnvDto = modelMapper.map(workEnv, WorkEnvDto.class);
        return ResponseEntity.ok().body(workEnvDto);
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

package dev.average.pro.controller;

import dev.average.pro.dto.form.FormDto;
import dev.average.pro.dto.work.WorkDto;
import dev.average.pro.model.Form;
import dev.average.pro.model.Work;
import dev.average.pro.service.concretes.WorkManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/works")
public class WorkController {

    private ModelMapper modelMapper ;
    private final WorkManager workManager ;



    @GetMapping()
    public List<WorkDto> getForms(){
        return workManager.getWorks().stream().map(work->
                modelMapper.map(work,WorkDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkDto> getForm(@PathVariable int id){
        Work work = workManager.getWork(id);
        WorkDto workDto = modelMapper.map(work, WorkDto.class);
        return ResponseEntity.ok().body(workDto);
    }

    @PostMapping()
    public ResponseEntity<Work> newWork(@RequestBody Work work){

        return new ResponseEntity(workManager.newWork(work), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<WorkDto> updateForm(@PathVariable int id, @RequestBody WorkDto workDto){
        Work requestWork = modelMapper.map(workDto, Work.class);
        Work work = workManager.updateWork(id,requestWork);
        WorkDto responseWork = modelMapper.map(workDto, WorkDto.class);

        return ResponseEntity.ok().body(responseWork) ;
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable int id){
        workManager.deleteWork(id);
    }


}

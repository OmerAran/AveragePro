package dev.average.pro.controller;


import dev.average.pro.model.Form;
import dev.average.pro.service.concretes.FormManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forms")
public class FormController {

    private final FormManager formManager;

    @GetMapping()
    public List<Form> getForms() {
        return formManager.getForms();
    }

    @GetMapping("{id}")
    public ResponseEntity<Form> getForm(@PathVariable Long id) {
        Form form = formManager.getForm(id);
        return ResponseEntity.ok().body(form);
    }

    @GetMapping("countworkbyname/{name}")
    public Integer countFormsByWork_NameIgnoreCase(@PathVariable String name){
        return formManager.countFormsByWork_NameIgnoreCase(name);
    }

    @GetMapping("work/{id}")
    public Integer CountWorkById(@Valid  @PathVariable int id){
        return formManager.countFormsByWork_Id(id);
    }

    @GetMapping("allworks")
    public Integer countAll(){
        return formManager.countAll();
    }

    @GetMapping("workenv/{id}")
    public Integer countFormsByWorkEnv_Id(@Valid  @PathVariable int id){
        return formManager.countFormsByWorkEnv_Id(id);
    }

    @GetMapping("workweek/{id}")
    public Integer countFormsByWorkWeek_Id(@Valid  @PathVariable int id){
        return formManager.countFormsByWorkWeek_Id(id);
    }

    @GetMapping("comparework/{id}")
    public  Integer compareWork(@Valid  @PathVariable int id){
        int allWorks = formManager.countAll();
        int requestWork = formManager.countFormsByWork_Id(id);
        return percent(requestWork,allWorks);
    }

    @GetMapping("compareworkenv/{id}")
    public  Integer compareWorkEnv(@Valid  @PathVariable int id){
        int allWorkEnvs = formManager.countAll();
        int requestWorkEnv = formManager.countFormsByWorkEnv_Id(id);
        return percent(requestWorkEnv,allWorkEnvs);
    }
    @GetMapping("compareworkweek/{id}")
    public  Integer compareWorkWeek(@Valid @PathVariable int id){
        int allWorkWeeks = formManager.countAll();
        int requestWorkWeek = formManager.countFormsByWorkWeek_Id(id);
        return percent(requestWorkWeek,allWorkWeeks);
    }
    @GetMapping("avgsalary/{id}")
    public  Integer AvgSalary(@Valid  @PathVariable int id){
        return formManager.AvgSalary(id);
    }


    @PostMapping()
    public ResponseEntity<Form> newForm(@Valid @RequestBody Form form) {

        return new ResponseEntity<>(formManager.newForm(form), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Form> updateForm(@Valid  @PathVariable Long id, @Valid @RequestBody Form form) {
        return ResponseEntity.ok().
                body(formManager.updateForm(id, form));
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@Valid  @PathVariable Long id) {
        formManager.deleteForm(id);
    }


    public int percent(int request, int all){
        return (request * 100 / all);
    }
}
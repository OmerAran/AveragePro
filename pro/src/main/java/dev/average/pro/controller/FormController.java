package dev.average.pro.controller;


import dev.average.pro.model.Form;
import dev.average.pro.service.concretes.FormManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
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

    @PostMapping()
    public ResponseEntity<Form> newForm(@RequestBody Form form) {
        int id = form.getWork().getId();
        log.info("{}",id);
        return new ResponseEntity(formManager.newForm(form), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Form> updateForm(@PathVariable Long id, @RequestBody Form form) {


        return ResponseEntity.ok().
                body(formManager.updateForm(id, form));
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Long id) {
        formManager.deleteForm(id);
    }


}

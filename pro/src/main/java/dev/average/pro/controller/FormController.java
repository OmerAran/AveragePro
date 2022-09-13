package dev.average.pro.controller;

import dev.average.pro.dto.form.FormDto;
import dev.average.pro.dto.user.RegisterRequestDto;
import dev.average.pro.dto.user.UserDto;
import dev.average.pro.model.Form;
import dev.average.pro.model.User;
import dev.average.pro.service.concretes.FormManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/forms")
public class FormController {

    private final FormManager formManager ;
    private final ModelMapper modelMapper ;

    @GetMapping()
    public List<FormDto> getForms(){
        return formManager.getForms().stream()
                .map(form -> modelMapper.map(form, FormDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<FormDto> getForm(@PathVariable Long id){
        Form form = formManager.getForm(id);
        FormDto formDto = modelMapper.map(form, FormDto.class);
        return ResponseEntity.ok().body(formDto);
    }

    @PostMapping()
    public ResponseEntity<Form> newForm(@RequestBody Form form){

        return new ResponseEntity(formManager.newForm(form), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormDto>updateForm(@PathVariable Long id, @RequestBody FormDto formDto){
        Form requestForm = modelMapper.map(formDto, Form.class);
        Form form = formManager.updateForm(id,requestForm);
        FormDto responseForm = modelMapper.map(form, FormDto.class);

        return ResponseEntity.ok().body(responseForm) ;
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Long id){
        formManager.deleteForm(id);
    }



}

package dev.average.pro.controller;

import dev.average.pro.repository.FormRepository;
import dev.average.pro.service.concretes.FormManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pro")
@RequiredArgsConstructor
@CrossOrigin
public class ProController {

    private final FormManager formManager;


    @GetMapping("/avgsalary/{id}")
    public Integer avgSalary(@PathVariable int id){
        return formManager.AvgSalary(id);
    }

    @GetMapping("/avgenv/{id}")
    public Double avgWorkEnvByWork(@PathVariable int id){
        //percent gibi func. yazıp 10 üzerinden değerlendirebiliriz.
        return formManager.avgWorkEnvByWork(id);
    }

    @GetMapping("/avgweek/{id}")
    public Double avgWorkWeekByWork(@PathVariable int id){
        //percent gibi func. yazıp 10 üzerinden değerlendirebiliriz.
        return formManager.avgWorkWeekByWork(id);
    }


}

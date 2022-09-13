package dev.average.pro.controller;

import dev.average.pro.service.concretes.WorkWeekManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkWeekController {

    private final WorkWeekManager workWeekManager;



}

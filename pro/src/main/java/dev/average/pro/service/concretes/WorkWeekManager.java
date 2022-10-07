package dev.average.pro.service.concretes;

import dev.average.pro.dto.workweek.WorkWeekDto;
import dev.average.pro.exception.ResourceNotFoundException;
import dev.average.pro.model.WorkWeek;
import dev.average.pro.repository.WorkWeekRepository;
import dev.average.pro.service.abstracts.WorkWeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/workweeks")
public class WorkWeekManager implements WorkWeekService {

    private final WorkWeekRepository workWeekRepository ;
    @Override
    public  List<WorkWeek> getWorkWeeks() {
        return workWeekRepository.findAll();
    }

    @Override
    public WorkWeek getWorkWeek(int id) {
        return workWeekRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not found work week hours with id : "+id));
    }

    @Override
    public WorkWeek newWorkWeek(WorkWeek workWeek) {
        return workWeekRepository.save(workWeek);
    }

    @Override
    public WorkWeek updateWorkWeek(int id, WorkWeek workWeek) {
        return null;
    }

    @Override
    public void deleteWorkWeek(int id) {
        workWeekRepository.deleteById(id);
    }
}

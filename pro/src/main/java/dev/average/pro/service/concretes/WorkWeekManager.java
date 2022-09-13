package dev.average.pro.service.concretes;

import dev.average.pro.dto.workweek.WorkWeekDto;
import dev.average.pro.model.WorkWeek;
import dev.average.pro.service.abstracts.WorkWeekService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkWeekManager implements WorkWeekService {
    @Override
    public List<WorkWeekDto> getWorkWeeks() {
        return null;
    }

    @Override
    public WorkWeek getWorkWeek(int id) {
        return null;
    }

    @Override
    public WorkWeek newWorkWeek(WorkWeek workWeek) {
        return null;
    }

    @Override
    public WorkWeek updateWorkWeek(int id, WorkWeek workWeek) {
        return null;
    }

    @Override
    public void deleteWorkWeek(int id) {

    }
}

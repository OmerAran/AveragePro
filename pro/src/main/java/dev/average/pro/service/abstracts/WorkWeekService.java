package dev.average.pro.service.abstracts;



import dev.average.pro.dto.workweek.WorkWeekDto;
import dev.average.pro.model.WorkWeek;

import java.util.List;

public interface WorkWeekService {

    List<WorkWeekDto> getWorkWeeks();
    WorkWeek getWorkWeek(int id);
    WorkWeek newWorkWeek(WorkWeek workWeek);
    WorkWeek updateWorkWeek(int id, WorkWeek workWeek);

    void deleteWorkWeek(int id);
}

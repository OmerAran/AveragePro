package dev.average.pro.dto.form;

import dev.average.pro.dto.work.WorkDto;
import dev.average.pro.dto.workenv.WorkEnvDto;
import dev.average.pro.dto.workweek.WorkWeekDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormDto {

    private WorkDto work;

    private WorkWeekDto workWeek;

    private WorkEnvDto workEnv;

    private String description;
    private int salary;
}

package dev.average.pro.service.abstracts;

import dev.average.pro.model.Form;

import java.util.List;

public interface FormService {
    List<Form> getForms();
    Form getForm(Long id);

    Form newForm(Form form);

    Form updateForm(Long id, Form form);

    void deleteForm(Long id);


    Integer countFormsByWork_Id(int id);

    Integer countFormsByWork_NameIgnoreCase(String name);

    Integer countAll();

    Integer countFormsByWorkEnv_Id(int id);
    Integer countFormsByWorkWeek_Id(int id);
    Integer AvgSalary(int id);

    Double avgWorkWeekByWork(int id);

    Double avgWorkEnvByWork(int id);


}

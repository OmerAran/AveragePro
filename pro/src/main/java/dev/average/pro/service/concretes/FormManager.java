package dev.average.pro.service.concretes;

import dev.average.pro.exception.ResourceNotFoundException;
import dev.average.pro.model.Form;
import dev.average.pro.model.User;
import dev.average.pro.repository.FormRepository;
import dev.average.pro.service.abstracts.FormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormManager implements FormService {

    private final FormRepository formRepository;
    @Override
    public List<Form> getForms() {

        return formRepository.findAll();
    }

    @Override
    public Form getForm(Long id) {

        return  formRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("not found form with id : "+id));
    }

    @Override
    public Form newForm(Form form) {
        return formRepository.save(form);
    }

    @Override
    public Form updateForm(Long id, Form newForm) {
        Form oldForm = formRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not Found User with id: "+id));

        oldForm.setWork(newForm.getWork());
        oldForm.setWorkEnv(newForm.getWorkEnv());
        oldForm.setWorkWeek(newForm.getWorkWeek());
        oldForm.setDescription(newForm.getDescription());
        oldForm.setSalary(newForm.getSalary());

        formRepository.save(oldForm);
        return oldForm;
    }

    @Override
    public void deleteForm(Long id) {
        formRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not Found Form with id : "+id));

        formRepository.deleteById(id);
    }

    @Override
    public Integer countFormsByWork_Id(int id) {
        return formRepository.countFormsByWork_Id(id);
    }

    @Override
    public Integer countFormsByWork_NameIgnoreCase(String name) {
        return formRepository.countFormsByWork_NameIgnoreCase(name);
    }

    @Override
    public Integer countAll() {
        return formRepository.countAll();
    }

    @Override
    public Integer countFormsByWorkEnv_Id(int id) {
        return formRepository.countFormsByWorkEnv_Id(id);
    }

    @Override
    public Integer countFormsByWorkWeek_Id(int id) {
        return formRepository.countFormsByWorkWeek_Id(id);
    }

    @Override
    public Integer AvgSalary(int id) {
        return formRepository.AvgSalary(id);
    }

    @Override
    public Double avgWorkWeekByWork(int id) {
        return formRepository.avgWorkWeekByWork(id);
    }

    @Override
    public Double avgWorkEnvByWork(int id) {
        return formRepository.avgWorkEnvByWork(id);
    }
}

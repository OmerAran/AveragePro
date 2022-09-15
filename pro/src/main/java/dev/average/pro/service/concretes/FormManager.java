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
    public Integer rateWork(String name) {
        return formRepository.rateWork( name);
    }

    @Override
    public Integer CountWorkById(int id) {
        return formRepository.CountWorkById(id);
    }
}

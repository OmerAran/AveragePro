package dev.average.pro.service.concretes;

import dev.average.pro.exception.ResourceNotFoundException;
import dev.average.pro.model.Work;
import dev.average.pro.repository.WorkRepository;
import dev.average.pro.service.abstracts.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkManager implements WorkService {

    private final WorkRepository workRepository ;
    @Override
    public List<Work> getWorks() {
        return workRepository.findAll();
    }

    @Override
    public Work getWork(int id) {
        return workRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not found work with id : "+id));
    }

    @Override
    public Work updateWork(int id, Work work) {
        return null;
    }

    @Override
    public Work newWork(Work work) {
        return workRepository.save(work);
    }

    @Override
    public void deleteWork(int id) {
        workRepository.deleteById(id);
    }
}

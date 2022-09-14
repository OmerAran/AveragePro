package dev.average.pro.service.concretes;

import dev.average.pro.dto.workenv.WorkEnvDto;
import dev.average.pro.exception.ResourceNotFoundException;
import dev.average.pro.model.WorkEnv;
import dev.average.pro.repository.WorkEnvRepository;
import dev.average.pro.service.abstracts.WorkEnvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkEnvManager implements WorkEnvService {
    private final WorkEnvRepository workEnvRepository;
    @Override
    public List<WorkEnv> getWorkEnvs() {
        return workEnvRepository.findAll();
    }

    @Override
    public WorkEnv getWorkEnv(int id) {
        return workEnvRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not found work environment with id : "+id));
    }

    @Override
    public WorkEnv newWorkEnv(WorkEnv workEnv) {
        return workEnvRepository.save(workEnv);
    }

    @Override
    public WorkEnv updateWorkEnv(int id, WorkEnv workEnv) {
        return null;
    }

    @Override
    public void deleteWorkEnv(int id) {
        workEnvRepository.deleteById(id);
    }
}

package dev.average.pro.service.concretes;

import dev.average.pro.dto.workenv.WorkEnvDto;
import dev.average.pro.model.WorkEnv;
import dev.average.pro.service.abstracts.WorkEnvService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkEnvManager implements WorkEnvService {
    @Override
    public List<WorkEnvDto> getWorkEnvs() {
        return null;
    }

    @Override
    public WorkEnv getWorkEnv(int id) {
        return null;
    }

    @Override
    public WorkEnv newWorkEnv(WorkEnv workEnv) {
        return null;
    }

    @Override
    public WorkEnv updateWorkEnv(int id, WorkEnv workEnv) {
        return null;
    }

    @Override
    public void deleteWorkEnv(int id) {

    }
}

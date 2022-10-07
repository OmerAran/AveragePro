package dev.average.pro.service.abstracts;

import dev.average.pro.dto.workenv.WorkEnvDto;
import dev.average.pro.model.WorkEnv;

import java.util.List;

public interface WorkEnvService {

    List<WorkEnv> getWorkEnvs();
    WorkEnv getWorkEnv(int id);
    WorkEnv newWorkEnv(WorkEnv workEnv);
    WorkEnv updateWorkEnv(int id, WorkEnv workEnv);

    void deleteWorkEnv(int id);


}

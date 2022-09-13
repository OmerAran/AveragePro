package dev.average.pro.service.concretes;

import dev.average.pro.model.Work;
import dev.average.pro.service.abstracts.WorkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkManager implements WorkService {
    @Override
    public List<Work> getWorks() {
        return null;
    }

    @Override
    public Work getWork(int id) {
        return null;
    }

    @Override
    public Work updateWork(int id, Work work) {
        return null;
    }

    @Override
    public Work newWork(Work work) {
        return null;
    }

    @Override
    public void deleteWork(int id) {

    }
}

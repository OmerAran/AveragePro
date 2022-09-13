package dev.average.pro.service.abstracts;

import dev.average.pro.model.Work;

import java.util.List;

public interface WorkService {

    List<Work> getWorks();
    Work getWork(int id);

    Work updateWork(int id, Work work);

    Work newWork(Work work);
    void deleteWork(int id);
}

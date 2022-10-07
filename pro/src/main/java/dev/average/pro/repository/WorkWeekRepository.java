package dev.average.pro.repository;

import dev.average.pro.model.WorkWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkWeekRepository extends JpaRepository<WorkWeek, Integer> {
}

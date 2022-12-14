package dev.average.pro.repository;

import dev.average.pro.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form,Long> {

    Integer countFormsByWork_NameIgnoreCase(String name);
    Integer countFormsByWork_Id(int id);
    Integer countFormsByWorkEnv_Id(int id);
    Integer countFormsByWorkWeek_Id(int id);

    @Query("select AVG(form.workEnv.id) from Form form where form.work.id=?1")
    Double avgWorkEnvByWork(int workId);

    @Query("select AVG(form.workWeek.id) from Form form where  form.work.id=?1")
    Double avgWorkWeekByWork(int id);

    @Query("SELECT COUNT (form) FROM Form form")
    Integer countAll();


    @Query("select avg(form.salary) from Form form where form.work.id=?1")
    Integer AvgSalary(int id);





}

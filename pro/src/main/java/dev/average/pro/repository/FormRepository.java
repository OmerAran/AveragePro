package dev.average.pro.repository;

import dev.average.pro.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form,Long> {
    @Query("select count(form) from Form form where form.work.name=?1")
    Integer rateWork(String name);


    @Query("select count(form) from Form form where form.work.id=?1")
    Integer CountWorkById(int id);




}

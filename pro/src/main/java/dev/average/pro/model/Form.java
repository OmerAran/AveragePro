package dev.average.pro.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "forms")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_work")
    private Work work;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_workweek")

    private WorkWeek workWeek;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_workenv")
    private WorkEnv workEnv;


    @Column(name = "description")
    private String description;
    @Column(name = "salary")
    private int salary ;
    public void setId(Long id) {
        Id = id;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public void setWorkWeek(WorkWeek workWeek) {
        this.workWeek = workWeek;
    }

    public void setWorkEnv(WorkEnv workEnv) {
        this.workEnv = workEnv;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    public Long getId() {
        return Id;
    }

    public Work getWork() {
        return work;
    }

    public WorkWeek getWorkWeek() {
        return workWeek;
    }
    public WorkEnv getWorkEnv() {
        return workEnv;
    }

    public String getDescription() {
        return description;
    }

    public int getSalary() {
        return salary;
    }





}

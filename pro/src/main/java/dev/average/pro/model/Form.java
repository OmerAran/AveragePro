package dev.average.pro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "forms")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_work")
    private Work work;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_workweek")
    private WorkWeek workWeek;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_workenv")
    private WorkEnv workEnv;


    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private int salary ;

}

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
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Work work;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private WorkWeek workWeek;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private WorkEnv workEnv;


    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private int salary ;

}

package dev.average.pro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "workenvs")
public class WorkEnv {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, name = "work_status")
    private String workStatus;


    @OneToMany(mappedBy = "workEnv")
    private Set<Form> forms = new HashSet<>();

}

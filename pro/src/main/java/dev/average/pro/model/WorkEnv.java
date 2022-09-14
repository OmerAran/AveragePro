package dev.average.pro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@Table(name = "workenvs")
public class WorkEnv {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, name = "work_status")
    private String workStatus;
    @OneToMany(mappedBy = "workEnv")
    private Set<Form> forms = new HashSet<>();

    public int getId() {
        return id;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    @JsonBackReference
    public Set<Form> getForms() {
        return forms;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }



}

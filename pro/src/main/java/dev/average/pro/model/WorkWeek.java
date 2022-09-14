package dev.average.pro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workweeks")
public class WorkWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,name = "work_hours")
    private String workHours;
    @OneToMany(mappedBy = "workWeek")
    private Set<Form> forms = new HashSet<>();


    public int getId() {
        return id;
    }

    public String getWorkHours() {
        return workHours;
    }

    @JsonBackReference
    public Set<Form> getForms() {
        return forms;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }


}

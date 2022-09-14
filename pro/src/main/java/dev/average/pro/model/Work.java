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

@Table(name = "works")
public class Work
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true, name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "work")

    private Set<Form> forms = new HashSet<>();


    public int getId() {
        return id;
    }


    @JsonBackReference
    public Set<Form> getForms() {
        return forms;
    }

    public String getName() {
        return name;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }
}

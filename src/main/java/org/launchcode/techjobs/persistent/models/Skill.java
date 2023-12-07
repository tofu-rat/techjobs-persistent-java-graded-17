package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @NotBlank
    @Size(max=500,min=2,message="Description must be between 2 and 500 characters.")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs = new ArrayList<>();

    public Skill(){}

    public Skill(String description) {
        this.description = description;
    }


    public List<Job> getJobs() {
        return jobs;
    }

    public List<Job> setJobs(){
        return jobs;
    }

    public String getDescription() {
        return description;
}

    public void setDescription(String description) {
        this.description = description;
    }
}
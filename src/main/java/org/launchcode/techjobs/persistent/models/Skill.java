package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {
    @NotBlank
    @Size(max=500,min=2,message="Description must be between 2 and 500 characters.")
    private String description;

    public Skill(){}

    public Skill(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
}

    public void setDescription(String description) {
        this.description = description;
    }
}
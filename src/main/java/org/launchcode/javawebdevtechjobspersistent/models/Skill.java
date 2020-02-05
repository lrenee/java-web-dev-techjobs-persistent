package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

        @NotBlank(message = "Skill description is required.")
        @Size(min = 2, max = 255, message = "Skill description must be between 2 and 255 characters.")
        private String description;

        @ManyToMany(mappedBy = "skills")
        private List<Job> jobs = new ArrayList<>();

        public Skill (String description) {
            this.description = description;
        }

        public Skill () {

        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
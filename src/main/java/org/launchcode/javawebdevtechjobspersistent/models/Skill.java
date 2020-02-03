package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

        @NotBlank(message = "Skill description is required.")
        @Size(min = 2, max = 255, message = "Skill description must be between 2 and 255 characters.")

        private String skillDescription;

        public Skill (String skillDescription) {
            this.skillDescription = skillDescription;
        }

        public Skill () {

        }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

}
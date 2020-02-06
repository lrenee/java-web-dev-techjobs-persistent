package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;

//    private String name;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

    public Job() {
    }

    public Job(Employer anEmployer) {
//    public Job(Employer anEmployer, String someSkills) {
//        super();
        this.employer = anEmployer;
//       this.skills = someSkills;
    }

    // Getters and setters.

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

//    public String getSkills() {
//        return skills;
//    }

//    public void setSkills(String skills) {
//        this.skills = skills;
//    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}

package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.JobData;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs", jobRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
//   public String processAddJobForm(@ModelAttribute @Valid Job newJob,
//                                    Errors errors, Model model, @RequestParam int employerId) {
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId,@RequestParam(required = false) List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        } else if (skills == null) {
            model.addAttribute("employers", employerRepository.findAll());
            model.addAttribute("skills", skillRepository.findAll());
                return "add";
            } else {
            Optional optEmployer = employerRepository.findById(employerId);
            if (optEmployer.isPresent()) {
                Employer employer = (Employer) optEmployer.get();
                newJob.setEmployer(employer);
                List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//                if (skillObjs.isEmpty()) {
//                    return "add";
//                } else {
                    newJob.setSkills(skillObjs);
//                }
                jobRepository.save(newJob);
            } else {
                return "add";
            }
        }

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable Integer jobId) {

        if (jobId == null) {
            model.addAttribute("title", "All Jobs");
            model.addAttribute("job", jobRepository.findAll());
        } else {
            Optional<Job> result = jobRepository.findById(jobId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Job ID: " + jobId);
            } else {
                Job job = result.get();
                model.addAttribute("title", "Events in Job ID: " + jobId);
                model.addAttribute("job", job);
            }

        }

        return "view";
    }


}

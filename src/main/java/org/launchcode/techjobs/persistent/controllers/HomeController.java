package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");
        Iterable<Job> allJobs = jobRepository.findAll();
        model.addAttribute("jobs", allJobs);

        return "index";
    }

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model,
                                    @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");
            return "add";
        }
        Optional<Employer> optionalEmployer = employerRepository.findById(employerId);

        if (optionalEmployer.isPresent()) {

            Employer selectedEmployer = optionalEmployer.get();
            newJob.setEmployer(selectedEmployer);


        } else {
            List<Skill> skillsObjects = (List<Skill>) skillRepository.findAllById(skills);
            newJob.setSkills(skillsObjects);
            newJob.setEmployer(new Employer());
        }
        jobRepository.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            model.addAttribute("job", job);

            return "view";
        } else {

            return "redirect:";
        }
    }

}

package com.projectcms.cms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectcms.cms.dto.JobDto;
import com.projectcms.cms.service.JobService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private JobService jobService;

    //Build Add Job REST API
    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto) {
        JobDto savedJob = jobService.createJob(jobDto);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    //Build Get Job by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable("id") Long id) {
        JobDto jobDto =jobService.getJobById(id);
        return ResponseEntity.ok(jobDto);
    }

    //Build Get All Jobs REST API
    @GetMapping()
    public ResponseEntity<List<JobDto>> getAllJobs() {
        List<JobDto> jobList = jobService.getAllJobs();
        return ResponseEntity.ok(jobList);
    }

    //Build Update Job REST API
    @PutMapping("{id}")
    public ResponseEntity<JobDto> updateJob(@PathVariable("id") Long id, @RequestBody JobDto updatedDto) {
        JobDto jobDto = jobService.updateJob(id, updatedDto);
        return ResponseEntity.ok(jobDto);
    }

    //Build Delete Job REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job Deleted Successfully!");
    }
}

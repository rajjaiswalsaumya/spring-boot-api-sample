package com.example.controllers;

import com.example.entity.JobData;
import com.example.services.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping("/jobs")
public class JobApiController {

    private final JobService jobService;

    public JobApiController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{vendor}/list")
    public List<JobData> list(@PathVariable("vendor") String vendor) throws IOException {
        return this.jobService.getJobsByVendor(vendor);
    }
}

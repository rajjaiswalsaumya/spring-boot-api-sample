package com.example.services;

import com.example.entity.JobData;
import com.example.repository.JobDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobDataRepository jobDataRepository;

    public JobService(JobDataRepository jobDataRepository) {
        this.jobDataRepository = jobDataRepository;
    }

    public List<JobData> getJobsByVendor(String vendor) {
        return this.jobDataRepository.findAllByCommandVendorIgnoreCase(vendor);
    }

}

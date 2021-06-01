package com.example.repository;

import com.example.entity.JobData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobDataRepository extends CrudRepository<JobData, Long> {
    List<JobData> findAllByCommandVendorIgnoreCase(String vendor);
}

package com.example.helpers;

import com.example.entity.JobData;
import com.example.models.FileDataModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JobDataMapper implements Converter<FileDataModel, JobData> {

    private static final String INSERT_JOB = "insert_job";
    private static final String JOB_TYPE = "job_type";
    private static final String COMMAND_VENDOR = "command_vendor";

    @Override
    public JobData convert(FileDataModel model) {
        JobData data = new JobData();
        data.setInsertJob(Optional.ofNullable(model.get(INSERT_JOB)).orElse("").toString());
        data.setJobType(Optional.ofNullable(model.get(JOB_TYPE)).orElse("").toString());
        data.setCommandVendor(Optional.ofNullable(model.get(COMMAND_VENDOR)).orElse("").toString());
        return data;
    }
}

package com.projectcms.cms.service;

import java.util.List;

import com.projectcms.cms.dto.JobDto;

public interface JobService {
    JobDto createJob(JobDto jobDto);

    JobDto getJobById(Long id);

    List<JobDto> getAllJobs();

    JobDto updateJob(Long id, JobDto updatedDto);

    void deleteJob(Long id);
}

package com.projectcms.cms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projectcms.cms.dto.JobDto;
import com.projectcms.cms.entity.Jobs;
import com.projectcms.cms.exception.ResourceNotFound;
import com.projectcms.cms.mapper.JobMapper;
import com.projectcms.cms.repository.JobRepository;
import com.projectcms.cms.service.JobService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Override
    public JobDto createJob(JobDto jobDto) {
        Jobs job = JobMapper.maptoJobs(jobDto);
        Jobs savedJob = jobRepository.save(job);
        return JobMapper.mapToJobDto(savedJob);
    }

    @Override
    public JobDto getJobById(Long id) {
        Jobs job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Job not found with id:" + id));
        return JobMapper.mapToJobDto(job);
    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Jobs> jobList = jobRepository.findAll();
        return jobList.stream().map((job) -> JobMapper.mapToJobDto(job)).collect(Collectors.toList());
    }

    @Override
    public JobDto updateJob(Long id, JobDto updatedDto) {
        Jobs job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("The job doesn't exist with the id:" + id));

        job.setId(id);
        job.setTitle(updatedDto.getTitle());
        job.setDescription(updatedDto.getDescription());
        job.setRequiredSkills(updatedDto.getRequiredSkills());
        job.setRecruiterId(updatedDto.getRecruiterId());

        Jobs updatedJobobj = jobRepository.save(job);
        return JobMapper.mapToJobDto(updatedJobobj);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFound("Job doesn't exist with id: " + id));
        jobRepository.deleteById(id);
    }
    
}



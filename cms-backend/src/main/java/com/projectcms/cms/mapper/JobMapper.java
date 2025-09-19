package com.projectcms.cms.mapper;

import com.projectcms.cms.dto.JobDto;
import com.projectcms.cms.entity.Jobs;

public class JobMapper {
    public static JobDto mapToJobDto(Jobs job){
        return new JobDto(
            job.getId(),
            job.getTitle(),
            job.getDescription(),
            job.getRequiredSkills(),
            job.getRecruiterId()
        );
    }

    public static Jobs maptoJobs(JobDto jobDto){
        return new Jobs(
            jobDto.getId(),
            jobDto.getTitle(),
            jobDto.getDescription(),
            jobDto.getRequiredSkills(),
            jobDto.getRecruiterId()
        );
    }
}

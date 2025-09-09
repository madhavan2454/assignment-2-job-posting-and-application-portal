package com.projectcms.cms.mapper;

import com.projectcms.cms.dto.CandidateDto;
import com.projectcms.cms.entity.Candidate;

public class CandidateMapper {
    public static CandidateDto mapToCandidateDto(Candidate candidate){
        return new CandidateDto(
            candidate.getId(),
            candidate.getName(),
            candidate.getEmail(),
            candidate.getPhoneNumber(),
            candidate.getResumeLink(),
            candidate.getCurrentStatus()
        );
    }
    public static Candidate mapToCandidate(CandidateDto CandidateDto){
        return new Candidate(
            CandidateDto.getId(),
            CandidateDto.getName(),
            CandidateDto.getEmail(),
            CandidateDto.getPhoneNumber(),
            CandidateDto.getResumeLink(),
            CandidateDto.getCurrentStatus()
        );
    }
}

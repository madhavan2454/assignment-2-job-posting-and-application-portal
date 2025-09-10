package com.projectcms.cms.service.impl;

import org.springframework.stereotype.Service;

import com.projectcms.cms.dto.CandidateDto;
import com.projectcms.cms.entity.Candidate;
import com.projectcms.cms.exception.ResourceNotFound;
import com.projectcms.cms.mapper.CandidateMapper;
import com.projectcms.cms.repository.CandidateRepository;
import com.projectcms.cms.service.CandidateService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;
    @Override
    public CandidateDto createCandidate(CandidateDto candidateDto) {
        // Implementation logic here
        Candidate candidate = CandidateMapper.mapToCandidate(candidateDto);
        Candidate savedCandidate = candidateRepository.save(candidate);
        return CandidateMapper.mapToCandidateDto(savedCandidate);
    }
    @Override
    public CandidateDto getCandidateById(Long id) {
       Candidate candidate = candidateRepository.findById(id)
                           .orElseThrow(() -> new ResourceNotFound("Candidate not found with id:" + id));
        return CandidateMapper.mapToCandidateDto(candidate);
    }
}

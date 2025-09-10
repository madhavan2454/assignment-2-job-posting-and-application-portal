package com.projectcms.cms.service;

import java.util.List;

import com.projectcms.cms.dto.CandidateDto;

public interface CandidateService {
    CandidateDto createCandidate(CandidateDto candidateDto);

    CandidateDto getCandidateById(Long id);

    List<CandidateDto> getAllCandidates();

    CandidateDto updateCandidate(Long id, CandidateDto updatedCandidate);

    void deleteCandidate(Long id);
}

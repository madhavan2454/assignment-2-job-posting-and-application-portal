package com.projectcms.cms.service;

import com.projectcms.cms.dto.CandidateDto;

public interface CandidateService {
    CandidateDto createCandidate(CandidateDto candidateDto);

    CandidateDto getCandidateById(Long id);
}

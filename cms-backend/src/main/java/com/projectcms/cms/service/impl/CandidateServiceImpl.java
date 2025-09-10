package com.projectcms.cms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<CandidateDto> getAllCandidates(){
        List<Candidate> candidateslist = candidateRepository.findAll();
        return candidateslist.stream().map((candidate) -> CandidateMapper.mapToCandidateDto(candidate))
                 .collect(Collectors.toList());
    }
    @Override
    public CandidateDto updateCandidate(Long id, CandidateDto updatedCandidate) {
        Candidate candidate =candidateRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFound("Candidate doesn't exist with id: " + id));

        candidate.setName(updatedCandidate.getName());
        candidate.setEmail(updatedCandidate.getEmail());
        candidate.setPhoneNumber(updatedCandidate.getPhoneNumber());
        candidate.setResumeLink(updatedCandidate.getResumeLink());
        candidate.setCurrentStatus(updatedCandidate.getCurrentStatus());

        Candidate updatedCandidateobj = candidateRepository.save(candidate);
        return CandidateMapper.mapToCandidateDto(updatedCandidateobj);
    }
    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFound("Candidate doesn't exist with id: " + id));
        candidateRepository.deleteById(id);

    }
}

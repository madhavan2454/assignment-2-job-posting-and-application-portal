package com.projectcms.cms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectcms.cms.dto.CandidateDto;
import com.projectcms.cms.service.CandidateService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/candidates")
@AllArgsConstructor
public class CandidateController {

    private CandidateService candidateService;

    //Build Add Candidate REST API 
    @PostMapping
    public ResponseEntity<CandidateDto> createCandidate(@RequestBody CandidateDto candidateDto){
        CandidateDto savedCandidate = candidateService.createCandidate(candidateDto);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

    //Build Get Candidate by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<CandidateDto> getCandidateById(@PathVariable("id")Long id){
        CandidateDto candidateDto =candidateService.getCandidateById(id);
        return ResponseEntity.ok(candidateDto);
    }
}

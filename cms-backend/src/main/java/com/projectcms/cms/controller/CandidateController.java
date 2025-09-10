package com.projectcms.cms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    //Build Get All Candidates REST API
    @GetMapping
    public ResponseEntity<List<CandidateDto>> getAllCandidates(){
        List<CandidateDto> candidatesList = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidatesList);
    }

    //Build Update Candidate REST API
    @PutMapping("{id}")
    public ResponseEntity<CandidateDto> updateCandidate(@PathVariable("id")Long id, @RequestBody CandidateDto updatedCandidate){
        CandidateDto candidateDto = candidateService.updateCandidate(id, updatedCandidate);

        return ResponseEntity.ok(candidateDto);
    }

    //Build Delete Candidate REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable("id") long id){
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok("Candidate deleted successfully!");
    }
}

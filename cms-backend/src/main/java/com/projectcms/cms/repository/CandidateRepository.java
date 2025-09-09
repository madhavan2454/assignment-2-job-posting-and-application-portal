package com.projectcms.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcms.cms.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}

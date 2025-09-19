package com.projectcms.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcms.cms.entity.Jobs;

public interface JobRepository extends JpaRepository<Jobs, Long>{

}

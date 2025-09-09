package com.projectcms.cms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Candidate_name")
    private String name;

    @Column(name= "email_id ", nullable = false, unique = true)
    private String email;

    @Column(name= "phone_number")
    private String phoneNumber;

    @Column(name= "resume_link")
    private String resumeLink;

    @Column(name= "current_status")
    private String currentStatus;
}

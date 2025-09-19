package com.projectcms.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private String requiredSkills;
    private String recruiterId;
}

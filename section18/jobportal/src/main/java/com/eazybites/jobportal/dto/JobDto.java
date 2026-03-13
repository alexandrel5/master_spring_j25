package com.eazybites.jobportal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.eazybites.jobportal.entity.Job}
 */
public record JobDto(Long id,
                     String title,
                     Long companyId,
                     String companyName,
                     String companyLogo,
                     String location,
                     String workType,
                     String jobType,
                     String category,
                     String experienceLevel,
                     BigDecimal salaryMin,
                     BigDecimal salaryMax,
                     String salaryCurrency,
                     String salaryPeriod,
                     String description,
                     String requirements,
                     String benefits,
                     Instant postedDate,
                     Instant applicationDeadline,
                     Integer applicationsCount,
                     Boolean featured,
                     Boolean urgent,
                     Boolean remote,
                     String status
    ) implements Serializable {
}
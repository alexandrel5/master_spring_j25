package com.eazybites.jobportal.repository;

import com.eazybites.jobportal.entity.JobPortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPortalUserRepository extends JpaRepository<JobPortalUser, Long> {
}
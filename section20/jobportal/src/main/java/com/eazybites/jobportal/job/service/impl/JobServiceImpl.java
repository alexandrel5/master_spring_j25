package com.eazybites.jobportal.job.service.impl;

import com.eazybites.jobportal.dto.JobApplicationDto;
import com.eazybites.jobportal.dto.JobDto;
import com.eazybites.jobportal.dto.UpdateJobApplicationDto;
import com.eazybites.jobportal.entity.Job;
import com.eazybites.jobportal.entity.JobApplication;
import com.eazybites.jobportal.entity.JobPortalUser;
import com.eazybites.jobportal.job.service.IJobService;
import com.eazybites.jobportal.repository.JobApplicationRepository;
import com.eazybites.jobportal.repository.JobPortalUserRepository;
import com.eazybites.jobportal.repository.JobRepository;
import com.eazybites.jobportal.util.ApplicationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobServiceImpl implements IJobService {

    private final JobRepository jobRepository;
    private final JobPortalUserRepository userRepository;
    private final JobApplicationRepository jobApplicationRepository;

    @Override
    public List<JobDto> getEmployerJobs(String employerEmail) {

        JobPortalUser employer = userRepository.findJobPortalUserByEmail(employerEmail)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
        if (employer.getCompany() == null){
            throw new RuntimeException("Does not have company assigned");
        }

        List<Job> jobs = employer.getCompany().getJobs();
        return jobs.stream()
                .map(job -> ApplicationUtility.transformJobToDto(job))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public JobDto createJob(JobDto jobDto, String employerEmail) {
        // Validate employer and get their company
        JobPortalUser employer = userRepository.findJobPortalUserByEmail(employerEmail)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
        if (employer.getCompany() == null) {
            throw new RuntimeException("Employer does not have a company assigned. Please contact admin.");
        }
        Job job = transformDtoToEntity(jobDto);
        job.setPostedDate(Instant.now());
        job.setApplicationsCount(0);
        job.setStatus("DRAFT");
        job.setCompany(employer.getCompany());
        Job savedJob = jobRepository.save(job);
        return ApplicationUtility.transformJobToDto(savedJob);
    }

    @Transactional
    @Override
    public JobDto updateJobStatus(Long jobId, String status, String employerEmail) {
        status = status.toUpperCase();
        // Validate status
        if (!status.equals("ACTIVE") && !status.equals("CLOSED") && !status.equals("DRAFT")) {
            throw new RuntimeException("Invalid status. Must be ACTIVE, CLOSED, or DRAFT");
        }
        JobPortalUser employer = userRepository.findJobPortalUserByEmail(employerEmail)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        if (employer.getCompany() == null) {
            throw new RuntimeException("Employer does not have a company assigned");
        }
        Job job = employer.getCompany().getJobs().stream().filter(j -> j.getId().equals(jobId)).findFirst()
                .orElseThrow(() -> new RuntimeException("Job not found"));
        job.setStatus(status);
        return ApplicationUtility.transformJobToDto(job);
    }

    @Override
    public List<JobApplicationDto> getApplicationsByJobForEmployer(Long jobId) {
        List<JobApplication> applications = jobApplicationRepository.findByJobIdOrderByAppliedAtAsc(jobId);
        return applications.stream()
                .map(jobApplication -> ApplicationUtility.mapToJobApplicationDto(jobApplication))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public boolean updateJobApplication(UpdateJobApplicationDto dto) {
        int updatedRows = jobApplicationRepository.updateStatusAndNotesById(
                dto.status().name(), dto.notes(),dto.applicationId(), ApplicationUtility.getLoggedInUser());
        return updatedRows > 0;
    }

    private Job transformDtoToEntity(JobDto jobDto) {
        Job job = new Job();
        BeanUtils.copyProperties(jobDto, job);
        return job;
    }

}

package com.eazybites.jobportal.job.service;

import com.eazybites.jobportal.dto.JobApplicationDto;
import com.eazybites.jobportal.dto.JobDto;
import com.eazybites.jobportal.dto.UpdateJobApplicationDto;

import java.util.List;

public interface IJobService {

    List<JobDto> getEmployerJobs(String employerEmail);
    JobDto createJob(JobDto jobDto, String employerEmail);
    JobDto updateJobStatus(Long jobId, String status, String employerEmail);
    List<JobApplicationDto> getApplicationsByJobForEmployer(Long jobId);
    boolean updateJobApplication(UpdateJobApplicationDto updateJobApplicationDto);
}

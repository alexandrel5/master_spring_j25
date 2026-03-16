package com.eazybites.jobportal.job.service;

import com.eazybites.jobportal.dto.JobDto;

import java.util.List;

public interface IJobService {

    List<JobDto> getEmployerJobs(String employerEmail);
    JobDto createJob(JobDto jobDto, String employerEmail);
    JobDto updateJobStatus(Long jobId, String status, String employerEmail);
}

package com.Mahesh.JobApp.Impl;

import com.Mahesh.JobApp.entity.Job;
import com.Mahesh.JobApp.repository.JobRepository;
import com.Mahesh.JobApp.service.JobService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {


    JobRepository jobRepository;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
     return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        boolean flag = jobRepository.findById(id).isPresent();
        if(flag){
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
           Optional<Job> jobOptional = jobRepository.findById(id);
           if(jobOptional.isPresent()){
               Job job=jobOptional.get();
               if(updatedJob.getTitle()!=null)
                   job.setTitle(updatedJob.getTitle());
               if(updatedJob.getDescription()!=null)
                   job.setDescription(updatedJob.getDescription());
               if(updatedJob.getMinSalary()!=null)
                   job.setMinSalary(updatedJob.getMinSalary());
               if(updatedJob.getMaxSalary()!=null)
                   job.setMaxSalary(updatedJob.getMaxSalary());
               if(updatedJob.getLocation()!=null)
                   job.setLocation(updatedJob.getLocation());
               jobRepository.save(job);
               return true;
           }

        return false;
    }
}

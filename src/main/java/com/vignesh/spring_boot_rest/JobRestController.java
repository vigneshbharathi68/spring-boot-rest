package com.vignesh.spring_boot_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.spring_boot_rest.model.JobPost;
import com.vignesh.spring_boot_rest.service.JobService;

@RestController
public class JobRestController {

  @Autowired
  private JobService service;

  @GetMapping("jobPosts")
  public List<JobPost> getAllJobs() {
    return service.getAllJobs();
  }

  @GetMapping("jobPost/{postId}")
  public JobPost getJob(@PathVariable("postId") int postId) {
    return service.getJob(postId);
  }

  @PostMapping("jobPost")
  public String addJob(@RequestBody JobPost jobPost) {
    service.addJob(jobPost);
    return "Job Added successfully";
  }

  @PutMapping("jobPost")
  public JobPost updateJob(@RequestBody JobPost jobPost) {

    service.updateJob(jobPost);
    return service.getJob(jobPost.getPostId());
  }

}

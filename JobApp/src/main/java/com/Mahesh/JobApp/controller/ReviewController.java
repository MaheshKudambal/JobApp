package com.Mahesh.JobApp.controller;


import com.Mahesh.JobApp.entity.Review;

import com.Mahesh.JobApp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review){
       boolean flag =  reviewService.addReview(companyId,review);
       if(flag)
           return new ResponseEntity<>("Review Added Successfully",HttpStatus.OK);
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        Review review = reviewService.getReview(companyId,reviewId);
        if(review!=null)
            return new ResponseEntity<>(review,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,
                                               @RequestBody Review review){
        boolean flag = reviewService.updateReview(companyId,reviewId,review);
        if(flag)
            return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
        boolean flag = reviewService.deleteReview(companyId,reviewId);
        if(flag)
            return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}

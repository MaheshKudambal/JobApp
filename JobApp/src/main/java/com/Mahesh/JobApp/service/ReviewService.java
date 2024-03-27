package com.Mahesh.JobApp.service;

import com.Mahesh.JobApp.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(long companyId);
    Review getReview(long companyId,long reviewId);
    boolean addReview(long companyId,Review review);
    boolean updateReview(long companyId,long reviewId,Review review);
    boolean deleteReview(long companyId,long reviewId);


}

package com.Mahesh.JobApp.Impl;

import com.Mahesh.JobApp.entity.Company;
import com.Mahesh.JobApp.entity.Review;
import com.Mahesh.JobApp.repository.ReviewRepository;
import com.Mahesh.JobApp.service.CompanyService;
import com.Mahesh.JobApp.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }

    @Override
    public List<Review> getAllReviews(long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review getReview(long companyId, long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }

    @Override
    public boolean addReview(long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean updateReview(long companyId, long reviewId, Review updatedReview) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            updatedReview.setCompany(company);
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(long companyId, long reviewId) {
        Review review = getReview(companyId,reviewId);
        if (review!=null){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

}

package edu.icet.ecom.service;

import edu.icet.ecom.dto.Review;
import edu.icet.ecom.entity.ReviewEntity;

import java.util.List;

public interface ReviewService {
    ReviewEntity addReview(Review review);
    List<ReviewEntity> getAllReviews();
    ReviewEntity getReviewById(Long reviewID);
    List<ReviewEntity> getReviewsByVehicleId(Long vehicleID);
    List<ReviewEntity> getReviewsByUserId(Long userID);
    void deleteReview(Long reviewID);
    ReviewEntity updateReview(Long reviewID, Review review);
}

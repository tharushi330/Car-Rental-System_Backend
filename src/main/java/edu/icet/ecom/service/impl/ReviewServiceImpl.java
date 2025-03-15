package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Review;
import edu.icet.ecom.entity.ReviewEntity;
import edu.icet.ecom.repository.ReviewRepository;
import edu.icet.ecom.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Override
    public ReviewEntity addReview(Review review) {
        ReviewEntity reviewEntity = modelMapper.map(review, ReviewEntity.class);
        return reviewRepository.save(reviewEntity);
    }

    @Override
    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public ReviewEntity getReviewById(Long reviewID) {
        return reviewRepository.findById(reviewID).orElse(null);
    }

    @Override
    public List<ReviewEntity> getReviewsByVehicleId(Long vehicleID) {
        return reviewRepository.findByVehicleID(vehicleID);

    }

    @Override
    public List<ReviewEntity> getReviewsByUserId(Long userID) {
        return reviewRepository.findByUserID(userID);
    }

    @Override
    public void deleteReview(Long reviewID) {
        reviewRepository.deleteById(reviewID);
    }

    @Override
    public ReviewEntity updateReview(Long reviewID, Review review) {
        Optional<ReviewEntity> existingReviewOpt = reviewRepository.findById(reviewID);

        if (existingReviewOpt.isPresent()) {
            ReviewEntity existingReview = existingReviewOpt.get();
            modelMapper.map(review, existingReview);  // Map updated fields to the existing entity
            return reviewRepository.save(existingReview);
        }

        return null; // Return null if review is not found
    }

}


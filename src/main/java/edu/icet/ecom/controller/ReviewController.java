package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Review;
import edu.icet.ecom.entity.ReviewEntity;
import edu.icet.ecom.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@CrossOrigin
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/add")
    public ReviewEntity addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/all")
    public List<ReviewEntity> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ReviewEntity getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/vehicle/{vehicleID}")
    public List<ReviewEntity> getReviewsByVehicleId(@PathVariable Long vehicleID) {
        return reviewService.getReviewsByVehicleId(vehicleID);
    }

    @GetMapping("/user/{userID}")
    public List<ReviewEntity> getReviewsByUserId(@PathVariable Long userID) {
        return reviewService.getReviewsByUserId(userID);
    }

    @PutMapping("/update/{id}")
    public ReviewEntity updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}

package com.Kelp2.kelp.controllers;


import com.Kelp2.kelp.models.Review;
import com.Kelp2.kelp.services.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/review")
public class ReviewController {
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private ReviewService reviewService;

    @Autowired
    public ReviewController (ReviewService reviewService){this.reviewService = reviewService;}

    @GetMapping(path="/{aquaId}")
    public ResponseEntity<List<Review>> getReviewByAquaID(@PathVariable(name="aquaId") int aquaId){
        logger.info("Received request for Review by Aquarium ID");
        List<Review> calledReview = reviewService.findReviewByAquaID(aquaId);
        return new ResponseEntity<>(calledReview, HttpStatus.OK);
    }

    @PostMapping(path="/create/{token}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> createReview(@RequestBody String json){
        logger.info("Submitting a Review");
        Review submittedReview = reviewService.saveReview(json);
        return new ResponseEntity<>(submittedReview, HttpStatus.OK);
    }


}

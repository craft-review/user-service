package com.intuit.user.controller;

import com.intuit.user.model.Feedback;
import com.intuit.user.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        feedback.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
        feedback.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
        return feedbackRepository.save(feedback);
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Feedback>> getFeedbackByUserId(@PathVariable(value = "userId") String userId) {
        List<Feedback> feedback = feedbackRepository.findByUserId(userId);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{categoryId}/{userId}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable String categoryId, @PathVariable String userId, @RequestBody Feedback feedbackDetails) {
        Feedback feedback = feedbackRepository.findById(categoryId).orElseThrow();

        if (feedbackDetails.getTransactionDescription() != null) {
            feedback.setTransactionDescription(feedbackDetails.getTransactionDescription());
        }
        if (feedbackDetails.getPersonalisedCategory() != null) {
            feedback.setPersonalisedCategory(feedbackDetails.getPersonalisedCategory());
        }
        if (feedbackDetails.getFeedbackCategory() != null) {
            feedback.setFeedbackCategory(feedbackDetails.getFeedbackCategory());
        }

        final Feedback updatedFeedback = feedbackRepository.save(feedback);
        return ResponseEntity.ok(updatedFeedback);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteFeedback(@PathVariable String categoryId) {
        feedbackRepository.deleteById(categoryId);
    }
}


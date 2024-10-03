package com.intuit.user.controller;

import com.intuit.user.model.request.FeedbackRequestDTO;
import com.intuit.user.model.response.FeedbackResponseDTO;
import com.intuit.user.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/feedback")
@Validated
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackResponseDTO> createFeedback(@Valid @RequestBody FeedbackRequestDTO feedbackRequestDTO) {
        FeedbackResponseDTO createdFeedback = feedbackService.createFeedback(feedbackRequestDTO);
        return ResponseEntity.ok(createdFeedback);
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponseDTO>> getAllFeedbacks() {
        List<FeedbackResponseDTO> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FeedbackResponseDTO>> getFeedbackByUserId(@PathVariable(value = "userId") String userId) {
        List<FeedbackResponseDTO> feedbacks = feedbackService.getFeedbackByUserId(userId);
        return ResponseEntity.ok(feedbacks);
    }

    @PutMapping("/{categoryId}/{userId}")
    public ResponseEntity<FeedbackResponseDTO> updateFeedback(@PathVariable Integer categoryId, @PathVariable String userId, @RequestBody FeedbackRequestDTO feedbackRequestDTO) {
        FeedbackResponseDTO updatedFeedback = feedbackService.updateFeedback(categoryId, userId, feedbackRequestDTO);
        return ResponseEntity.ok(updatedFeedback);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Integer categoryId) {
        feedbackService.deleteFeedback(categoryId);
        return ResponseEntity.noContent().build();
    }
}
package com.intuit.user.service;


import com.intuit.user.model.request.FeedbackRequestDTO;
import com.intuit.user.model.response.FeedbackResponseDTO;

import java.util.List;

public interface FeedbackService {
    FeedbackResponseDTO createFeedback(FeedbackRequestDTO feedbackRequestDTO);

    List<FeedbackResponseDTO> getAllFeedbacks();

    List<FeedbackResponseDTO> getFeedbackByUserId(String userId);

    FeedbackResponseDTO updateFeedback(Integer categoryId, String userId, FeedbackRequestDTO feedbackRequestDTO);

    void deleteFeedback(Integer categoryId);
}

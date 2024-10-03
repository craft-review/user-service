package com.intuit.user.service;

import com.intuit.user.model.Feedback;
import com.intuit.user.model.request.FeedbackRequestDTO;
import com.intuit.user.model.response.FeedbackResponseDTO;
import com.intuit.user.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackResponseDTO createFeedback(FeedbackRequestDTO feedbackRequestDTO) {
        Feedback feedback = new Feedback();
        feedback.setUserId(feedbackRequestDTO.getUserId());
        feedback.setTransactionId(feedbackRequestDTO.getTransactionId());
        feedback.setTransactionDescription(feedbackRequestDTO.getTransactionDescription());
        feedback.setPersonalisedCategory(feedbackRequestDTO.getPersonalisedCategory());
        feedback.setFeedbackCategory(feedbackRequestDTO.getFeedbackCategory());
        feedback.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
        feedback.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));

        Feedback savedFeedback = feedbackRepository.save(feedback);
        return convertToDTO(savedFeedback);
    }

    @Override
    public List<FeedbackResponseDTO> getAllFeedbacks() {
        return feedbackRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackResponseDTO> getFeedbackByUserId(String userId) {
        return feedbackRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackResponseDTO updateFeedback(Integer categoryId, String userId, FeedbackRequestDTO feedbackRequestDTO) {
        Feedback feedback = feedbackRepository.findById(categoryId).orElseThrow();

        if (feedbackRequestDTO.getTransactionDescription() != null) {
            feedback.setTransactionDescription(feedbackRequestDTO.getTransactionDescription());
        }
        if (feedbackRequestDTO.getPersonalisedCategory() != null) {
            feedback.setPersonalisedCategory(feedbackRequestDTO.getPersonalisedCategory());
        }
        if (feedbackRequestDTO.getFeedbackCategory() != null) {
            feedback.setFeedbackCategory(feedbackRequestDTO.getFeedbackCategory());
        }
        feedback.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));

        Feedback updatedFeedback = feedbackRepository.save(feedback);
        return convertToDTO(updatedFeedback);
    }

    @Override
    public void deleteFeedback(Integer categoryId) {
        feedbackRepository.deleteById(categoryId);
    }

    // Convert Feedback entity to DTO
    private FeedbackResponseDTO convertToDTO(Feedback feedback) {
        FeedbackResponseDTO responseDTO = new FeedbackResponseDTO();
        responseDTO.setCategoryId(feedback.getCategoryId());
        responseDTO.setUserId(feedback.getUserId());
        responseDTO.setTransactionId(feedback.getTransactionId());
        responseDTO.setTransactionDescription(feedback.getTransactionDescription());
        responseDTO.setPersonalisedCategory(feedback.getPersonalisedCategory());
        responseDTO.setFeedbackCategory(feedback.getFeedbackCategory());
        responseDTO.setCreatedTimestamp(feedback.getCreatedTimestamp());
        responseDTO.setUpdatedTimestamp(feedback.getUpdatedTimestamp());
        return responseDTO;
    }
}

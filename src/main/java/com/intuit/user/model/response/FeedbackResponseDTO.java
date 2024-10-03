package com.intuit.user.model.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FeedbackResponseDTO {
    private Integer categoryId;
    private String userId;
    private String transactionId;
    private String transactionDescription;
    private String personalisedCategory;
    private String feedbackCategory;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;
}

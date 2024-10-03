package com.intuit.user.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FeedbackRequestDTO {
    @NotBlank(message = "User ID is required.")
    private String userId;

    @NotBlank(message = "Transaction ID is required.")
    private String transactionId;

    @NotBlank(message = "Transaction Desc is required.")
    private String transactionDescription;

    @NotNull(message = "Personalised category is required.")
    private String personalisedCategory;

    @NotNull(message = "Feedback category is required.")
    private String feedbackCategory;
}

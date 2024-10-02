package com.intuit.user.model;

import javax.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_feedback")
public class Feedback {

    @Id
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "transaction_description")
    private String transactionDescription;

    @Column(name = "personalised_category")
    private String personalisedCategory;

    @Column(name = "feedback_category")
    private String feedbackCategory;

    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "updated_timestamp")
    private Timestamp updatedTimestamp;
}



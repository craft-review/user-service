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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

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

/*
create database feedback_db;

use feedback_db;

CREATE TABLE user_feedback (
  category_id VARCHAR(255),
  user_id VARCHAR(255),
  transaction_id VARCHAR(255),
  transaction_description TEXT,
  personalised_category VARCHAR(255),
  feedback_category VARCHAR(255),
  created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (category_id)
);

select * from user_feedback

 */


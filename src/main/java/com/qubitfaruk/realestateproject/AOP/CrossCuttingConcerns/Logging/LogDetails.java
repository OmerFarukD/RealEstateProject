package com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Logging;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_details")
public class LogDetails {

    @Id
    @GeneratedValue()
    private long id;
    private String methodName;
    private String parameters;
}

package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class JobData {

    @Id
    @GeneratedValue
    private Long id;

    private String insertJob;

    private String jobType;

    private String commandVendor;
}

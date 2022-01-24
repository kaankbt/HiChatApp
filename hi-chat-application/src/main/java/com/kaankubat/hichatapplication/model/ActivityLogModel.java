package com.kaankubat.hichatapplication.model;

import com.kaankubat.hichatapplication.enums.ActivityType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class ActivityLogModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String userName;

    private ActivityType activity;
}
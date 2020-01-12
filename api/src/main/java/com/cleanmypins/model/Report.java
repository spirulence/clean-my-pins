package com.cleanmypins.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
    public enum State {
        STARTED, FINISHED, ERROR
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long reportId;

    public String board;
    public State reportState;
    public long reportTime;

    public String greenLinks;
    public String yellowLinks;
    public String redLinks;
}

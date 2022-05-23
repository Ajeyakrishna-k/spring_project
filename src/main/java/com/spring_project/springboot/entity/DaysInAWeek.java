package com.spring_project.springboot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "days_in_a_week")
public class DaysInAWeek {
    @Id
    private int days;

    private long number_of_calls;
}
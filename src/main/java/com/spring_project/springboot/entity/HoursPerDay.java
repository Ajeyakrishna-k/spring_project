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
@Table(name = "hour_of_day")
public class HoursPerDay {
    @Id
    private int hours;

    private long number_of_calls;


}

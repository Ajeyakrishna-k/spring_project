package com.spring_project.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "call_data")
public class CallData {


    private static final String dateFormat = "dd/MM/yyyy hh:mm:ss";
    @Id
    @GeneratedValue
    private int id;
    private long from_number;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = dateFormat)
    private Date start_time;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = dateFormat)
    private Date end_time;
    private long duration;

}


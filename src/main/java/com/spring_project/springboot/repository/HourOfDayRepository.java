package com.spring_project.springboot.repository;

import com.spring_project.springboot.entity.HoursPerDay;
import org.springframework.data.repository.CrudRepository;

public interface HourOfDayRepository extends CrudRepository<HoursPerDay,Integer> {
}

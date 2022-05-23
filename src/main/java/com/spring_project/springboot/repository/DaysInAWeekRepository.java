package com.spring_project.springboot.repository;

import com.spring_project.springboot.entity.DaysInAWeek;
import org.springframework.data.repository.CrudRepository;

public interface DaysInAWeekRepository extends CrudRepository<DaysInAWeek,Integer> {
}

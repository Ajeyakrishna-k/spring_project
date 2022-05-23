package com.spring_project.springboot.service;

import com.spring_project.springboot.entity.CallData;
import com.spring_project.springboot.entity.HoursPerDay;
import com.spring_project.springboot.repository.HourOfDayRepository;
import com.spring_project.springboot.service.serviceUtils.CallDataServiceUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class HoursPerDayService {

    @Autowired
    private HourOfDayRepository hourOfDayRepository;

    public Iterable<HoursPerDay> getHoursPerDayList(){
        return hourOfDayRepository.findAll();
    }

    public HoursPerDay findById(int id){
        return hourOfDayRepository.findById(id).orElse(null);
    }

    public HoursPerDay update(HoursPerDay hoursPerDay){
//        HoursPerDay existing = findById(hoursPerDay.getHours());
//        if(existing != null) {
//            existing.setNumber_of_calls(hoursPerDay.getNumber_of_calls());
//            return hourOfDayRepository.save(existing);
//        }
//        return null;
        return hourOfDayRepository.save(hoursPerDay);
    }

    public HoursPerDay updateWhileSavingCallData(CallData callData){
        int hour = callData.getStart_time().getHours();
        HoursPerDay existing = findById(hour);
        return CallDataServiceUtils.getHoursPerDay(callData,existing);
    }

}

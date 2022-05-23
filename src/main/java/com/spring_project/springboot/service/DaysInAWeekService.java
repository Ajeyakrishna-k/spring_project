package com.spring_project.springboot.service;

import com.spring_project.springboot.entity.CallData;
import com.spring_project.springboot.entity.DaysInAWeek;
import com.spring_project.springboot.repository.DaysInAWeekRepository;
import com.spring_project.springboot.service.serviceUtils.CallDataServiceUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DaysInAWeekService {

    @Autowired
    private DaysInAWeekRepository daysInAWeekRepository;

    public Iterable<DaysInAWeek> getDaysInAWeek(){
        return daysInAWeekRepository.findAll();
    }

    public DaysInAWeek findById(int id){
        return daysInAWeekRepository.findById(id).orElse(null);
    }

    public DaysInAWeek update(DaysInAWeek daysInAWeek){
//        HoursPerDay existing = findById(hoursPerDay.getHours());
//        if(existing != null) {
//            existing.setNumber_of_calls(hoursPerDay.getNumber_of_calls());
//            return hourOfDayRepository.save(existing);
//        }
//        return null;
        return daysInAWeekRepository.save(daysInAWeek);
    }

    public DaysInAWeek updateWhileSavingCallData(CallData callData){
        int day = callData.getStart_time().getDay();
        DaysInAWeek existing = findById(day);
        return CallDataServiceUtils.getDaysInAWeek(callData,existing);
    }

}

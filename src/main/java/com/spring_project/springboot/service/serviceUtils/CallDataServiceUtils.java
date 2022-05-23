package com.spring_project.springboot.service.serviceUtils;

import com.spring_project.springboot.entity.CallData;
import com.spring_project.springboot.entity.DaysInAWeek;
import com.spring_project.springboot.entity.HoursPerDay;

import java.time.Duration;
import java.util.List;

public class CallDataServiceUtils {


    public static long calculateCallDataDuration(CallData callData){
        return Duration.between(callData.getStart_time().toInstant(),callData.getEnd_time().toInstant()).getSeconds();
    }

    public static void updateCallDataDuration(CallData callData){
        callData.setDuration(Duration.between(callData.getStart_time().toInstant(),callData.getEnd_time().toInstant()).getSeconds());
    }

    public static void updateCallDataDuration(List<CallData> callDataList){
        callDataList.forEach(CallDataServiceUtils::updateCallDataDuration);
    }

    public static HoursPerDay getHoursPerDay(CallData callData,HoursPerDay hoursPerDay){
        if (hoursPerDay == null) {
            int hour = callData.getStart_time().getHours();
            hoursPerDay = new HoursPerDay();
            hoursPerDay.setHours(hour);
        }
        hoursPerDay.setNumber_of_calls(hoursPerDay.getNumber_of_calls()+1);
        return hoursPerDay;
    }

    public static DaysInAWeek getDaysInAWeek(CallData callData, DaysInAWeek daysInAWeek){
        if (daysInAWeek == null) {
            int day = callData.getStart_time().getDay();
            daysInAWeek = new DaysInAWeek();
            daysInAWeek.setDays(day);
        }
        daysInAWeek.setNumber_of_calls(daysInAWeek.getNumber_of_calls()+1);
        return daysInAWeek;
    }
}


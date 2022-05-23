package com.spring_project.springboot.service.callAnalytics;

import com.spring_project.springboot.entity.DaysInAWeek;
import com.spring_project.springboot.service.DaysInAWeekService;
import com.spring_project.springboot.utils.GenericUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallVolumePerWeekCalculator extends CallAnalyticsCalculator {

    @Autowired
    private DaysInAWeekService daysInAWeekService;

//    public String getCallDurationPerDayOfWeekInfo(){
//        Iterable<CallData> callDataIterable = callDataService.getAllCallDataList();
//        long[] callVolumeOfADay = new long[7];
//        for(CallData callData : callDataIterable){
//            //            int day = LocalDateTime.from(callData.getStart_time().toInstant()).getDayOfWeek().getValue();
//            int day = callData.getStart_time().getDay();
//            callVolumeOfADay[day]++;
//        }
//
//        long max = -1;
//        int maxIndex = -1;
//        for(int i = 0 ; i < callVolumeOfADay.length; i++){
//            if(callVolumeOfADay[i] > max){
//                max = callVolumeOfADay[i];
//                maxIndex = i;
//            }
//        }
//        return "Day of the Week when call volume is the highest: "+ maxIndex + " day of week";
//    }

    public String getCallDurationPerDayOfWeekInfo(){

        Iterable<DaysInAWeek> dayList = daysInAWeekService.getDaysInAWeek();
        int maxIndex = -1;
        long max = -1;
        for(DaysInAWeek daysInAWeek : dayList){
            if(daysInAWeek.getNumber_of_calls() > max){
                max = daysInAWeek.getNumber_of_calls();
                maxIndex = daysInAWeek.getDays();
            }
        }
        return "Day of the Week when call volume is the highest: "+ GenericUtils.getDayOfWeekString(maxIndex);
    }

}

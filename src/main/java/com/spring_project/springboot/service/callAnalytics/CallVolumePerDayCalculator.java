package com.spring_project.springboot.service.callAnalytics;

import com.spring_project.springboot.entity.HoursPerDay;
import com.spring_project.springboot.service.HoursPerDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallVolumePerDayCalculator extends CallAnalyticsCalculator {

    @Autowired
    private HoursPerDayService hoursPerDayService;

    // next day 0 gets an extra hit if ent time crosses 24?

    //    public String getCallVolumePerDayHourInfo(){
//        Iterable<CallData> callDataIterable = callDataService.getAllCallDataList();
//        int[] callFrequency = new int[24];
//        for(CallData callData : callDataIterable){
//            //            int hour = LocalTime.from(callData.getStart_time().toInstant()).getHour();
//            int hour = callData.getStart_time().getHours();
//            callFrequency[hour]++;
//        }
//        System.out.println(Arrays.toString(callFrequency));
//
//        int max = -1, maxIndex = -1;
//        for(int i = 0 ; i < callFrequency.length; i++){
//            if(callFrequency[i] > max){
//                max = callFrequency[i];
//                maxIndex = i;
//            }
//        }
//        return "Hour of the day when call volume is the highest: "+maxIndex+" : 00 to "+(maxIndex + 1)+" : 00";
//    }
    public String getCallVolumePerDayHourInfo(){
        Iterable<HoursPerDay> hoursPerDayList = hoursPerDayService.getHoursPerDayList();
        long maxIndex = -1, max = -1;
        for(HoursPerDay hoursPerDay : hoursPerDayList){
            if(hoursPerDay.getNumber_of_calls() > max){
                max = hoursPerDay.getNumber_of_calls();
                maxIndex = hoursPerDay.getHours();
            }
        }
        return "Hour of the day when call volume is the highest: "+maxIndex+" : 00 to "+(maxIndex + 1)+" : 00";
    }
}

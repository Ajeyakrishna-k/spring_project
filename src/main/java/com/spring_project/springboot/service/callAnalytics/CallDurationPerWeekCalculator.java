package com.spring_project.springboot.service.callAnalytics;

import com.spring_project.springboot.entity.CallData;
import com.spring_project.springboot.utils.GenericUtils;
import org.springframework.stereotype.Component;

@Component
public class CallDurationPerWeekCalculator extends CallAnalyticsCalculator {

    public String getCallDurationPerDayOfWeekInfo(){
        Iterable<CallData> callDataIterable = callDataService.getAllCallDataList();
        long[] callDurationPerWeek = new long[7];
        for(CallData callData : callDataIterable){

//            int day = LocalDateTime.from(callData.getStart_time().toInstant()).getDayOfWeek().getValue();
            int day = callData.getStart_time().getDay();
//            callDurationPerWeek[day] += ((double)callData.getDuration()/1000);
            if(callData.getDuration() > callDurationPerWeek[day]){
                callDurationPerWeek[day] = callData.getDuration();
            }
        }

        long max = -1;
        int maxIndex = -1;

        for(int i = 0 ; i < callDurationPerWeek.length; i++){
            if(callDurationPerWeek[i] > max){
                max = callDurationPerWeek[i];
                maxIndex = i;
            }
        }

        return "Day of the Week when call duration is the highest is: "+ GenericUtils.getDayOfWeekString(maxIndex);
    }
}

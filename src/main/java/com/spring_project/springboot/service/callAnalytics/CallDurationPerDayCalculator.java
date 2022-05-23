package com.spring_project.springboot.service.callAnalytics;

import com.spring_project.springboot.entity.CallData;
import org.springframework.stereotype.Component;

@Component
public class CallDurationPerDayCalculator extends CallAnalyticsCalculator{

    public String getCallVolumePerDayHourInfo(){
        Iterable<CallData> callDataIterable = callDataService.getAllCallDataList();

        long[] callDurationPerHour = new long[24];

        for(CallData callData : callDataIterable){

//            int hour = LocalTime.from(callData.getStart_time().toInstant()).getHour();
            int hour = callData.getStart_time().getHours();
//            callDurationPerHour[hour] += ((double)callData.getDuration()/1000);
            if(callData.getDuration() > callDurationPerHour[hour]){
                callDurationPerHour[hour] = callData.getDuration();
            }
        }

        long max = -1;
        int maxIndex = -1;
        for(int i = 0 ; i < callDurationPerHour.length; i++){
            if(callDurationPerHour[i] > max){
                max = callDurationPerHour[i];
                maxIndex = i;
            }
        }

        return "Hour of the day when call duration is the highest: "+maxIndex+" : 00 to "+(maxIndex + 1)+" : 00";
    }
}

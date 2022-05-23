package com.spring_project.springboot.service;

import com.spring_project.springboot.service.callAnalytics.CallDurationPerDayCalculator;
import com.spring_project.springboot.service.callAnalytics.CallDurationPerWeekCalculator;
import com.spring_project.springboot.service.callAnalytics.CallVolumePerDayCalculator;
import com.spring_project.springboot.service.callAnalytics.CallVolumePerWeekCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallAnalyticsService {

    @Autowired
    CallDurationPerDayCalculator callDurationPerDayCalculator;

    @Autowired
    CallDurationPerWeekCalculator callDurationPerWeekCalculator;

    @Autowired
    CallVolumePerDayCalculator callVolumePerDayCalculator;

    @Autowired
    CallVolumePerWeekCalculator callVolumePerWeekCalculator;


    public String get_call_volume_day(){
        return callVolumePerDayCalculator.getCallVolumePerDayHourInfo();
    }


    public String get_call_volume_week(){
        return callVolumePerWeekCalculator.getCallDurationPerDayOfWeekInfo();
    }

    public String get_call_duration_day(){
        return callDurationPerDayCalculator.getCallVolumePerDayHourInfo();
    }

    public String get_call_duration_week(){
        return callDurationPerWeekCalculator.getCallDurationPerDayOfWeekInfo();
    }

}


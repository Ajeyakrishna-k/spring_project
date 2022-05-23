package com.spring_project.springboot.service.callAnalytics;

import com.spring_project.springboot.service.CallDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallAnalyticsCalculator {

    @Autowired
    protected CallDataService callDataService;

}

package com.spring_project.springboot.controller;

import com.spring_project.springboot.entity.CallData;
import com.spring_project.springboot.service.CallAnalyticsService;
import com.spring_project.springboot.service.CallDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RequestMapping(path="/callData")
@RestController
public class CallDataController {

    @Autowired
    private CallDataService callDataService;
    @Autowired
    private CallAnalyticsService callAnalyticsService;

    @PostMapping(path="/add")
    public @ResponseBody String addNewCallData (@RequestBody CallData callData) {
        callDataService.saveCallData(callData);
        return "Saved successfully!";
    }

    @GetMapping("/get/{id}")
    public @ResponseBody CallData getCallData(@PathVariable int id) {
        return callDataService.getCallDataById(id);
    }

    @GetMapping("/analytics/{type}")
    public @ResponseBody String getCallDataAnalytics(@PathVariable String type) {
        return switch (type.toLowerCase()) {
            case "hourly_volume" -> callAnalyticsService.get_call_volume_day();
            case "hourly_duration" -> callAnalyticsService.get_call_duration_day();
            case "weekly_volume" -> callAnalyticsService.get_call_volume_week();
            case "weekly_duration" -> callAnalyticsService.get_call_duration_week();
            default -> "No Service available";
        };
    }

}

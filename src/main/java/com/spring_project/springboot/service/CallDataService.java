package com.spring_project.springboot.service;

import com.spring_project.springboot.entity.CallData;
import com.spring_project.springboot.repository.CallDataRepository;
import com.spring_project.springboot.service.serviceUtils.CallDataServiceUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CallDataService {

    @Autowired
    private CallDataRepository callDataRepository;

    @Autowired
    private HoursPerDayService hoursPerDayService;

    @Autowired
    private DaysInAWeekService daysInAWeekService;

    public CallData saveCallData(CallData callData) {
        CallDataServiceUtils.updateCallDataDuration(callData);
        hoursPerDayService.update(hoursPerDayService.updateWhileSavingCallData(callData));
        daysInAWeekService.update(daysInAWeekService.updateWhileSavingCallData(callData));
        return callDataRepository.save(callData);
    }


//    public Iterable<CallData> saveCallDataList(List<CallData> callDataList) {
//        CallDataServiceUtils.updateCallDataDuration(callDataList);
//        return callDataRepository.saveAll(callDataList);
//    }

    public CallData getCallDataById(int id) {
        return callDataRepository.findById(id).orElse(null);
    }

    public Iterable<CallData> getAllCallDataList() {
        return callDataRepository.findAll();
    }
}




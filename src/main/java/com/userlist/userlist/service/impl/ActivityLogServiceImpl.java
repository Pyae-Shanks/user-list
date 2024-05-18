package com.userlist.userlist.service.impl;

import com.userlist.userlist.entity.ActivityLog;
import com.userlist.userlist.repository.ActivityLogRepository;
import com.userlist.userlist.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;


    @Override
    public void saveActivityLogFromUser(List <ActivityLog> activityLog) {
        activityLogRepository.saveAll(activityLog);
    }
}

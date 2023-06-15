package com.userlist.userlist.service.impl;

import com.userlist.userlist.entity.UserActivityLog;
import com.userlist.userlist.repository.UserActivityLogRepository;
import com.userlist.userlist.service.UserActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActivityLogServiceImpl implements UserActivityLogService {

    @Autowired
    private UserActivityLogRepository userActivityLogRepository;


    @Override
    public UserActivityLog saveActivityLog(UserActivityLog userActivityLog) {
        return userActivityLogRepository.save(userActivityLog);
    }
}

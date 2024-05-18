package com.userlist.userlist.service;

import com.userlist.userlist.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    void saveActivityLogFromUser (List<ActivityLog> activityLog);
}

package com.userlist.userlist.repository;

import com.userlist.userlist.entity.UserActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityLogRepository extends JpaRepository<UserActivityLog,Long> {

}

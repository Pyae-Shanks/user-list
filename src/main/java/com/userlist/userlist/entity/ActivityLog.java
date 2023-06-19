package com.userlist.userlist.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ActivityLog")
@EntityListeners(AuditingEntityListener.class)
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String changedField;
    private String valueFrom;
    private String valueTo;
    @CreatedDate()
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "fk_userActivityLog_id")
    private UserActivityLog userActivityLog;

    public ActivityLog(String changedField, String valueFrom, String valueTo, LocalDateTime createdDate, UserActivityLog userActivityLog) {
        this.changedField = changedField;
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
        this.createdDate = createdDate;
        this.userActivityLog = userActivityLog;
    }

    public ActivityLog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChangedField() {
        return changedField;
    }

    public void setChangedField(String changedField) {
        this.changedField = changedField;
    }

    public String getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(String valueFrom) {
        this.valueFrom = valueFrom;
    }

    public String getValueTo() {
        return valueTo;
    }

    public void setValueTo(String valueTo) {
        this.valueTo = valueTo;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserActivityLog getUserActivityLog() {
        return userActivityLog;
    }

    public void setUserActivityLog(UserActivityLog userActivityLog) {
        this.userActivityLog = userActivityLog;
    }
}

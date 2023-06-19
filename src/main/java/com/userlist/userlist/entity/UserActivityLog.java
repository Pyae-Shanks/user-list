package com.userlist.userlist.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userActivityLog")
@EntityListeners(AuditingEntityListener.class)
public class UserActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;
    private String changedField;
    private String valueFrom;
    private String valueTo;
    private Long editedId;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @OneToMany(mappedBy = "userActivityLog", cascade = CascadeType.ALL)
    private List<ActivityLog> activityLogsByUserActivity = new ArrayList<>();

    @CreatedDate()
    private LocalDateTime createdDate;

    public UserActivityLog(String action, String changedField, String valueFrom, String valueTo, Long editedId, User user, LocalDateTime createdDate) {
        this.action = action;
        this.changedField = changedField;
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
        this.editedId = editedId;
        this.user = user;
        this.createdDate = createdDate;
    }

    public UserActivityLog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public Long getEditedId() {
        return editedId;
    }

    public void setEditedId(Long editedId) {
        this.editedId = editedId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}

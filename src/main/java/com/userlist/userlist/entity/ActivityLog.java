package com.userlist.userlist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ActivityLog")
public class ActivityLog {
    @Id
    private Long id;
    private String editedId;
    private String valueFrom;
    private String valueTo;

}

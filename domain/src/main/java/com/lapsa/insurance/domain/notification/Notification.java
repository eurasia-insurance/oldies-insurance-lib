package com.lapsa.insurance.domain.notification;

import java.util.Date;

import com.lapsa.insurance.crm.NotificationStatus;
import com.lapsa.insurance.domain.BaseEntity;

public abstract class Notification extends BaseEntity<Integer> {
    private static final long serialVersionUID = -1902885458072366192L;

    private Date created;
    private Date updated;
    private NotificationStatus status;

    // GENERATED

    public Date getCreated() {
	return created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

    public Date getUpdated() {
	return updated;
    }

    public void setUpdated(Date updated) {
	this.updated = updated;
    }

    public NotificationStatus getStatus() {
	return status;
    }

    public void setStatus(NotificationStatus status) {
	this.status = status;
    }
}

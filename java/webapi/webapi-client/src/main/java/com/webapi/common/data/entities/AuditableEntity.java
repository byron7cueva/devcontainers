package com.webapi.common.data.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EntityListeners({ AuditingEntityListener.class })
@MappedSuperclass
public class AuditableEntity {
    @Column(name = "status", length = 1)
    protected String status;

    @CreatedBy
    @Column(name = "created_by_user", updatable = false)
    protected Long createdByUser;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    protected Date createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by_user")
    protected Long lastModifiedByUser;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date")
    protected Date lastModifiedDate;

    @Column(name = "created_from_ip", updatable = false)
    protected String createdFromIp;

    @Column(name = "updated_from_ip")
    protected String updatedFromIp;
}

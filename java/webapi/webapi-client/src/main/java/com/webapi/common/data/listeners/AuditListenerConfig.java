package com.webapi.common.data.listeners;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.hibernate.HibernateException;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.MergeContext;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;
import org.hibernate.event.spi.PersistContext;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.webapi.common.data.entities.AuditableEntity;
import com.webapi.common.data.enums.Status;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;

@Component
@Configuration
public class AuditListenerConfig implements PersistEventListener, MergeEventListener {

    @Lazy
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    private void init() {
        SessionFactoryImpl sessionFactory = this.entityManagerFactory.unwrap(
                SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry()
                .getService(EventListenerRegistry.class);
        registry.prependListeners(EventType.PERSIST, this);
        registry.prependListeners(EventType.MERGE, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPersist(PersistEvent event) throws HibernateException {
        if (event.getObject() instanceof AuditableEntity) {
            this.loadInsertAuditFields((AuditableEntity) event.getObject());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPersist(PersistEvent event, PersistContext createdAlready)
            throws HibernateException {
    }

    /**
     * Load insert audit fields.
     *
     * @param audit AbstractBaseAuditable
     */
    private void loadInsertAuditFields(AuditableEntity audit) {
        audit.setStatus(Status.ACTIVE.value);
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            audit.setCreatedFromIp(ipAddr.getHostAddress());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void loadUpdateAuditFields(AuditableEntity audit) {
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            audit.setUpdatedFromIp(ipAddr.getHostAddress());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onMerge(MergeEvent event) throws HibernateException {
        if (event.getOriginal() instanceof AuditableEntity) {
            this.loadUpdateAuditFields((AuditableEntity) event.getOriginal());
        }
    }

    @Override
    public void onMerge(MergeEvent event, MergeContext copiedAlready) throws HibernateException {
    }
}
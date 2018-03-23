package com.mml.domain.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "logging_event_property")
public class LoggingEventProperty implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne
    @JoinColumn(name="event_id")
    private LoggingEvent loggingEvent;
    @Id
    @Column(columnDefinition="VARCHAR(254) NOT NULL")
    private String mappedKey;
    @Column(columnDefinition="TEXT")
    private String mappedValue;

    public LoggingEventProperty() {
        super();
    }

    public LoggingEvent getLoggingEvent() {
        return loggingEvent;
    }

    public void setLoggingEvent(LoggingEvent loggingEvent) {
        this.loggingEvent = loggingEvent;
    }

    public String getMappedKey() {
        return mappedKey;
    }

    public void setMappedKey(String mappedKey) {
        this.mappedKey = mappedKey;
    }

    public String getMappedValue() {
        return mappedValue;
    }

    public void setMappedValue(String mappedValue) {
        this.mappedValue = mappedValue;
    }
}


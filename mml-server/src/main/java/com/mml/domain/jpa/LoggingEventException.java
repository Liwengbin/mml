package com.mml.domain.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "logging_event_exception")
public class LoggingEventException implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne
    @JoinColumn(name="event_id")
    private LoggingEvent loggingEvent;
    @Id
    @GeneratedValue
    @Column(columnDefinition="SMALLINT NOT NULL")
    private int i;
    @Column(columnDefinition="VARCHAR(254) NOT NULL")
    private String traceLine;

    public LoggingEventException() {
        super();
    }

    public LoggingEvent getLoggingEvent() {
        return loggingEvent;
    }

    public void setLoggingEvent(LoggingEvent loggingEvent) {
        this.loggingEvent = loggingEvent;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getTraceLine() {
        return traceLine;
    }

    public void setTraceLine(String traceLine) {
        this.traceLine = traceLine;
    }
}

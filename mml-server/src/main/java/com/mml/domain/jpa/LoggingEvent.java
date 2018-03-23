package com.mml.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "logging_event")
public class LoggingEvent {
    @Id
    @GeneratedValue
    @Column(columnDefinition="BIGINT NOT NULL")
    private  Long eventId;
    @Column(columnDefinition="BIGINT NOT NULL")
    private Long timestmp;
    @Column(columnDefinition="TEXT NOT NULL")
    private String formattedMessage;
    @Column(columnDefinition="VARCHAR(254) NOT NULL")
    private String loggerName;
    @Column(columnDefinition="VARCHAR(254) NOT NULL")
    private String levelString;
    @Column(columnDefinition="VARCHAR(254)")
    private String threadName;
    @Column(columnDefinition="SMALLINT")
    private int referenceFlag;
    @Column(columnDefinition="VARCHAR(254)")
    private String arg0;
    @Column(columnDefinition="VARCHAR(254)")
    private String arg1;
    @Column(columnDefinition="VARCHAR(254)")
    private String arg2;
    @Column(columnDefinition="VARCHAR(254)")
    private String arg3;
    @Column(columnDefinition="VARCHAR(254) NOT NULL")
    private String callerFilename;
    @Column(columnDefinition="VARCHAR(254) NOT NULL")
    private String callerClass;

    @Column(columnDefinition="VARCHAR(254) NOT NULL")
    private String callerMethod;
    @Column(columnDefinition="CHAR(4) NOT NULL")
    private String callerLine;

    public LoggingEvent() {
        super();
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getTimestmp() {
        return timestmp;
    }

    public void setTimestmp(Long timestmp) {
        this.timestmp = timestmp;
    }

    public void setReferenceFlag(int referenceFlag) {
        this.referenceFlag = referenceFlag;
    }

    public String getFormattedMessage() {
        return formattedMessage;
    }

    public void setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getLevelString() {
        return levelString;
    }

    public void setLevelString(String levelString) {
        this.levelString = levelString;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public int getReferenceFlag() {
        return referenceFlag;
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getCallerFilename() {
        return callerFilename;
    }

    public void setCallerFilename(String callerFilename) {
        this.callerFilename = callerFilename;
    }

    public String getCallerClass() {
        return callerClass;
    }

    public void setCallerClass(String callerClass) {
        this.callerClass = callerClass;
    }

    public String getCallerMethod() {
        return callerMethod;
    }

    public void setCallerMethod(String callerMethod) {
        this.callerMethod = callerMethod;
    }

    public String getCallerLine() {
        return callerLine;
    }

    public void setCallerLine(String callerLine) {
        this.callerLine = callerLine;
    }
}

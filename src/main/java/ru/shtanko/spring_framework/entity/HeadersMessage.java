package ru.shtanko.spring_framework.entity;


import javax.persistence.*;

@Entity
@Table(name = "headers")
public class HeadersMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jsmCorrelationID;

    private String jsmMessageID;

    private byte[] jmsCorrelationIDAsBytes;

    private int jsmDeliveryMode;

    private String jmsDestination;

    private long jsmExpiration;

    private int jmsPriority;

    private boolean jmsRedelivered;

    private String jmsReplyTo;

    private long jmsTimestamp;

    private String jmsType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJsmCorrelationID() {
        return jsmCorrelationID;
    }

    public void setJsmCorrelationID(String jsmCorrelationID) {
        this.jsmCorrelationID = jsmCorrelationID;
    }

    public String getJsmMessageID() {
        return jsmMessageID;
    }

    public void setJsmMessageID(String jsmMessageID) {
        this.jsmMessageID = jsmMessageID;
    }

    public byte[] getJmsCorrelationIDAsBytes() {
        return jmsCorrelationIDAsBytes;
    }

    public void setJmsCorrelationIDAsBytes(byte[] jmsCorrelationIDAsBytes) {
        this.jmsCorrelationIDAsBytes = jmsCorrelationIDAsBytes;
    }

    public int getJsmDeliveryMode() {
        return jsmDeliveryMode;
    }

    public void setJsmDeliveryMode(int jsmDeliveryMode) {
        this.jsmDeliveryMode = jsmDeliveryMode;
    }

    public String getJmsDestination() {
        return jmsDestination;
    }

    public void setJmsDestination(String jmsDestination) {
        this.jmsDestination = jmsDestination;
    }

    public long getJsmExpiration() {
        return jsmExpiration;
    }

    public void setJsmExpiration(long jsmExpiration) {
        this.jsmExpiration = jsmExpiration;
    }

    public int getJmsPriority() {
        return jmsPriority;
    }

    public void setJmsPriority(int jmsPriority) {
        this.jmsPriority = jmsPriority;
    }

    public boolean isJmsRedelivered() {
        return jmsRedelivered;
    }

    public void setJmsRedelivered(boolean jmsRedelivered) {
        this.jmsRedelivered = jmsRedelivered;
    }

    public String getJmsReplyTo() {
        return jmsReplyTo;
    }

    public void setJmsReplyTo(String jmsReplyTo) {
        this.jmsReplyTo = jmsReplyTo;
    }

    public long getJmsTimestamp() {
        return jmsTimestamp;
    }

    public void setJmsTimestamp(long jmsTimestamp) {
        this.jmsTimestamp = jmsTimestamp;
    }

    public String getJmsType() {
        return jmsType;
    }

    public void setJmsType(String jmsType) {
        this.jmsType = jmsType;
    }

}

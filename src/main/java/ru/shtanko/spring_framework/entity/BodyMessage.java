package ru.shtanko.spring_framework.entity;


import javax.persistence.*;

@Entity
@Table(name = "body")
public class BodyMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bodyMessage;

    @OneToOne(cascade = CascadeType.ALL)
    private HeadersMessage headersMessage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBodyMessage() {
        return bodyMessage;
    }

    public void setBodyMessage(String bodyMessage) {
        this.bodyMessage = bodyMessage;
    }

    public HeadersMessage getHeadersMessage() {
        return headersMessage;
    }

    public void setHeadersMessage(HeadersMessage headersMessage) {
        this.headersMessage = headersMessage;
    }
}

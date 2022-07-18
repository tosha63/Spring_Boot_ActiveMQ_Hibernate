package ru.shtanko.spring_framework.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.shtanko.spring_framework.entity.BodyMessage;
import ru.shtanko.spring_framework.entity.HeadersMessage;
import ru.shtanko.spring_framework.repository.BodyMessageRepository;

import javax.jms.JMSException;
import javax.jms.TextMessage;


@Component
public class JMSConsumer {

    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    private final BodyMessageRepository bodyMessageRepository;

    @Autowired
    public JMSConsumer(BodyMessageRepository bodyMessageRepository) {
        this.bodyMessageRepository = bodyMessageRepository;
    }

    @JmsListener(destination = "testqueue")
    public void receive(TextMessage message) {
        try {
            HeadersMessage headersMessage = new HeadersMessage();
            headersMessage.setJmsCorrelationIDAsBytes(message.getJMSCorrelationIDAsBytes());
            if (message.getJMSDestination() != null) {
                headersMessage.setJmsDestination(message.getJMSDestination().toString());
            }
            headersMessage.setJmsPriority(message.getJMSPriority());
            headersMessage.setJmsRedelivered(message.getJMSRedelivered());
            if (message.getJMSReplyTo() != null) {
                headersMessage.setJmsReplyTo(message.getJMSReplyTo().toString());
            }
            headersMessage.setJmsTimestamp(message.getJMSTimestamp());
            headersMessage.setJmsType(message.getJMSType());
            headersMessage.setJsmCorrelationID(message.getJMSCorrelationID());
            headersMessage.setJsmDeliveryMode(message.getJMSDeliveryMode());
            headersMessage.setJsmExpiration(message.getJMSExpiration());
            headersMessage.setJsmMessageID(message.getJMSMessageID());

            BodyMessage bodyMessage = new BodyMessage();
            bodyMessage.setBodyMessage(message.getText());
            bodyMessage.setHeadersMessage(headersMessage);
            bodyMessageRepository.save(bodyMessage);

        } catch (JMSException e) {
            e.printStackTrace();
        }
        logger.info("Консюмер извлек сообщение из очереди: " + message);
    }
}

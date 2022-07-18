package ru.shtanko.spring_framework.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class JMSProducer {

    private final static Logger logger = LoggerFactory.getLogger(JMSProducer.class);

    private final JmsTemplate jmsTemplate;

    private final Queue queue;

    @Autowired
    public JMSProducer(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    public void send() {
        while (true) {
            String randomString = UUID.randomUUID().toString();
            jmsTemplate.convertAndSend(queue, randomString);
            logger.info("Продюссер отправил сообщение в очередь " + randomString);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

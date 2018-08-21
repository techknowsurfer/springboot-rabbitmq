package com.techknowsurfer.springbootrabbitmqsample.queue;

import com.techknowsurfer.springbootrabbitmqsample.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

import static com.techknowsurfer.springbootrabbitmqsample.constants.QueueConstants.TIMER_EXCHANGE;
import static com.techknowsurfer.springbootrabbitmqsample.constants.QueueConstants.TIMER_ROUTING_KEY;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void produce(){
        Message message = Message.builder().id(UUID.randomUUID()).msg("Test Message").date(new Date()).build();
        rabbitTemplate.convertAndSend(TIMER_EXCHANGE,TIMER_ROUTING_KEY,message);

    }
}

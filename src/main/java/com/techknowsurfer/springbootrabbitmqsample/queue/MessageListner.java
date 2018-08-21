package com.techknowsurfer.springbootrabbitmqsample.queue;

import com.techknowsurfer.springbootrabbitmqsample.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.techknowsurfer.springbootrabbitmqsample.constants.QueueConstants.TIMER_QUEUE;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class MessageListner {

    @RabbitListener(queues = TIMER_QUEUE)
    public void consume(Message message){
        log.info("Payload {} ",message);
    }
}

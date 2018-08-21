package com.techknowsurfer.springbootrabbitmqsample.schedular;

import com.techknowsurfer.springbootrabbitmqsample.queue.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageSchedular {

    private final MessageProducer messageProducer;

    @Scheduled(fixedDelay = 100)
    public void schedule(){
        messageProducer.produce();

    }
}

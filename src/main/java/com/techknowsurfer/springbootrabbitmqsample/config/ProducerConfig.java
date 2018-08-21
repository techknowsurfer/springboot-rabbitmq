package com.techknowsurfer.springbootrabbitmqsample.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.techknowsurfer.springbootrabbitmqsample.constants.QueueConstants.TIMER_EXCHANGE;
import static com.techknowsurfer.springbootrabbitmqsample.constants.QueueConstants.TIMER_QUEUE;
import static com.techknowsurfer.springbootrabbitmqsample.constants.QueueConstants.TIMER_ROUTING_KEY;

@Configuration
public class ProducerConfig {

    //Creating an Direct Exchange
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(TIMER_EXCHANGE);
    }

     //Creating a Durable Queue
    @Bean
    public Queue queue(){
        return QueueBuilder.durable(TIMER_QUEUE).build();
    }

     //Creating a binding which Binds the Queue to an Exhange using a Routing Key
    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(TIMER_ROUTING_KEY);
    }


    //Creating a RabbitMq Template using the Connection Factory , which is creating by Springboot auto-configurations
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        final  RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return  rabbitTemplate;
    }

    //Setting up a Json Message converte which will convert an Pojo object to JSON message and using the same in RabbitMq Template
    private Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}

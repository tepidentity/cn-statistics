package org.example.data.source.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfiguration {

    private final MQProperties mqProperties;

    @Autowired
    public MQConfiguration(MQProperties mqProperties) {

        this.mqProperties = mqProperties;
    }

    @Bean
    Queue queue() {

        return new Queue(mqProperties.getQueue());
    }

    @Bean
    TopicExchange topicExchange() {

        return new TopicExchange(mqProperties.getExchange());
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {

        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(mqProperties.getRoutingKey());
    }

    @Bean
    ObjectMapper objectMapper() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper;
    }

    @Bean
    MessageConverter messageConverter(ObjectMapper objectMapper) {

        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    MQProperties amqpProperties() {

        return mqProperties;
    }


}

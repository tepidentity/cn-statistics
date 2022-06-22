package org.example.data.scrapper.configuration;

import org.springframework.amqp.core.*;
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
    MessageConverter messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {

        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);

        return template;
    }
}

package com.example.currencyservice.configuration;



import com.example.currencyservice.consumer.CurrencyConsumer;
import com.example.currencyservice.service.CurrencyService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${routing-key.currency}")
    private String routingKey;


    @Value("${queue.currency}")
    private String queueName;


    @Value("${xchange.name}")
    private String exchangeName;


    @Bean
    public CurrencyConsumer currencyConsumer() {
        return new CurrencyConsumer();
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding (DirectExchange directExchange, Queue currencyQueue){
        return BindingBuilder.bind(currencyQueue).to(directExchange).with(routingKey);
    }

    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }

    @Bean
    public CurrencyService getPriceService(){
        return new CurrencyService();
    }
}

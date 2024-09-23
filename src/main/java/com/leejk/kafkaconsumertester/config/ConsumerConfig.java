package com.leejk.kafkaconsumertester.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory getConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put("bootstrap.servers", bootstrapServers);
        config.put("key.deserializer", StringDeserializer.class);
        config.put("value.deserializer", JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory(config);
    }

}

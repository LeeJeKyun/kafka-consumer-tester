package com.leejk.kafkaconsumertester.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class TestListener {

    @KafkaListener(topics = "${kafka.topic}", groupId = "group02")
    public void messageListener(String data) {
        log.info("Consume Message : {}", data);
    }

}

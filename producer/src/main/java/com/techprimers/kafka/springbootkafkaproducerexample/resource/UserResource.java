package com.techprimers.kafka.springbootkafkaproducerexample.resource;

import com.techprimers.kafka.springbootkafkaproducerexample.model.Transaction;
import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example_json";

   /* @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }*/

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String createStore(@RequestBody Transaction transaction) throws Exception {

        kafkaTemplate.send(TOPIC, transaction);

        return "Published successfully";
    }
}

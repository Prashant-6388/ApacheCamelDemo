package com.example.demo.router;

import com.example.demo.processor.FileProcessor;
import org.apache.camel.Predicate;
import org.apache.camel.builder.PredicateBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilePickUpRouter extends RouteBuilder {

    @Autowired
    FileProcessor processor;

    @Override
    public void configure() throws Exception {

        from("file:D:/camel_test?delay=5000")
                .routeId("fileConsumer")
                .process(processor)
                .to("direct:end");
    }
}

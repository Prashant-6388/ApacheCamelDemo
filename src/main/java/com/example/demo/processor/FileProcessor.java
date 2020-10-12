package com.example.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;

@Component
public class FileProcessor implements Processor {

    Logger log = LoggerFactory.getLogger(FileProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Message msg = exchange.getMessage();
        File file = msg.getBody(File.class);
        log.info("Received File : "+ file.getName());
        String content = Files.readString(file.toPath());
        log.info("content="+content);
    }
}

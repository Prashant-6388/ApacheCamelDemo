package com.example.demo;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.nio.file.Files;

@CamelSpringBootTest
@SpringBootTest
class CamelTest {

    Logger log = LoggerFactory.getLogger(CamelTest.class);
    @Autowired
    private ProducerTemplate template;

    @EndpointInject("mock:direct:end")
    private MockEndpoint mock;

    @Test
    void testReceive() throws Exception {
        File file = new ClassPathResource("testFile.txt").getFile();
        String content = Files.readString(file.toPath());
        log.info("testing camel router");
        template.sendBody("file:D:/camel_test/", Files.readString(file.toPath()));
        mock.assertIsSatisfied();
    }
}

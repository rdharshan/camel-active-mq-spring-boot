package com.dash95.learning.CamelActiveMQSrpringBoot.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class jmsRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("{{inbound.endpoint}}")
                .transacted()
                .log(LoggingLevel.INFO, log, "Received  Message")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        log.info("Exchange: {}", exchange);
                    }
                })
                .loop()
                .simple("{{outbound.loop.count}}")
                .to("{{outbound.endpoint}}")
                .log(LoggingLevel.INFO, log, "Message sent. Iteration: ${exchangeProperty.CamelLoopIndex}")
                .end();
    }
}

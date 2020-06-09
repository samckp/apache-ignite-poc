package com.ignite.poc;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataRoute extends RouteBuilder {

    private ClientConfiguration cfg;
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "10800";
    private static final String CACHE_NAME = "thin-cache";

    @Override
    public void configure() throws Exception {

        cfg = new ClientConfiguration().setAddresses(HOST + ":" + PORT);
        IgniteClient igniteClient = Ignition.startClient(cfg);
        ClientCache< String, String > clientCache = igniteClient.getOrCreateCache(CACHE_NAME);

        int i=0;
        from("{{inroute}}")
                .routeId("dataPush")
                .setBody(simple("this is test msg ! ------{{message}}"))
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {

                        clientCache.put("Num" + (i+1), "{{message}}");
                    }
                })
                .log(LoggingLevel.INFO, "body >>> ${body}")
                .to("{{outroute}}")
                ;

        Thread.sleep(10000);
        System.out.println("num2--"+clientCache.get("Num2"));
    }
}

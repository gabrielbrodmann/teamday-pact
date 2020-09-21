package ch.youengineering.teamday.pact.consumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerPactTest {

    @Pact(provider = "EmployeeProvider", consumer = "GreeterConsumer")
    public RequestResponsePact employeePact(PactDslWithProvider builder) {
        return builder
                .uponReceiving("ExampleJavaConsumerPactTest test interaction")
                .path("/employee")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(new PactDslJsonBody())
                // TODO 1: PactDslJsonBody schreiben für firstName, lastName und email (https://docs.pact.io/implementation_guides/jvm/consumer/junit5)
                // TODO 2: Längenbeschränkung auf lastName (GreeterService.java) (https://docs.pact.io/implementation_guides/jvm/consumer)
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "employeePact")
    void test(MockServer mockServer) throws IOException {
        HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/employee").execute().returnResponse();
        // TODO 3: Schreibe Assertions (mindestens für den Status Code, besser auch für den Response Inhalt (ObjectMapper))
    }
}

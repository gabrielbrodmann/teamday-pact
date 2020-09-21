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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
                .body(
                        new PactDslJsonBody()
                                .stringType("firstName")
                                .stringMatcher("lastName", "\\w{1,50}")
                                .stringType("email")
                                .asBody())
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "employeePact")
    void test(MockServer mockServer) throws IOException {
        HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/employee").execute().returnResponse();
        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
    }
}

package ch.youengineering.teamday.pact.consumer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeClient {

    private final RestTemplateBuilder restTemplateBuilder;

    public EmployeeClient(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GreetedEmployee getEmployeeToGreet() {
        return restTemplateBuilder.build().getForEntity("http://localhost:8081/employee", GreetedEmployee.class).getBody();
    }
}

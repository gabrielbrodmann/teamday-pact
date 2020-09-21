package ch.youengineering.teamday.pact.consumer;

import ch.youengineering.teamday.pact.consumer.Greeted.GreetedBuilder;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class GreeterService {

    private final EmployeeClient employeeClient;

    public GreeterService(final EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public Greeted greetEmployee() {
        GreetedEmployee employeeToGreet = employeeClient.getEmployeeToGreet();

        if (nonNull(employeeToGreet.getLastName()) && employeeToGreet.getLastName().length() > 50) {
            throw new RuntimeException("Last name longer than 50 letters. Help Me!");
        }

        return GreetedBuilder.aGreeted()
                .greeted("Hi " + employeeToGreet.getFirstName() + " " + employeeToGreet.getLastName())
                .build();
    }
}

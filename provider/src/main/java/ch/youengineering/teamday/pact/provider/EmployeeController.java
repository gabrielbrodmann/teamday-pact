package ch.youengineering.teamday.pact.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "customer")
    public Employee getCustomer(){
        return Employee.EmployeeBuilder.anEmployee()
                .city("Basel")
                .email("gabriel.brodmann@youengineering.ch")
                .firstName("Gabriel")
                .lastName("Brodmann")
                .street("Aeschenplatz 4")
                .zip("4051")
                .build();
    }
}

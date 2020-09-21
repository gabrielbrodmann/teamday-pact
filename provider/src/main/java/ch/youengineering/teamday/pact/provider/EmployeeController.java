package ch.youengineering.teamday.pact.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "employee")
    public Employee getEmployee(){
        return Employee.EmployeeBuilder.anEmployee()
                .city("Basel")
                .email("gabriel.brodmann@youengineering.ch")
                .firstName("Gabriel")
                // TODO 4: Passe den lastName so an, dass der Client Code gebrochen wird -> Pact Test to the rescue :-)
                .lastName("Brodmann")
                .street("Aeschenplatz 4")
                .zip("4051")
                .build();
    }
}

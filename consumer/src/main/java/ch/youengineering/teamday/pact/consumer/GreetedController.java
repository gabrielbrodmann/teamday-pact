package ch.youengineering.teamday.pact.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetedController {

    private final GreeterService greeterService;

    public GreetedController(final GreeterService greeterService){
        this.greeterService = greeterService;
    }

    @GetMapping("greet")
    public Greeted greetEmployee(){
       return greeterService.greetEmployee();
    }
}

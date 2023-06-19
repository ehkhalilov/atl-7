package az.example.atl7.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class HealthController {

    @GetMapping
    public String checkHealth() {
        return "UP";
    }
}

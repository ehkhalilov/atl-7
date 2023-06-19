package az.example.atl7.config;

import az.example.atl7.service.CustomerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerConfig {

    private final CustomerService customerService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public SchedulerConfig(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Scheduled(cron = "* 24 11 3 6 MON-SAT")
    public void run() {
//        customerService.saveCustomer();
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}

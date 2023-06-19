package az.example.atl7.controller.rest;

import az.example.atl7.dao.PassportEntity;
import az.example.atl7.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passports")
@RequiredArgsConstructor
public class PassportController {

    private final PassportService passportService;

    @GetMapping("/{id}")
    public PassportEntity getPassport(@PathVariable Integer id) {
        return passportService.getPassport(id);
    }
}

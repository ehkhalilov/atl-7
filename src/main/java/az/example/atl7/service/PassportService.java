package az.example.atl7.service;

import az.example.atl7.dao.PassportEntity;
import az.example.atl7.dao.PassportRepository;
import az.example.atl7.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassportService {

    private final PassportRepository passportRepository;

    public PassportEntity getPassport(Integer id) {
        return passportRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("passport not found")
        );
    }
}

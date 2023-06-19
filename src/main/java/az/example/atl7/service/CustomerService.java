package az.example.atl7.service;

import az.example.atl7.dao.CustomerEntity;
import az.example.atl7.dao.CustomerRepository;
import az.example.atl7.mapper.CustomerMapper;
import az.example.atl7.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(CustomerDto customer) {
        System.out.println(customer);
        customerRepository.save(CustomerMapper.INSTANCE.mapDtoToEntity(customer));
    }

    public CustomerDto getCustomer(Long id) {
        var customerEntity = customerRepository.findById(id).orElse(new CustomerEntity());
        var customerDto = CustomerMapper.INSTANCE.mapEntityToDto(customerEntity);
        return customerDto;
    }

    public List<CustomerDto> getCustomers() throws InterruptedException {
        Thread.sleep(6000);

        var customerEntityList = customerRepository.findAll();

        return customerEntityList.stream()
                .map(CustomerMapper.INSTANCE::mapEntityToDto)
                .toList();
    }
}

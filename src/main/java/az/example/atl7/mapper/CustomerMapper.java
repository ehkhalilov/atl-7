package az.example.atl7.mapper;

import az.example.atl7.dao.CustomerEntity;
import az.example.atl7.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;


@Mapper(imports = {LocalDate.class})
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "serialNumber", source = "passportEntity.serialNumber")
    @Mapping(target = "fin", constant = "sdaskjh")
//    @Mapping(target = "birthDate", qualifiedByName = "check")
    CustomerDto mapEntityToDto(CustomerEntity customer);

    CustomerEntity mapDtoToEntity(CustomerDto customerDto);

//    @Named("check")
//    default LocalDate getToday1(CustomerEntity  customer) {
//        return customer.getBirthDate().minusYears(10);
//    }
}

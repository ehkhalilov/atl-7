package az.example.atl7.mapper;

import az.example.atl7.dao.StudentEntity;
import az.example.atl7.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto mapEntityToDto(StudentEntity student);

    StudentEntity mapDtoToEntity(StudentDto studentDto);
}

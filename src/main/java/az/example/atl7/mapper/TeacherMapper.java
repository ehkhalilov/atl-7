package az.example.atl7.mapper;

import az.example.atl7.dao.TeacherEntity;
import az.example.atl7.model.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "teacherEntityList.name", ignore = true)
    List<TeacherDto> mapEntityListToDtoList(List<TeacherEntity> teacherEntityList);

    @Mapping(target = "name", ignore = true)
    TeacherDto mapEntityToDto(TeacherEntity teacherEntity);
}

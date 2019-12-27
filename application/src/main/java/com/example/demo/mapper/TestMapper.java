package com.example.demo.mapper;

import com.example.demo.entity.TestEntity;
import com.example.demo.request.TestSaveDTO;
import com.example.demo.response.TestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @author chenxiang
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestMapper {

    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    TestEntity map(TestSaveDTO bean);

    TestDTO map(TestEntity bean);

    List<TestDTO> map(List<TestEntity> bean);

}
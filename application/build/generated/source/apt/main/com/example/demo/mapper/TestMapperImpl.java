package com.example.demo.mapper;

import com.example.demo.entity.TestEntity;
import com.example.demo.request.TestSaveDTO;
import com.example.demo.response.TestDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-27T17:58:11+0800",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class TestMapperImpl implements TestMapper {

    @Override
    public TestEntity map(TestSaveDTO bean) {
        if ( bean == null ) {
            return null;
        }

        TestEntity testEntity = new TestEntity();

        testEntity.setName( bean.getName() );
        testEntity.setAge( bean.getAge() );

        return testEntity;
    }

    @Override
    public TestDTO map(TestEntity bean) {
        if ( bean == null ) {
            return null;
        }

        TestDTO testDTO = new TestDTO();

        testDTO.setId( bean.getId() );
        testDTO.setName( bean.getName() );
        testDTO.setAge( bean.getAge() );

        return testDTO;
    }

    @Override
    public List<TestDTO> map(List<TestEntity> bean) {
        if ( bean == null ) {
            return null;
        }

        List<TestDTO> list = new ArrayList<TestDTO>( bean.size() );
        for ( TestEntity testEntity : bean ) {
            list.add( map( testEntity ) );
        }

        return list;
    }
}

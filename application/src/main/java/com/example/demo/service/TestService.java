package com.example.demo.service;

import com.example.demo.base.BasePageDTO;
import com.example.demo.dao.TestRepo;
import com.example.demo.entity.TestEntity;
import com.example.demo.jooq.tables.TestTable;
import com.example.demo.mapper.TestMapper;
import com.example.demo.request.TestSaveDTO;
import com.example.demo.response.TestDTO;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenxiang
 */
@Service
@Slf4j
public class TestService {

    @Autowired
    DSLContext dsl;

    TestTable t = TestTable.PF_TEST_T.as("t");

    @Autowired
    private TestRepo testRepo;

    public TestEntity findTestEntity(String id) {
        log.info("id={}", id);
        return testRepo.getOne(id);
    }

    public TestEntity saveTestEntity(TestSaveDTO testSaveDTO) {
        log.info("testSaveDTO={}", testSaveDTO);
        TestEntity testEntity = TestMapper.INSTANCE.map(testSaveDTO);
        testRepo.save(testEntity);
        return testEntity;
    }

    public BasePageDTO<TestDTO> findTestByPage(Pageable pageable) {
        Page<TestEntity> testEntityPage = testRepo.findAll(pageable);
        List<TestDTO> testDTOList = TestMapper.INSTANCE.map(testEntityPage.getContent());
        return new BasePageDTO<>(new PageImpl<>(testDTOList, pageable, testEntityPage.getTotalElements()));
    }

    public BasePageDTO<TestDTO> findTestByPageAndNative(String name, Pageable pageable) {
        Page<TestEntity> testEntityPage = testRepo.findAllByNativeSQL(name, pageable);
        List<TestDTO> testDTOList = TestMapper.INSTANCE.map(testEntityPage.getContent());
        return new BasePageDTO<>(new PageImpl<>(testDTOList, pageable, testEntityPage.getTotalElements()));
    }

    public List<TestDTO> findByJooq() {
        List<TestDTO> result = dsl.select().from(t).where().fetch().into(TestDTO.class);
        return result;
    }
}

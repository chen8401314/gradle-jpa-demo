package com.example.demo.service;

/*
import com.example.demo.dao.TestRepo;
import com.example.demo.entity.TestEntity;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(JMockit.class)
public class TestServiceTest {

    @Injectable
    private TestRepo testRepo;

    TestEntity entity = new TestEntity();

    @Before
    public void setUp() throws Exception {
        entity.setAge(1);
        entity.setName("123");
        //entity.setBirthday(LocalDate.now());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findTestEntity() {
        new Expectations() {
            {
                testRepo.getOne(anyString);
                result = entity;
                times = 1;
            }
        };
        TestEntity testEntity =  testRepo.getOne("123");
        assertEquals("123",testEntity.getName());
    }

    @Test
    public void saveTestEntity() {
        new Expectations() {
            {
                testRepo.save(entity);
                times = 1;
            }
        };
        testRepo.save(entity);
        assertEquals("123",entity.getName());
    }

    @Test
    public void findTestByPage() {

    }

    @Test
    public void findTestByPageAndNative() {
    }
}*/

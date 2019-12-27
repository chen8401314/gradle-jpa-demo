package com.example.demo.dao;


import com.example.demo.entity.TestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author chenxiang
 */
public interface TestRepo extends JpaRepository<TestEntity, String> {

    @Query(value = "select * from PF_TEST_T where name like concat('%',:name,'%')",
            countQuery = "select count(*) from PF_TEST_T where name like concat('%',:name,'%')",
            nativeQuery = true)
    Page<TestEntity> findAllByNativeSQL(@Param("name")String name, Pageable pageable);
}

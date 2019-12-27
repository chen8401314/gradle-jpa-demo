package com.example.demo.controller;

import com.example.demo.base.BasePageDTO;
import com.example.demo.base.Response;
import com.example.demo.base.SortDTO;
import com.example.demo.entity.TestEntity;
import com.example.demo.mapper.TestMapper;
import com.example.demo.request.TestSaveDTO;
import com.example.demo.response.TestDTO;
import com.example.demo.service.TestService;
import com.example.demo.util.PageTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author chenxiang
 */
@Slf4j
@RestController("TestController")
@RequestMapping(value = "/test", produces = {APPLICATION_JSON_UTF8_VALUE})
@Api(value = "TestController", description = "测试相关接口", produces = MediaType.ALL_VALUE)
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "获取test")
    @PostMapping(value = "/getById/{id}")
    public Response<TestDTO> getById(@PathVariable String id) {
        TestEntity testEntity = testService.findTestEntity(id);
        TestDTO testDTO = TestMapper.INSTANCE.map(testEntity);
        return Response.instance.success(testDTO);
    }

    @ApiOperation(value = "保存test")
    @PostMapping(value = "/save")
    public Response save(@RequestBody TestSaveDTO testSaveDTO) {
        TestEntity testEntity = testService.saveTestEntity(testSaveDTO);
        return Response.instance.success(testEntity);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/testPageable")
    public BasePageDTO<TestDTO> testPageable(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("sortType") String sortType,
            @RequestParam("sortField") String sortField
    ) {
        //获取pageable
        Pageable pageable = PageTools.basicPage(page, size, new SortDTO(sortType, sortField));
        return testService.findTestByPage(pageable);

    }

    @ApiOperation(value = "nativeSQL分页查询")
    @GetMapping(value = "/testPageableBySQL")
    public BasePageDTO<TestDTO> testPageableBySQL(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String name
    ) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (size == null || size < 1) {
            size = 10;
        }
        if (name == null) {
            name = "";
        }
        //获取pageable
        Pageable pageable = PageTools.basicPage(page, size, new SortDTO("asc", "create_time"));
        return testService.findTestByPageAndNative(name, pageable);

    }
}

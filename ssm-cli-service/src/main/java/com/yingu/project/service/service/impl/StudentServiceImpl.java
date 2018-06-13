package com.yingu.project.service.service.impl;


import com.yingu.project.persistence.mongo.entity.QueryResult;
import com.yingu.project.persistence.mongo.repository.QueryResultRepository;
import com.yingu.project.persistence.mysql.entity.StudentEntity;
import com.yingu.project.persistence.mysql.mapper.StudentMapper;
import com.yingu.project.persistence.mysql.repository.StudentRepository;
import com.yingu.project.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by MMM on 2018/01/25.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    QueryResultRepository queryResultRepository;
    @Override
    public StudentEntity add(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }
    @Override
    public Integer insert(StudentEntity studentEntity){
        return  studentMapper.insert(studentEntity);
    }

    /**
     * mongo分页查询
     */
    public void findByInterfaceId(){
        String interfaceId ="1";
        Sort.Order order =new Sort.Order(Sort.Direction.ASC,"create_time");
        int page=0;
        int size=10;
        Sort sort=new Sort(order);
        PageRequest pageable = new PageRequest(page,size,sort);

        List<QueryResult> results= queryResultRepository.findByInterfaceId(interfaceId,pageable);

    }
}

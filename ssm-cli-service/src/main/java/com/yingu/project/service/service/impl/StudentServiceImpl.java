package com.yingu.project.service.service.impl;


import com.yingu.project.persistence.mysql.entity.StudentEntity;
import com.yingu.project.persistence.mysql.mapper.StudentMapper;
import com.yingu.project.persistence.mysql.repository.StudentRepository;
import com.yingu.project.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MMM on 2018/01/25.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public StudentEntity add(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }
    @Override
    public Integer insert(StudentEntity studentEntity){
        return  studentMapper.insert(studentEntity);
    }
}

package com.yingu.project.service.service;

import com.yingu.project.persistence.neo4j.entity.ContactNode;
import com.yingu.project.persistence.neo4j.entity.PersonNode;
import com.yingu.project.persistence.neo4j.entity.PersonToContactRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MMM on 2018/03/15.
 */
@Service
public interface Neo4jService {
    List<PersonNode> getPersonNodeList();
    List<PersonNode> addPersonNodeList(String id,String name, String phone,String company);
    List<ContactNode> getContactNodeList();
    List<ContactNode> addContactNodeList(String id,String name, String phone,String company, String relation);
    List<PersonToContactRelation> findPersonToContactRelationByPersonName(String personName);
    List<PersonToContactRelation> addPersonToContactRelation(String personName,String contactName);
}

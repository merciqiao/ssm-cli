package com.yingu.project.service.service.impl;

import com.yingu.project.persistence.neo4j.entity.ContactNode;
import com.yingu.project.persistence.neo4j.entity.PersonNode;
import com.yingu.project.persistence.neo4j.entity.PersonToContactRelation;
import com.yingu.project.persistence.neo4j.repository.ContactNodeRepository;
import com.yingu.project.persistence.neo4j.repository.PersonNodeRepository;
import com.yingu.project.persistence.neo4j.repository.PersonToContactRelationRepository;
import com.yingu.project.service.service.Neo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MMM on 2018/03/15.
 */
@Service
public class Neo4jServiceImpl implements Neo4jService{
    @Autowired
    private PersonNodeRepository personNodeRepository;
    @Autowired
    private ContactNodeRepository contactNodeRepository;
    @Autowired
    private PersonToContactRelationRepository personToContactRelationRepository;

    @Override
    public List<PersonNode> getPersonNodeList(){
        List<PersonNode> personNodeList= personNodeRepository.getPersonNodeList();
        return personNodeList;
    }
    @Override
    public List<PersonNode> addPersonNodeList(String id,String name, String phone,String company){
        List<PersonNode> personNodeList=personNodeRepository.addPersonNodeList(id,name,phone,company);
        return personNodeList;
    }
    @Override
    public List<ContactNode> getContactNodeList(){
        List<ContactNode> contactNodeList=contactNodeRepository.getContactNodeList();
        return contactNodeList;
    }
    @Override
    public List<ContactNode> addContactNodeList(String id,String name, String phone,String company, String relation){
        List<ContactNode> contactNodeList=contactNodeRepository.addContactNodeList(id,name,phone,company,relation);
        return  contactNodeList;
    }
    @Override
    public List<PersonToContactRelation> findPersonToContactRelationByPersonName(String personName){
        List<PersonToContactRelation> personToContactRelationList=personToContactRelationRepository.findPersonToContactRelationByPersonName(personName);
        return personToContactRelationList;
    }
    @Override
    public List<PersonToContactRelation> addPersonToContactRelation(String personName,String contactName){
        List<PersonToContactRelation> personToContactRelationList=personToContactRelationRepository.addPersonToContactRelation(personName,contactName);
        return personToContactRelationList;
    }

}

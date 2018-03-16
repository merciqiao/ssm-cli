package com.yingu.project.rest.controller;

import com.yingu.project.persistence.neo4j.entity.PersonToContactRelation;
import com.yingu.project.persistence.neo4j.entity.UserNode;
import com.yingu.project.persistence.neo4j.repository.UserNodeRepository;
import com.yingu.project.service.service.Neo4jService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MMM on 2018/03/15.
 */
@RestController
@RequestMapping(value="/ssm-cli-api")
@Slf4j
public class Neo4jController {
    @Autowired
    Neo4jService neo4jService;
    @Autowired
    UserNodeRepository userNodeRepository;
    @ApiOperation(value="根据姓名查关系",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/findPersonToContactRelationByPersonName",method = RequestMethod.POST)
    public List<PersonToContactRelation> findPersonToContactRelationByPersonName(@RequestBody String personName){
        //neo4jService.addPersonNodeList("10","哈哈","111","北京科技公司");

        UserNode userNode=new UserNode();
        userNode.name="张三";
        //userNode.id=100L;
        userNode.phone="301";

        UserNode userNode2=new UserNode();
        userNode2.name="李四";
        userNode2.phone="302";
        List<UserNode> userNodeList=new ArrayList<>();
        userNodeList.add(userNode2);
        UserNode userNode3=new UserNode();
        userNode3.name="王五";
        userNode3.phone="303";
        List<UserNode> userNodeList2=new ArrayList<>();
        userNodeList2.add(userNode3);

        userNode.setUserNodeListSamePhone(userNodeList);
        userNode.setUserNodeListSameCompany(userNodeList2);
        UserNode userNodeResult= userNodeRepository.save(userNode);

        UserNode userNode1= userNodeRepository.findFirstByName("李四");
        userNode1.setPhone("3022");
        List<UserNode> userNodeList3=new ArrayList<>();
        UserNode userNode4=new UserNode();
        userNode4.name="赵六";
        userNode4.phone="501";
        userNodeList3.add(userNode4);
        userNode1.setUserNodeListSamePhone(userNodeList3);
        userNodeRepository.save(userNode1);

//        List<PersonToContactRelation> personToContactRelationList= neo4jService.findPersonToContactRelationByPersonName(personName);
//        return  personToContactRelationList;
        return null;
    }
}

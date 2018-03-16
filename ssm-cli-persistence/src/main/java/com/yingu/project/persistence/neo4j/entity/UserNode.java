package com.yingu.project.persistence.neo4j.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.List;

/**
 * Created by MMM on 2018/03/15.
 */
@Getter
@Setter
@NodeEntity(label = "User")
public class UserNode{
    //@GraphId
    public Long id;
    public String name;
    public String phone;
    @Relationship(type="samephone", direction=Relationship.OUTGOING)
    private List<UserNode> userNodeListSamePhone;
    @Relationship(type="samecompany", direction=Relationship.DIRECTION)
    private List<UserNode> userNodeListSameCompany;
}

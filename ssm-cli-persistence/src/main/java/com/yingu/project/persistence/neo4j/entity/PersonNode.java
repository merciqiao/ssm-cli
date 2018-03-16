package com.yingu.project.persistence.neo4j.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by MMM on 2018/03/15.
 */
@Getter
@Setter
@NodeEntity(label = "Person")
public class PersonNode {
    @GraphId
    public Integer id;
    public String name;
    public String phone;
    public String company;
}


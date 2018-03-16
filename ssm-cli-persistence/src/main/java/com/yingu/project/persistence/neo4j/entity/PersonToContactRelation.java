package com.yingu.project.persistence.neo4j.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by MMM on 2018/03/15.
 */
@RelationshipEntity(type = "hasContact")
public class PersonToContactRelation {
    @GraphId
    private Long id;

    @StartNode
    private PersonNode startNode;

    @EndNode
    private ContactNode endNode;
}

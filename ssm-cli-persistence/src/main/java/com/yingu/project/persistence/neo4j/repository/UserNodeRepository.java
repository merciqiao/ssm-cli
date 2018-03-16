package com.yingu.project.persistence.neo4j.repository;

import com.yingu.project.persistence.neo4j.entity.PersonNode;
import com.yingu.project.persistence.neo4j.entity.UserNode;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MMM on 2018/03/15.
 */
@Repository
public interface UserNodeRepository extends GraphRepository<UserNode> {

    @Override
    UserNode findOne(Long aLong);
    UserNode findFirstByName(String name);
}

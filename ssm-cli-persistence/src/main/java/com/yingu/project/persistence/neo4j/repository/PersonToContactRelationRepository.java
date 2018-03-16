package com.yingu.project.persistence.neo4j.repository;

import com.yingu.project.persistence.neo4j.entity.PersonToContactRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MMM on 2018/03/15.
 */
@Repository
public interface PersonToContactRelationRepository extends GraphRepository<PersonToContactRelation>{
    /**
     * 根据姓名找关系
     * @param personName
     * @return
     */
    @Query("MATCH result=(p:Person)<-[r:hasContact]->(c:Contact) where p.name={personName} RETURN result")
    List<PersonToContactRelation> findPersonToContactRelationByPersonName(@Param("personName") String personName);

    /**
     * 添加关系
     * @param personName 平台用户姓名
     * @param contactName 联系人姓名
     * @return
     */
    @Query("MATCH (p:Person),(c:Contact) where p.name={personName} and c.name={contactName} MERGE result=(p)-[r:hasContact]->(c) RETURN result")
    List<PersonToContactRelation> addPersonToContactRelation(@Param("personName") String personName, @Param("contactName") String contactName);
}

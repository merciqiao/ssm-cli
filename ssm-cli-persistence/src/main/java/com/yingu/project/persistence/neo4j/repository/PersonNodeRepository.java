package com.yingu.project.persistence.neo4j.repository;

import com.yingu.project.persistence.neo4j.entity.PersonNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MMM on 2018/03/15.
 */
@Repository
public interface PersonNodeRepository extends GraphRepository<PersonNode>{
    /**
     * 查询所有节点
     * @return
     */
    @Query("MATCH (p:Person) RETURN p ")
    List<PersonNode> getPersonNodeList();

    /**
     * 添加节点
     * @param id
     * @param name
     * @param phone
     * @param company
     * @return
     */
    @Query("MERGE (p:Person{ id:{id},name:{name},phone:{phone},company:{company} }) RETURN p")
    List<PersonNode> addPersonNodeList(@Param("id") String id, @Param("name") String name,
                                       @Param("phone") String phone, @Param("company") String company);
}

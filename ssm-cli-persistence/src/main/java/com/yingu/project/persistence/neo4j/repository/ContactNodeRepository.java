package com.yingu.project.persistence.neo4j.repository;

import com.yingu.project.persistence.neo4j.entity.ContactNode;
import com.yingu.project.persistence.neo4j.entity.PersonNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MMM on 2018/03/15.
 */
@Repository
public interface ContactNodeRepository extends GraphRepository<ContactNode> {
    /**
     * 查询所有节点
     * @return
     */
    @Query("MATCH (c:Contact) RETURN c ")
    List<ContactNode> getContactNodeList();

    /**
     * 添加节点
     * @param id
     * @param name
     * @param phone
     * @param company
     * @return
     */
    @Query("MERGE (c:Contact{ id:{id},name:{name},phone:{phone},company:{company},relation:{relation} }) RETURN c")
    List<ContactNode> addContactNodeList(@Param("id") String id, @Param("name") String name,
                                        @Param("phone") String phone, @Param("company") String company,
                                        @Param("relation") String relation);

}

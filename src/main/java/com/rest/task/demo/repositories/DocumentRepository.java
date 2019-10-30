package com.rest.task.demo.repositories;

import com.rest.task.demo.entities.core.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Milen on 28.10.2019 г..
 */

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>, JpaSpecificationExecutor<Document> {

    @Query(value = "SELECT * FROM documents d WHERE d.document_id IN :ids", nativeQuery = true)
    List<Document> queryIn(@Param("ids") List<Long> ids);

}
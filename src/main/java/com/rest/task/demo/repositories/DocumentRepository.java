package com.rest.task.demo.repositories;

import com.rest.task.demo.entities.core.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Milen on 28.10.2019 г..
 */

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query(value = "SELECT * FROM documents d WHERE d.document_id IN :iids", nativeQuery = true)
    List<Document> findAllActiveUsersNative(@Param("iids")List<Long> ids);
}
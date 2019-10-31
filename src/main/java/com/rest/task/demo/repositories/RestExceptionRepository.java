package com.rest.task.demo.repositories;

import com.rest.task.demo.entities.applicationRelated.RestExceptionDBRelatedEntity;
import com.rest.task.demo.entities.core.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Created by Milen on 31.10.2019 г..
 */

@Repository
public interface RestExceptionRepository extends JpaRepository<RestExceptionDBRelatedEntity, Long>, JpaSpecificationExecutor<Document> {

}
package com.rest.task.demo.services;

import com.rest.task.demo.entities.core.Document;
import com.rest.task.demo.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Milen on 29.10.2019 г..
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private DocumentRepository documentsRepository;

    @Autowired
    public DeliveryServiceImpl(DocumentRepository documentRepository) {
        this.documentsRepository = documentRepository;
    }


    @Override
    public List<Document> getAll() {
        return documentsRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Document> getDeliveriesByIds(Map<String, Object> payload) {
        if (payload.containsKey("DeliveriesIdList")) {
            List<Long> deliveriesIdList = (List<Long>) payload.get("DeliveriesIdList");
            return documentsRepository.queryIn(deliveriesIdList);
        }
        return new ArrayList<>();
    }
}

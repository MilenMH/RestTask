package com.rest.task.demo.services;

import com.rest.task.demo.entities.core.Document;
import com.rest.task.demo.repositories.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Milen on 29.10.2019 г..
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private DocumentRepository documentsRepository;
    private ModelMapper modelMapper;

    @Autowired
    public DeliveryServiceImpl(DocumentRepository documentRepository, ModelMapper modelMapper) {
        this.documentsRepository = documentRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public Document postDelivery(Document payload) {
        return documentsRepository.saveAndFlush(payload);
    }

    @Override
    public Document putDelivery(Document payload) {
        Optional<Document> byId = documentsRepository.findById(payload.getDocument_id());
        if (byId.isPresent()){
            Document document = byId.get();
            modelMapper.map(payload, document);
            return documentsRepository.saveAndFlush(document);
        }
        return payload;
    }

    @Override
    public String deleteDeliveries(List<Document> payload)  {
        documentsRepository.deleteAll(payload);
        documentsRepository.flush();
        return "Deleted successfully";
    }
}

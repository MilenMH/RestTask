package com.rest.task.demo.services;

import com.rest.task.demo.entities.core.Document;
import com.rest.task.demo.repositories.DocumentRepository;
import com.rest.task.demo.repositories.ItemRepository;
import com.rest.task.demo.repositories.PayNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Milen on 29.10.2019 г..
 */
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    private DocumentRepository documentsRepository;
    private PayNoteRepository payNoteRepository;
    private ItemRepository itemsRepository;

    @Autowired
    public DeliveryServiceImpl(DocumentRepository documentRepository, PayNoteRepository payNoteRepository, ItemRepository itemRepository){
        this.documentsRepository  = documentRepository;
        this.payNoteRepository  = payNoteRepository;
        this.itemsRepository  = itemRepository;
    }


    @Override
    public List<Document> getAll() {
        return documentsRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Document> getDeliveriesByParamAndIds(Map<String, Object> payload)  {
        if (payload.containsKey("DeliveriesIdList")){
            try {
                List<Long> deliveriesIdList = (List<Long>) payload.get("DeliveriesIdList");
                documentsRepository.findAllActiveUsersNative(deliveriesIdList);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return new ArrayList<>();
    }
}

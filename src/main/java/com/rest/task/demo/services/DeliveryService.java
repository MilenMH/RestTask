package com.rest.task.demo.services;

import com.rest.task.demo.entities.core.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by Milen on 29.10.2019 г..
 */
public interface DeliveryService {

    List<Document> getAll();

    List<Document> getDeliveriesByIds(Map<String, Object> payload);

    Document postDelivery(Document payload);

    Document putDelivery(Document payload);

    String deleteDeliveries(List<Document> payload);
 }

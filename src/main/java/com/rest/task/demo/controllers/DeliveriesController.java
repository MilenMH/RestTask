package com.rest.task.demo.controllers;

import com.rest.task.demo.entities.core.Document;
import com.rest.task.demo.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Milen on 28.10.2019 г..
 */
@RestController
public class DeliveriesController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveriesController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/deliveries",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getDeliveries() {

        return Collections.singletonMap("Invoices", this.deliveryService.getAll());

    }

    @RequestMapping(method = RequestMethod.POST, path = "/deliveries")
    public Map<String, List<Document>> customerInformation(@RequestBody Map<String, Object> payload) {
        List<Document> deliveriesByParamAndIds = this.deliveryService.getDeliveriesByParamAndIds(payload);

        return  Collections.singletonMap("Invoices",deliveriesByParamAndIds);
    }
}

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


    @RequestMapping(method = RequestMethod.POST, path = "/deliveries")
    public Map<String, List<Document>> customerInformation(@RequestBody Map<String, Object> payload) {
        List<Document> deliveriesByParamAndIds = this.deliveryService.getDeliveriesByIds(payload);

        return  Collections.singletonMap("Invoices",deliveriesByParamAndIds);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/rest/deliveries",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getDeliveries() {

        return Collections.singletonMap("Invoices", this.deliveryService.getAll());

    }

    @RequestMapping(method = RequestMethod.POST, value = "/rest/deliveries",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Map postDeliveries(@RequestBody Document payload) {

        return Collections.singletonMap("Invoice", this.deliveryService.postDelivery(payload));

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rest/deliveries",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Map putDeliveries(@RequestBody Document payload) {

        return Collections.singletonMap("Invoice", this.deliveryService.putDelivery(payload));

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rest/deliveries",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Map deleteDeliveries(@RequestBody List<Document> payload) {

        return Collections.singletonMap("Invoices", this.deliveryService.deleteDeliveries(payload));

    }
}

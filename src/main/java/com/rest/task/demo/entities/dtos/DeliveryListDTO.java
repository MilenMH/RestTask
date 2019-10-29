package com.rest.task.demo.entities.dtos;

import java.util.List;

/**
 * Created by Milen on 29.10.2019 г..
 */
public class DeliveryListDTO {

    private String listTitle;

    private List<Long> ids;

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}

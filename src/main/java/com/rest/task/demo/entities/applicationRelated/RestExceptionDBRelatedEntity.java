package com.rest.task.demo.entities.applicationRelated;

import javax.persistence.*;

import static com.rest.task.demo.configuration.Constants.POSTGRE_TEXT_DEFAULT_LENGTH;

/**
 * Created by Milen on 31.10.2019 г..
 */
@Entity
@Table(name = "rest_Exception")
public class RestExceptionDBRelatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = POSTGRE_TEXT_DEFAULT_LENGTH, columnDefinition = "text", name = "exceptionName")
    private String exceptionName;

    @Column(length = POSTGRE_TEXT_DEFAULT_LENGTH, columnDefinition = "text", name = "exceptionMessage")
    private String exceptionMessage;

    @Column(length = POSTGRE_TEXT_DEFAULT_LENGTH, columnDefinition = "text", name = "request")
    private String request;

    public long getId() {
        return id;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}

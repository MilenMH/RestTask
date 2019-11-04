package com.rest.task.demo.entities.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Milen on 28.10.2019 г..
 */
@Entity
@Table(name = "items")
@EntityListeners(AuditingEntityListener.class)
public class Item extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long item_id;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private Set<Document> documents;

    @Column(name = "zaDelivID")
    private long zaDelivID;

    @Column(name = "line")
    private int line;

    @Column(name = "artID")
    private long artID;

    @Column(name = "expDate", nullable = false)
    private Date expDate;

    @Column(name = "serNo", nullable = false)
    private String serNo;

    @Column(name = "qty", nullable = false)
    private float qty;

    @Column(name = "priceVal", nullable = false)
    private double priceVal;

    @Column(name = "totalVal", nullable = false)
    private double totalVal;

    public long getItem_id() {
        return item_id;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public long getZaDelivID() {
        return zaDelivID;
    }

    public void setZaDelivID(long zaDelivID) {
        this.zaDelivID = zaDelivID;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public long getArtID() {
        return artID;
    }

    public void setArtID(long artID) {
        this.artID = artID;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getSerNo() {
        return serNo;
    }

    public void setSerNo(String serNo) {
        this.serNo = serNo;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public double getPriceVal() {
        return priceVal;
    }

    public void setPriceVal(double priceVal) {
        this.priceVal = priceVal;
    }

    public double getTotalVal() {
        return totalVal;
    }

    public void setTotalVal(double totalVal) {
        this.totalVal = totalVal;
    }
}

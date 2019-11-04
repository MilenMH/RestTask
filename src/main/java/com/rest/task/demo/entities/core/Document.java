package com.rest.task.demo.entities.core;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Milen on 28.10.2019 г..
 */
@Entity
@Table(name = "documents")
@EntityListeners(AuditingEntityListener.class)
public class Document extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long document_id;

    @Column(name = "delivererID", nullable = false)
    private int delivererID = 9983;

    @Column(name = "proformP")
    private boolean proformP;

    @Column(name = "totalVal", nullable = false)
    private BigInteger totalVal;

    @Column(name = "note", length = 50, nullable = false)
    private String note;

    @Column(name = "datePadej")
    private Date datePadej;

    @ManyToOne
    @JoinColumn(name = "payNote")
    private PayNote payNote;

    @Column(name = "payTypeName", length = 100)
    private String payTypeName;

    @Column(name = "version")
    private int version = 1;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "document_item",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items;

    @Column(name = "parentDocNo")
    private long parentDocNo;

    public long getDocument_id() {
        return document_id;
    }

    public void setDocument_id(long document_id) {
        this.document_id = document_id;
    }

    public int getDelivererID() {
        return delivererID;
    }

    public boolean isProformP() {
        return proformP;
    }

    public void setProformP(boolean proformP) {
        this.proformP = proformP;
    }

    public BigInteger getTotalVal() {
        return totalVal;
    }

    public void setTotalVal(BigInteger totalVal) {
        this.totalVal = totalVal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDatePadej() {
        return datePadej;
    }

    public void setDatePadej(Date datePadej) {
        this.datePadej = datePadej;
    }

    public PayNote getPayNote() {
        return payNote;
    }

    public void setPayNote(PayNote payNoteID) {
        this.payNote = payNoteID;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) { this.items = items; }

    public long getParentDocNo() {
        return parentDocNo;
    }

    public void setParentDocNo(long parentDocNo) {
        parentDocNo = parentDocNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(document_id, delivererID, totalVal, datePadej);
    }

    @Override
    public boolean equals(Object obj) {
        Document doc = (Document) obj;
        return this.document_id == doc.document_id &&
                this.delivererID == doc.delivererID &&
                this.totalVal == doc.totalVal &&
                this.datePadej == doc.datePadej;

    }
}

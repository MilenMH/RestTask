package com.rest.task.demo.entities.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Milen on 28.10.2019 г..
 */
@Entity
@Table(name = "payNote")
@EntityListeners(AuditingEntityListener.class)
public class PayNote  extends  AuditModel{
   // CASH, BANK_TRANSFER, BARTER, INTERCEPTION, E_PAY

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long payNote_id;

    @Column(name = "noteType")
    private String noteType;

    @OneToMany(mappedBy = "payNote", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Document> documents;

    public long getPayNote_id() {
        return payNote_id;
    }

    public void setPayNote_id(long payNote_id) {
        this.payNote_id = payNote_id;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payNote_id, noteType, documents);
    }

    @Override
    public boolean equals(Object obj) {
        PayNote doc = (PayNote) obj;
        return this.payNote_id == doc.payNote_id &&
                this.noteType == doc.noteType &&
                this.documents == doc.documents;

    }
}

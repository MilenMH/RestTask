package com.rest.task.demo.configuration;

import com.rest.task.demo.entities.core.Document;
import com.rest.task.demo.entities.core.Item;
import com.rest.task.demo.entities.core.PayNote;
import com.rest.task.demo.repositories.DocumentRepository;
import com.rest.task.demo.repositories.ItemRepository;
import com.rest.task.demo.repositories.PayNoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Milen on 29.10.2019 г..
 */
@Configuration
public class DBSeeder {

    @Bean
    boolean initDatabase(DocumentRepository documentRepository, PayNoteRepository payNoteRepository, ItemRepository itemRepository) {
        List<Document> all = documentRepository.findAll();
        if (all.size() == 0)
        {
            Item item = new Item();
            item.setCreatedAt(new Date(System.currentTimeMillis()));
            item.setArtID(1);
            item.setExpDate(new Date(System.currentTimeMillis()));
            item.setLine(1);
            item.setPriceVal(22.55D);
            item.setQty(1.0F);
            item.setSerNo("SER_N_2243");
            item.setZaDelivID(224L);
            item.setTotalVal(22.55D);
            item.setZaDelivID(554L);

            Item item2 = new Item();
            item2.setCreatedAt(new Date(System.currentTimeMillis()));
            item2.setArtID(2);
            item2.setExpDate(new Date(System.currentTimeMillis()));
            item2.setLine(1);
            item2.setPriceVal(33.55D);
            item2.setQty(1.0F);
            item2.setSerNo("SER_N_2244");
            item2.setZaDelivID(224L);
            item2.setTotalVal(33.55D);
            item2.setZaDelivID(554L);

            PayNote payNote = new PayNote();
            payNote.setNoteType("CASH");

            Document doc = new Document();
            doc.setDatePadej(new Date(System.currentTimeMillis()));
            doc.setCreatedAt(new Date(System.currentTimeMillis()));
            doc.setItems(new HashSet<>(Arrays.asList(item, item2)));
            doc.setTotalVal(new BigInteger("56"));
            doc.setNote("Note");
            doc.setPayNote(payNote);
            doc.setPayTypeName("In 60 days");
            doc.setVersion(1);

            Document doc2 = new Document();
            doc2.setDatePadej(new Date(System.currentTimeMillis()));
            doc2.setCreatedAt(new Date(System.currentTimeMillis()));
            doc2.setTotalVal(new BigInteger("56"));
            doc2.setNote("Filtered");
            doc2.setPayTypeName("In 60 days");
            doc2.setVersion(1);

            HashSet<Document> documents = new HashSet<>();
            documents.add(doc);
            payNote.setDocuments(documents);

            item.setDocuments(new HashSet<>(Arrays.asList(doc)));
            item2.setDocuments(new HashSet<>(Arrays.asList(doc)));

            payNoteRepository.save(payNote);

            itemRepository.save(item);
            itemRepository.save(item2);

            documentRepository.save(doc);
            documentRepository.save(doc2);
        }
        return true;
    }

}

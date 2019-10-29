package com.rest.task.demo.repositories;

import com.rest.task.demo.entities.core.PayNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Milen on 29.10.2019 г..
 */

@Repository
public interface PayNoteRepository extends JpaRepository<PayNote, Long> {
}
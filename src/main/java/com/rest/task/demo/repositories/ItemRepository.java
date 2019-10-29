package com.rest.task.demo.repositories;

import com.rest.task.demo.entities.core.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Milen on 29.10.2019 г..
 */

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
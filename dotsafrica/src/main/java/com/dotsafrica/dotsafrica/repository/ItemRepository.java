package com.dotsafrica.dotsafrica.repository;

import com.dotsafrica.dotsafrica.entity.Item;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}

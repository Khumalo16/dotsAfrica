package com.dotsafrica.dotsafrica.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;


import com.dotsafrica.dotsafrica.entity.AppUser;
import com.dotsafrica.dotsafrica.entity.Item;


public interface PageSortUserRepository extends CrudRepository<Item, Long> {
  Slice<Item> findByUser(AppUser user, Pageable page );
}

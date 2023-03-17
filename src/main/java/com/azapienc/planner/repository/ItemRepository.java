package com.azapienc.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azapienc.planner.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
  Item findByName(String name);
  
}

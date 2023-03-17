package com.azapienc.planner.service;

import java.util.List;

import com.azapienc.planner.domain.Item;

public interface ItemService {
  Item saveItem(Item item);
  
  Item getItem(Long id);

  List<Item> getItems();
}

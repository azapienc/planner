package com.azapienc.planner.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.azapienc.planner.domain.Item;
import com.azapienc.planner.repository.ItemRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ItemServiceImp implements ItemService{
  @Autowired
  private final ItemRepository itemRepository;

  @Override
  public Item saveItem(Item item) {
    log.info("Saving new item {}", item.getName());
    Item foundItem = itemRepository.findByName(item.getName());
    if (Objects.nonNull(foundItem)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item already exists");
    }
    return itemRepository.save(item);
  }

  @Override
  public Item getItem(Long id) {
    log.info("Getting item with {} id", id);
    return itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public List<Item> getItems() {
    log.info("Getting all items");
    return itemRepository.findAll();
  }
}

package com.azapienc.planner.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.azapienc.planner.domain.Item;
import com.azapienc.planner.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {
  @Autowired
  private final ItemService itemService;

  @GetMapping
  public ResponseEntity<List<Item>> getItems() {
    return ResponseEntity.ok().body(itemService.getItems());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Item> getItem(@PathVariable Long id) {
    return ResponseEntity.ok().body(itemService.getItem(id));
  }

  @PostMapping
  public ResponseEntity<Item> saveItem(@RequestBody Item item) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/item").toUriString());

    return ResponseEntity.created(uri).body(itemService.saveItem(item));
  }
}

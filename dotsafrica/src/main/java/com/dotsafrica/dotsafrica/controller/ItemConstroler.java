package com.dotsafrica.dotsafrica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotsafrica.dotsafrica.request.ItemRequest;
import com.dotsafrica.dotsafrica.response.ItemResponse;
import com.dotsafrica.dotsafrica.services.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api")
public class ItemConstroler {
    
    @Autowired 
    private ItemService service; 

    @PostMapping(path="/addItem")
    public ItemResponse addItem(@Valid @RequestBody ItemRequest itemRequest) {
        return this.service.addItem(itemRequest);
    }

    @GetMapping(path="/items/{username}")
    public List<ItemResponse> list(
        @PathVariable String username,
        @RequestParam Optional<String> sortBy,
        @RequestParam Optional<Integer> pageNumber,
        @RequestParam Optional<Integer> pageSize) {

        return this.service.findPaginated(username, sortBy, pageNumber, pageSize);
    }

    @GetMapping(path="/item/{username}")
    public ItemResponse getItem(@PathVariable String username, @RequestParam Optional<Long> id) {
        return this.service.findById(username, id);
    }

    @DeleteMapping(path="/item/{username}")
    public String deleteItem(@PathVariable String username, @RequestParam Optional<Long> id) {
        return this.service.deleteItem(username, id);
    }

    @PutMapping(path="/item")
    public ItemResponse updateItem(@RequestBody ItemRequest itemRequest) {
        return this.service.updateItem(itemRequest);
    }

    @PutMapping(path="/item/status/")
    public String updateStatus(@RequestBody ItemRequest itemRequest) {
        return this.service.updateStatus(itemRequest);
    }    
}

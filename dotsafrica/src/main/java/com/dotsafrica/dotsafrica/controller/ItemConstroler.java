package com.dotsafrica.dotsafrica.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<ItemResponse> addItem(@Valid @RequestBody ItemRequest itemRequest) {
        URI uri = getUri("api/addItem");
        return ResponseEntity.created(uri).body(this.service.addItem(itemRequest));
    }

    @GetMapping(path="/items/{username}")
    public ResponseEntity<List<ItemResponse>> list(
        
        @PathVariable String username,
        @RequestParam Optional<String> sortBy,
        @RequestParam Optional<Integer> pageNumber,
        @RequestParam Optional<Integer> pageSize) {

            return ResponseEntity.ok().body(this.service.findPaginated(username, sortBy, pageNumber, pageSize));
    }

    @GetMapping(path="/item/{username}")
    public ResponseEntity<ItemResponse> getItem(@PathVariable String username, @RequestParam Optional<Long> id) {
        return ResponseEntity.ok().body(this.service.findById(username, id));
    }

    @DeleteMapping(path="/item/{username}")
    public ResponseEntity<String> deleteItem(@PathVariable String username, @RequestParam Optional<Long> id) {
        return ResponseEntity.ok().body(this.service.deleteItem(username, id));
    }

    @PutMapping(path="/item")
    public ResponseEntity<ItemResponse> updateItem(@RequestBody ItemRequest itemRequest) {
        URI uri = getUri("api/item");
        return ResponseEntity.created(uri).body(this.service.updateItem(itemRequest));
    }

    @PutMapping(path="/item/status/")
    public ResponseEntity<String> updateStatus(@RequestBody ItemRequest itemRequest) {
        URI uri = getUri("api/status/");
        return ResponseEntity.created(uri).body(this.service.updateStatus(itemRequest));
    }    

    /**
     * Get url path
     * 
     * @param path path to add in http request method
     * @return http request method
     */
    public URI getUri(String path) {
        return URI.
        create(ServletUriComponentsBuilder.
        fromCurrentContextPath().path(path).
        toUriString());
    }
}

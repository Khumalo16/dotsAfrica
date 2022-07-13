package com.dotsafrica.dotsafrica.extend;

import com.dotsafrica.dotsafrica.request.ItemRequest;
import java.util.List;
import java.util.Optional;

import com.dotsafrica.dotsafrica.response.ItemResponse;

/**
 * @author Ismail
 * 
 * A class for implemeting ReSTful Application that manages a Kanban-style list of “todo” items.
 */
public interface ItemServices {


    /**
     * Adding new item in the database
     * 
     * @param itemRequest all necessary fields of the item
     */
    void addItem(ItemRequest itemRequest);

    /**
     * Making request by specified page and size number
     * 
     * @param username  the user requesting the items
     * @param sortBy    sorting of the items to be returned
     * @param pageNumber    starting page number of the items
     * @param numberSize    the size of the returned items
     * @param order order of the items to be returned
     * @return items in terms of the given parameters
     */
    List<ItemResponse> findPaginated(
        String username,
        Optional<String> sortBy, 
        Optional<Integer> pageNumber,
        Optional<Integer> numberSize,
        Optional<String> order
    );

    /**
     * Get the item by Id
     * 
     * @param username the user requestiong the item
     * @param id    the id number of the item
     * @return  item 
     */
    ItemResponse findById(String username, Optional<Long> id);

    /**
     * Delete the item by Id
     * 
     * @param username the user requestiong the item
     * @param id the id number of the item
     * @return a feedback "Deleted successful" if the item was deleted else expection is thrwon
     */
    String deleteItem(String username, Optional<Long> id);

    /**
     * Update the item
     * 
     * @param itemRequest request body contains all necessary updatable fields
     * @return the item that is updated
     */
    ItemResponse updateItem(ItemRequest itemRequest);
}

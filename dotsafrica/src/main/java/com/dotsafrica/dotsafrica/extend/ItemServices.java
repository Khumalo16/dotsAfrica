package com.dotsafrica.dotsafrica.extend;

import com.dotsafrica.dotsafrica.request.ItemRequest;
import java.util.List;
import java.util.Optional;

import com.dotsafrica.dotsafrica.response.ItemResponse;

/**
 * 
 */
public interface ItemServices {
    List<ItemResponse> findPaginated(
        String username,
        Optional<String> sortBy, 
        Optional<Integer> pageNumber,
        Optional<Integer> numberSize,
        Optional<String> order
    );

    ItemResponse findById(String username, Optional<Long> id);

    String deleteItem(String username, Optional<Long> id);

    ItemResponse updateItem(ItemRequest itemRequest);
}

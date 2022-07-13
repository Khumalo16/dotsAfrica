package com.dotsafrica.dotsafrica.extend;

import java.util.List;
import java.util.Optional;

import com.dotsafrica.dotsafrica.response.ItemResponse;

/**
 * 
 */
public interface ItemServices {
    List<ItemResponse> findPaginated(
        Optional<String> sortBy, 
        Optional<Integer> pageNumber,
        Optional<Integer> numberSize,
        Optional<String> order
    );
}

package com.dotsafrica.dotsafrica.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dotsafrica.dotsafrica.entity.Item;
import com.dotsafrica.dotsafrica.extend.ItemServices;
import com.dotsafrica.dotsafrica.repository.ItemRepository;
import com.dotsafrica.dotsafrica.request.ItemRequest;
import com.dotsafrica.dotsafrica.response.ItemResponse;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ItemService implements ItemServices {
    
    // @Autowired
    private final ItemRepository itemRepository;
    

    public void save(ItemRequest itemRequest) {
        Item  item = new Item();
        item.setLabel(itemRequest.getLabel());
        item.setDecription(itemRequest.getDescription());
        itemRepository.save(item);
    }

    @Override
    public List<ItemResponse> findPaginated(Optional<String> sortBy, Optional<Integer> pageNumber, Optional<Integer> numberSize,
            Optional<String> order) {

            List<Item> items = itemRepository.findAll(
                                    PageRequest.of(
                                    pageNumber.orElse(0),numberSize.orElse(12),
                                    Sort.Direction.ASC,
                                    sortBy.orElse("timestamp"))).toList();
      
            return items.stream().map(this::mapToItemResponse).collect(Collectors.toList());
    }

    private ItemResponse mapToItemResponse(Item item) {
       
        ItemResponse itemEntiy = new ItemResponse();
        itemEntiy.setId(item.getId());
        itemEntiy.setDescription(item.getDecription());
        itemEntiy.setLabel(item.getLabel());
        itemEntiy.setCreate_at(item.getCreate_at());
        itemEntiy.setUpdated_at(item.getUpdated_at());

        return itemEntiy;
    }  
}

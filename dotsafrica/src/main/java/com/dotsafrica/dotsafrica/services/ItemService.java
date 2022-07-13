package com.dotsafrica.dotsafrica.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dotsafrica.dotsafrica.entity.AppUser;
import com.dotsafrica.dotsafrica.entity.Item;
import com.dotsafrica.dotsafrica.extend.ItemServices;
import com.dotsafrica.dotsafrica.repository.ItemRepository;
import com.dotsafrica.dotsafrica.repository.PageSortUserRepository;
import com.dotsafrica.dotsafrica.repository.UserRepository;
import com.dotsafrica.dotsafrica.request.ItemRequest;
import com.dotsafrica.dotsafrica.response.ItemResponse;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ItemService implements ItemServices {
    
    @Autowired
    private final PageSortUserRepository itemRepositoryPageble;
    @Autowired 
    private final ItemRepository itemRepository;
    @Autowired
    private final UserRepository userRepository;

    public void addItem(ItemRequest itemRequest) {
        Item  item = new Item();
        item.setLabel(itemRequest.getLabel());
        item.setDiscription(itemRequest.getDiscription());
        Optional<AppUser> optUser = userRepository.findUserByUsername(itemRequest.getUsername());
        AppUser user = new AppUser();
        if (!optUser.isPresent())  throw new IllegalStateException("User not registered");
        user = optUser.get();
        item.setUser(user);
        item.setStatus("not started");
        itemRepository.save(item);
    }

    @Override
    public List<ItemResponse> findPaginated(String username, Optional<String> sortBy, Optional<Integer> pageNumber, Optional<Integer> numberSize,
            Optional<String> order) {
            Optional<AppUser> optUser = userRepository.findUserByUsername(username);
            System.out.println(optUser.get());
            List<Item> items =  itemRepositoryPageble.findByUser(optUser.get(),
                                    PageRequest.of(
                                    pageNumber.orElse(0),numberSize.orElse(12),
                                    Sort.Direction.ASC,
                                    sortBy.orElse("timestamp"))).toList();
            return items.stream().map(this::mapToItemResponse).collect(Collectors.toList());
    }

    private ItemResponse mapToItemResponse(Item item) {
       
        ItemResponse itemEntiy = new ItemResponse();
        itemEntiy.setId(item.getId());
        itemEntiy.setDescription(item.getDiscription());
        itemEntiy.setLabel(item.getLabel());
        itemEntiy.setCreate_at(isoDateTimeFormat(item.getTimestamp()));
        itemEntiy.setUpdated_at(isoDateTimeFormat(item.getUpdated_at()));

        return itemEntiy;
    }

    private String isoDateTimeFormat(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private Item validate(String username, Optional<Long> id) {
        if (!id.isPresent() || username == null)  throw new IllegalStateException("Username or Id not provided");
        Optional<Item> item = itemRepository.findItemById(id.get());
        if (!item.isPresent()) throw new IllegalStateException("Item with id  "+ id.get()+" is not in the database");
        if (!item.get().getUser().getUsername().equals(username)) throw new IllegalStateException(" Item not associated whith username "+ username);
        return item.get();
    }

    @Override
    public ItemResponse findById(String username, Optional<Long> id) {
        Item item = validate(username, id);
        return mapToItemResponse(item);
    }

    @Override
    public String deleteItem(String username, Optional<Long> id) {
        validate(username, id);
        itemRepository.deleteById(id.get());
        return "Deleted successful"; 
    }  

    @Override
    public ItemResponse updateItem(ItemRequest itemRequest) {
        Item item = validate(itemRequest.getUsername(), itemRequest.getId());
        if (itemRequest.getDiscription() != null) {
            item.setDiscription(itemRequest.getDiscription());
        }

        if (itemRequest.getLabel() != null) {
            item.setLabel(itemRequest.getLabel());
        }

        return mapToItemResponse(item);
    }
}

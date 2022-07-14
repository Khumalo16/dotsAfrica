package com.dotsafrica.dotsafrica.request;

import java.util.Optional;

import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class ItemRequest {
    String label;
    String description;
    String username;
    Optional<Long> id;
    Optional<String> status;
}

package com.dotsafrica.dotsafrica.request;

import java.util.Optional;

import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class ItemRequest {
    String label;
    String discription;
    String username;
    Optional<Long> id;
}

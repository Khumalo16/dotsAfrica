package com.dotsafrica.dotsafrica.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ItemResponse {
    Long id;
    String label;
    String description;
    String create_at;
    String updated_at;
}

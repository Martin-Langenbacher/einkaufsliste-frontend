package de.telekom.sea.mystuff.frontend.einkaufsliste.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {

    private Long id;
    private String name;
    private int amount;
    private String remark;
    private Date lastBought = new Date();
    private boolean needed;

}


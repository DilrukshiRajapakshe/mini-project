package com.example.wishlist.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
public class Wishlist extends SuperEntity{
    @Id
    private String wishlist_id;
    private String wishlist_name;
    private double wishlist_total_price;
    private String added_date_at;
    private String updated_date_at;
}

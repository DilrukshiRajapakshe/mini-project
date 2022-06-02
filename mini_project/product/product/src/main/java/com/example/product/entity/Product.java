package com.example.product.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
public class Product extends SuperEntity{
    @Id
    private String cart_id;
    private String wishlist_id;
    private String cart_name;
    private String added_date_at;
    private String updated_date_at;
}

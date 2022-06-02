package com.example.catalog.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
public class Catalog extends SuperEntity{
    @Id
    private String catalog_id;
    private String catalog_name;
    private String added_date_at;
    private String updated_date_at;
}

package com.alyssontiberio.sit.issue.type;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_type")
public class Type {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String description;
}

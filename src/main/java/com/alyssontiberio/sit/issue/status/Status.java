package com.alyssontiberio.sit.issue.status;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String description;
}

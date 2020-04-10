package com.alyssontiberio.sit.issue.tracker;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_tracker")
public class Tracker {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String description;
}

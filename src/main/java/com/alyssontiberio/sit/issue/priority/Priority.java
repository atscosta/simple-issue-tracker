package com.alyssontiberio.sit.issue.priority;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_priority")
public class Priority {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String description;

}

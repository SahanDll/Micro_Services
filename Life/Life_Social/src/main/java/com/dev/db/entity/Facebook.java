package com.dev.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="facebook", schema="SOCIAL")
@Data
public class Facebook {

    @Id
    private Long id;

    @Column(name="userName")
    private String userName;

    @Column(name="status")
    private String status;

    @Column(name="links")
    private String links;

    @Column(name="port")
    private int port;
}
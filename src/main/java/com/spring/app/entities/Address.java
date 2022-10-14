package com.spring.app.entities;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@SQLDelete(sql = "UPDATE addresses SET deleted = true WHERE address_id=?")
@Where(clause = "deleted=false")
@Table(name = "addresses")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street", nullable = false, length = 30)
    private String street;

    @Column(name = "street_number", nullable = false, length = 10)
    private String streetNumber;

    @Column(name = "apartment", length = 10)
    private String apartment;

    @Column(name = "postcode", nullable = false, length = 10)
    private String postcode;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "user_id")
    private User user;


}

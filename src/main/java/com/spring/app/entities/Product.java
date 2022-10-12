package com.spring.app.entities;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@SQLDelete(sql = "UPDATE products SET deleted = true WHERE product_id=?")
@Where(clause = "deleted=false")
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 140)
    private String description;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailsList = new ArrayList<>();

}

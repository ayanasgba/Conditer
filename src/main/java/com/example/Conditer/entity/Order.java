package com.example.Conditer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(name = "product_name",nullable = false)
    String productName;

    @Column(name = "quantity", nullable = false)
    Integer quantity;

    @Column(name = "phone_number",length = 12)
    String phoneNumber;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "personal_property")
    String personalProperty;
}

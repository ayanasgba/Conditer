package com.example.Conditer.entity;

import com.example.Conditer.enums.Roles;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable=false)
    String name;

    @Column(name = "email", nullable=false, unique=true)
    String email;

    @Column(name = "password", nullable=false)
    String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    Roles roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",fetch = FetchType.LAZY)
    List<Order> order;
}

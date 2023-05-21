package com.example.Conditer.dto;

import com.example.Conditer.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false,length = 120)
    private String firstName;

    @Column(name = "last_name", nullable = false,length = 120)
    private String lastName;

    @Column(name = "email", nullable = false,length = 120)
    private String email;

    @Column(name = "password", nullable = false,length = 120)
    private String password;

}

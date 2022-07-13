package com.dotsafrica.dotsafrica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "Users",
    uniqueConstraints =  {
        @UniqueConstraint(name = "username_unique", columnNames = "username")
    }    
)
    public class AppUser {
    

    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName  = "users_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    @Column(
        name = "user_pk",
        updatable = false
    )
    private Long id;

    @NotBlank(message="Username field should not be null  or empty")
    @Column(
        name = "username",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT "
    )
    private String username;
}
